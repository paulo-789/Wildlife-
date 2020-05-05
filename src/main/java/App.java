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
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"lion.hbs");
        }, new HandlebarsTemplateEngine());

        get("/elephant",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"elephant.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();  //displaying home
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        post("/elephant",(request, response) -> {
            Map<String, Object>model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String health = request.queryParams("health");
            int age = Integer.parseInt(request.queryParams("age"));
            EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(name,animalId,health,age);
            model.put("endangered",newEndangeredAnimal);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        post("/post",(request, response) -> {
            Map<String,Object>model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            Animal newAnimal = new Animal(name,animalId);
            model.put("animal",newAnimal);
            return new ModelAndView(model,"successfull.hbs");
        }, new HandlebarsTemplateEngine());

        get("/elephantDetails",(request, response) ->{
            Map<String,Object> model = new HashMap<String, Object>();
            List<EndangeredAnimal> endangered = EndangeredAnimal.all();
            model.put("endangered",endangered);
            return new ModelAndView(model,"elephantDetails.hbs");
        }, new HandlebarsTemplateEngine());
        get("/animalDetails",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            List<Animal> animal = Animal.all();
            model.put("animal",animal);
            return new ModelAndView(model,"animalDetails.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
