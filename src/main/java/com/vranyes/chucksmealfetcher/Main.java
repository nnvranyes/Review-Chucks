package com.vranyes.chucksmealfetcher;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;



@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        JsonReader jsonReader = new JsonReader();
        try {
            JSONObject json = jsonReader.readJsonFromUrl("https://www.cedarville.edu/cf/dininghall/ws.cfm?SelectedNumDays=0&format=json3");           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
