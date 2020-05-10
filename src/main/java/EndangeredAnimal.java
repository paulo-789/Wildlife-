import org.sql2o.*;

import java.util.List;

public class EndangeredAnimal {
    public String name;
    public int animalid;
    public int id;
    public String health;
    public int age;
    private String location;

    public EndangeredAnimal(int animalid, String name, String health, int age,String location) {
        this.name = name;
        this.animalid = animalid;
        this.health=health;
        this.age=age;
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
    public String getHealth(){
        return health;
    }
    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object otherAnimal) {
        if(!(otherAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newAnimal = (EndangeredAnimal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }
    public static List<EndangeredAnimal> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM endangered";
            return con.createQuery(sql)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM endangered where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO endangered (animalid,name,health,age,location) VALUES (:animalid, :name,:health,:age,:location);";
            this.id = (int) con .createQuery(sql,true)
                    .addParameter("animalid",this.animalid)
                    .addParameter("name",this.name)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .addParameter("location",this.location)
                    .executeUpdate()
                    .getKey();
        }
    }
}
