package com.vranyes.chucksmealfetcher;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import java.util.List;






@SpringBootApplication
@RestController
@EnableScheduling
public class Main {
    private static final String url = "https://www.cedarville.edu/cf/dininghall/ws.cfm?SelectedNumDays=0&format=json3";
    private final MealRepository mealRepository;
    private final HomeCookingRepository homeCookingRepository;
    private final AdditionalItemRepository additionalItemRepository;
    private final JsonReader jsonReader = new JsonReader(url);

    public Main(MealRepository mealRepository, HomeCookingRepository homeCookingRepository, AdditionalItemRepository additionalItemRepository) {
        this.mealRepository = mealRepository;
        this.homeCookingRepository = homeCookingRepository;
        this.additionalItemRepository = additionalItemRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); 
    }

    @GetMapping("/meals")
    public List<Meal> getMeals(){
        return mealRepository.findAll();
    }

    @GetMapping("/homecooking")
    public List<HomeCooking> getMethodName() {
        return homeCookingRepository.findAll();
    }

    @GetMapping("/additionalitems")
    public List<AdditionalItem> getAdditionalItems() {
        return additionalItemRepository.findAll();
    }
    

    @Scheduled(cron = "0 0 0 * * ?")
    public int fetchDailyMeals(){
        JsonToMealsDB jsonToMealsDB = new JsonToMealsDB(mealRepository, homeCookingRepository, additionalItemRepository);
        try {
            JSONObject json = jsonReader.readJsonFromUrl();
            jsonToMealsDB.parseMeals(json);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
    
    
}
