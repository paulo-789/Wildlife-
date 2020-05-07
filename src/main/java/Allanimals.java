//import java.util.Objects;
//import org.sql2o.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public  abstract class Allanimals {
//    public String name;
//    public int animalId;
//    public int id;
//    public String health;
//    public int age;
//    public String type;
//
////    public Allanimals(String name, int animalId,String health,int age) {
////        this.name = name;
////        this.animalId = animalId;
////        this.health=health;
////        this.age=age;
////
////    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAnimalsId() {
//        return animalId;
//    }
//    public int getId(){
//        return  id;
//    }
//    public String getHealth(){
//        return health;
//    }
//    public int getAge(){return age;
//    }
////    @Override
////    public boolean equals(Object otherAllanimals) {
////        if (!(otherAllanimals instanceof Allanimals)) {
////            return false;
////        } else {
////            Allanimals newAllanimals = (Allanimals) otherAllanimals;
////            return this.getName().equals(newAllanimals.getName())
////                    &&
////                    this.getAnimalsId() == newAllanimals.getAnimalsId();
////        }
//
//
//    }
////    public void save(){
////        try(Connection con = DB.sql2o.open()){
////            String sql = "INSERT INTO allanimals (name, animalid,health,age) VALUES (:name :animalId:health:age)";
////            this.id = (int) con .createQuery(sql,true)
////                    .addParameter("name",this.name)
////                    .addParameter("animalId",this.animalId)
////                    .addParameter("health",this.health)
////                    .addParameter("age",this.age)
////                    .executeUpdate()
////                    .getKey();
////        }
//    }
////    public static List<Allanimals> all(){
////        String sql = "SELECT * FROM allanimals";
////        try(Connection con = DB.sql2o.open()){
////            return con.createQuery(sql).executeAndFetch(Allanimals.class);
////        }
////    }
////    public static Allanimals find(int id){
////        try(Connection con = DB.sql2o.open()){
////            String sql = "SELECT * FROM allanimals where id=:id";
////            Allanimals allanimals = con.createQuery(sql)
////                    .addParameter("id",id)
////                    .executeAndFetchFirst(Allanimals.class);
////            return allanimals;
////        }
////    }
//
//
