import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/lion",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"lion.hbs");
        }, new HandlebarsTemplateEngine());

        get("/elephant",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"elephant.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();  //displaying home
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        post("/elephant",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int animalid = Integer.parseInt(request.queryParams("animalid"));
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            int age = Integer.parseInt(request.queryParams("age"));
            String location= request.queryParams("location");
            EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(name,animalid,health,age,location);
            newEndangeredAnimal.save();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        post("/post",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            int animalid = Integer.parseInt(request.queryParams("animalid"));
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            Animal newAnimal = new Animal(name,animalid,location);
            newAnimal.save();
            return new ModelAndView(model,"successfull.hbs");
        }, new HandlebarsTemplateEngine());

        get("/elephantDetails",(request, response) ->{
            Map<String,Object> model = new HashMap<>();
            List<EndangeredAnimal> endangered = EndangeredAnimal.all();
            model.put("Andangered",endangered);
            return new ModelAndView(model,"elephantDetails.hbs");
        }, new HandlebarsTemplateEngine());


        get("/animalDetails",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Animal> animal = Animal.all();
            model.put("Animal",animal);
            return new ModelAndView(model,"animalDetails.hbs");
        }, new HandlebarsTemplateEngine());

    }


}
