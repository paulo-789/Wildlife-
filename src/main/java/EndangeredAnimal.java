import org.sql2o.*;

import java.util.List;

public class EndangeredAnimal extends Allanimals {
    public static final String DATABASE_TYPE = "Endangered";

    public EndangeredAnimal(String name, int animalId, String health, int age) {
        this.name = name;
        this.animalId = animalId;
        this.health=health;
        this.age=age;

        type = DATABASE_TYPE;
    }

    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM allanimals WHERE type='Endangered';";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM allanimals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
}
