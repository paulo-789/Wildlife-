import org.sql2o.Connection;
import java.util.List;
import java.util.Objects;

public class Animal{
    public String name;
    private String location;
    public int id;

    public Animal(String name,String location){
        this.name=name;
        this.location=location;


    }

    public String getLocation(){
        return location;
    }
    public String getName() {
        return name;
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
    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animal (name,location) VALUES (:name,:location);";
            this.id = (int) con
                    .createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("location",this.location)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
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


}
