
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void allanimals_instiatesCorrectly_true(){
        Animal testall = new Animal("lion","kk");
        assertEquals(true,testall instanceof Animal);
    }
    @Test
    public void all_instantiatesWithName_String(){
        Animal testall = new Animal("lion","kk");
        assertEquals("lion",testall.getName());
    }

    @Test
    public void getlocation(){
        Animal testall = new Animal("lion","kk");
        assertEquals("kk",testall.getLocation());
    }


    @Test
    public void  equals_returnsTrueifNameAndAnimalIdAreSame_true(){
        Animal testall = new Animal("","kk");
        Animal anotherall = new Animal("","kk");
        assertTrue(testall.equals(anotherall));
    }
    @Test
    public void save_returnsTrueIftheyAreSame(){
        Animal testall = new Animal("","kk");
        testall.save();
        assertTrue(Animal.all().get(0).equals(testall));
    }
    @Test
    public void save_assighnsIdToAllanimals(){
        Animal testall = new Animal("","kk");
        testall.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(savedAnimal.getId(),testall.getId());
    }
    @Test
    public void return_AllInstances_true(){
        Animal firstAnimal = new Animal("","kk");
        firstAnimal.save();
        Animal secondAnimal = new Animal("","kk");
        secondAnimal.save();
        assertEquals(true,Animal.all().get(0).equals(firstAnimal));
        assertEquals(true,Animal.all().get(1).equals(secondAnimal));

    }
    @Test
    public void find_returnsAllWithSameId_SecondAnimal(){
        Animal firstAnimal = new Animal("","kk");
        firstAnimal.save();
        Animal secondAnimal = new Animal("","kk");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()),secondAnimal);
    }
//    @Test
//    public void save_saveSightIdIntoDB_true(){
//        Sighting testSighting = new Sighting(1,"Zone A","John paul");
//        testSighting.save();
//        Animal testAll = new Animal("","kk");
//        testAll.save();
//        Animal savedAnimal= Animal.find(testAll.getId());
//        assertEquals(savedAnimal.getAnimalsId(),testSighting.getId());
//
//    }
}
