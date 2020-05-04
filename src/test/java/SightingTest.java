import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;


public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true(){
      Sighting testSighting = new Sighting(1,"Zone A","John paul");
      assertEquals(true,testSighting instanceof Sighting);
    }
    @Test
    public void getanimalid(){
        Sighting testSighting = new Sighting(1,"Zone A","John paul");
        assertEquals(1,testSighting.getAnimalid());
    }
    @Test
    public void getLocation(){
        Sighting testSighting = new Sighting(1,"Zone A","John paul");
        assertEquals("Zone A",testSighting.getLocation());
    }
    @Test
    public void getrangerName(){
        Sighting testSighting = new Sighting(1,"Zone A","John paul");
        assertEquals("John paul",testSighting.getRangername());
    }
    @Test
    public void equals(){
        Sighting firstSighting = new Sighting(1,"Zone A","John paul");
        Sighting secondSighting = new Sighting(1,"Zone A","John paul");
        assertTrue(firstSighting.equals(secondSighting));
    }
    @Test
    public void save_insertObjectIntoDatabase_Sighting(){
        Sighting testSighting = new Sighting(1,"Zone A","John paul");
        testSighting.save();
        assertTrue(Sighting.all().get(0).equals(testSighting));
    }
    @Test
    public void all_returnAllInstancesOfSighting_true(){
        Sighting firstSighting = new Sighting(1,"Zone A","John paul");
        firstSighting.save();
        Sighting secondSighting = new Sighting(1,"Zone A","John paul");
        secondSighting.save();
        assertEquals(true,Sighting.all().get(0).equals(firstSighting));
        assertEquals(true,Sighting.all().get(1).equals(secondSighting));
    }
    @Test
    public void save_assignsIdToObject(){
        Sighting testSighting = new Sighting(1,"Zone A","John paul");
        testSighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(testSighting.getId(),savedSighting.getId());
    }
}
