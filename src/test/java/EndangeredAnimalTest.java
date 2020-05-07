import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;


public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void allanimals_instiatesCorrectly_true(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kk");
        assertEquals(true,testall instanceof Allanimals);
    }
    @Test
    public void all_instantiatesWithName_String(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kk");
        assertEquals("lion",testall.getName());
    }
    @Test
    public void all_instantiatesWithamimalid_int(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kk");
        assertEquals(1,testall.getAnimalsId());
    }
    @Test
    public void  all_instantiets_with_health(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kkk");
        assertEquals("okay",testall.getHealth());
    }
    @Test
    public void getAge(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kkk");
        assertEquals(1,testall.getAge());
    }
    @Test
    public void getlocation(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kkk");
        assertEquals(1,testall.getLocation());
    }
    @Test
    public void  equals_returnsTrueifNameAndAnimalIdAreSame_true(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kk");
        EndangeredAnimal anotherall = new EndangeredAnimal("lion",1,"okay",1,"kkk");
        assertTrue(testall.equals(anotherall));
    }
    @Test
    public void save_returnsTrueIftheyAreSame(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kk");
        testall.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testall));
    }
    @Test
    public void save_assighnsIdToAllanimals(){
        EndangeredAnimal testall = new EndangeredAnimal("lion",1,"okay",1,"kk");
        testall.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(),testall.getId());
    }
    @Test
    public void return_AllInstances_true(){
        EndangeredAnimal firstAnimal = new EndangeredAnimal("lion",1,"okay",1,"kkk");
        firstAnimal.save();
        EndangeredAnimal secondAnimal = new EndangeredAnimal("lion",1,"okay",1,"kk");
        secondAnimal.save();
        assertEquals(true,EndangeredAnimal.all().get(0).equals(firstAnimal));
        assertEquals(true,EndangeredAnimal.all().get(1).equals(secondAnimal));

    }
    @Test
    public void find_returnsAllWithSameId_SecondAnimal(){
        EndangeredAnimal firstAnimal = new EndangeredAnimal("lion",1,"okay",1,"kk");
        firstAnimal.save();
        EndangeredAnimal secondAnimal = new EndangeredAnimal("lion",1,"okay",1,"kk");
        secondAnimal.save();
        assertEquals(EndangeredAnimal.find(secondAnimal.getId()),secondAnimal);
    }
    @Test
    public void save_saveSightIdIntoDB_true(){
        Sighting testSighting = new Sighting(1,"Zone A","John paul");
        testSighting.save();
        EndangeredAnimal testAll = new EndangeredAnimal("lion",1,"okay",1,"kk");
        testAll.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.find(testAll.getId());
        assertEquals(savedEndangeredAnimal.getAnimalsId(),testSighting.getId());

    }

}


