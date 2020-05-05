
import org.sql2o.*;

import java.util.List;

public class Animal extends Allanimals{
    public static final String DATABASE_TYPE ="animal";

    public Animal(String name, int animalId){
        this.name=name;
        this.animalId=animalId;
        type = DATABASE_TYPE;
    }



    public static List<Animal> all(){
        String sql = "SELECT * FROM allanimals WHERE type='animal';";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                      .throwOnMappingFailure(false)
                      .executeAndFetch(Animal.class);
        }
    }
    public static Animal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM allanimals where id=:id";
            Animal animals = con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animal.class);

            return animals;
        }
    }
}
