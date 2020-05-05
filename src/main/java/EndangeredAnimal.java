import org.sql2o.*;

import java.util.List;

public class EndangeredAnimal extends Allanimals {

    public EndangeredAnimal(String name, int animalId, String health, int age) {
        this.name = name;
        this.animalId = animalId;
        this.health=health;
        this.age=age;
    }
    public String getName() {
        return name;
    }

    public int getAnimalsId() {
        return animalId;
    }
    public int getId(){
        return  id;
    }
    public String getHealth(){
        return health;
    }
    public int getAge(){return age;
    }








    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM allanimals";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM allanimals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
}
