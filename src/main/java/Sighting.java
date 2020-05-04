import java.util.Objects;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Sighting {
    private int animal_id;
    private String location;
    private String rangername;
    private int id;

    public Sighting(int animal_id,String location,String rangername){
        this.animal_id=animal_id;
        this.location=location;
        this.rangername=rangername;
    }

    public int getAnimalid(){
        return animal_id;
    }
    public String getLocation(){
        return location;
    }
    public String getRangername(){
        return rangername;
    }
    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object secondSighting) {
        if (!(secondSighting instanceof Sighting)){
            return false;
        }else{
            Sighting newSighting=(Sighting)secondSighting;
            return  this.getRangername().equals(newSighting.getRangername())
                    &&
                    this.getLocation().equals(newSighting.getLocation());
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(animal_id, location, rangername);
    }

    public void save(){
        try(Connection con=DB.sql2o.open()){
            String sql = "INSERT INTO sightings(animal_id,rangername,location) VALUES (:animal_id,:rangername,:location)";
           this.id = (int) con.createQuery(sql,true)
                    .addParameter("animal_id",this.animal_id)
                    .addParameter("rangername",this.rangername)
                    .addParameter("location",this.location)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting>all(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con .createQuery(sql).executeAndFetch(Sighting.class);
        }
    }
}
