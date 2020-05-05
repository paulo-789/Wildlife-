import java.util.ArrayList;
import java.util.HashMap;
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
        },new HandlebarsTemplateEngine());

        get("/elephant",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"elephant.hbs");
        },new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();  //displaying home
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        post("/post",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
        })


    }


}
