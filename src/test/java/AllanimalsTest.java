import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
public class AllanimalsTest {

}
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void allanimals_instiatesCorrectly_true(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        assertEquals(true,testall instanceof Allanimals);
//    }
//    @Test
//    public void all_instantiatesWithName_String(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        assertEquals("lion",testall.getName());
//    }
//    @Test
//    public void all_instantiatesWithamimalid_int(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        assertEquals(1,testall.getAnimalsId());
//    }
//    @Test
//    public void  all_instantiets_with_health(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        assertEquals("okay",testall.getHealth());
//    }
//    @Test
//    public void getAge(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        assertEquals(1,testall.getAge());
//    }
//    @Test
//    public void  equals_returnsTrueifNameAndAnimalIdAreSame_true(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        Allanimals anotherall = new Allanimals("lion",1,"okay",1);
//        assertTrue(testall.equals(anotherall));
//    }
//    @Test
//    public void save_returnsTrueIftheyAreSame(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        testall.save();
//        assertTrue(Allanimals.all().get(0).equals(testall));
//    }
//    @Test
//    public void save_assighnsIdToAllanimals(){
//        Allanimals testall = new Allanimals("lion",1,"okay",1);
//        testall.save();
//        Allanimals savedAllanimals = Allanimals.all().get(0);
//        assertEquals(savedAllanimals.getId(),testall.getId());
//    }
//    @Test
//    public void return_AllInstances_true(){
//        Allanimals firstAnimal = new Allanimals("lion",1,"okay",1);
//        firstAnimal.save();
//        Allanimals secondAnimal = new Allanimals("lion",1,"okay",1);
//        secondAnimal.save();
//        assertEquals(true,Allanimals.all().get(0).equals(firstAnimal));
//        assertEquals(true,Allanimals.all().get(1).equals(secondAnimal));
//
//    }
//    @Test
//    public void find_returnsAllWithSameId_SecondAnimal(){
//        Allanimals firstAnimal = new Allanimals("lion",1,"okay",1);
//        firstAnimal.save();
//        Allanimals secondAnimal = new Allanimals("lion",1,"okay",1);
//        secondAnimal.save();
//        assertEquals(Allanimals.find(secondAnimal.getId()),secondAnimal);
//    }
//    @Test
//    public void save_saveSightIdIntoDB_true(){
//        Sighting testSighting = new Sighting(1,"Zone A","John paul");
//        testSighting.save();
//        Allanimals testAll = new Allanimals("lion",1,"okay",1);
//        testAll.save();
//        Allanimals savedAllanimal = Allanimals.find(testAll.getId());
//        assertEquals(savedAllanimal.getAnimalsId(),testSighting.getId());
//
//    }
//
//}
