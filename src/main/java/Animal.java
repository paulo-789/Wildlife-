
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animal{
    public String name;
    public int animalid;
    private final String location;
    public int id;

    public Animal(String name, int animalid,String location){
        this.name=name;
        this.animalid=animalid;
        this.location=location;

    }

    public String getLocation(){
        return location;
    }
    public String getName() {
        return name;
    }
    public int getAnimalsId() {
        return animalid;
    }
    public int getId(){
        return  id;
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if(!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public static List<Animal> all() {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animal;";
            return con.createQuery(sql)
                      .executeAndFetch(Animal.class);
        }
    }
    public static Animal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animal where id=:id";
            Animal animals = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animal.class);

            return animals;
        }
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animal (name, animalid,location) VALUES (:name :animalid:location)";
            this.id = (int) con .createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("animalid",this.animalid)
                    .addParameter("location",this.location)
                    .executeUpdate()
                    .getKey();
        }
    }

}
