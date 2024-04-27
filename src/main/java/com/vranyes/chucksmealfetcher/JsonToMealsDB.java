package com.vranyes.chucksmealfetcher;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;


public class JsonToMealsDB {

    private final MealRepository mealRepository;
    private final HomeCookingRepository homeCookingRepository;
    private final AdditionalItemRepository additionalItemRepository;

    public JsonToMealsDB(MealRepository mealRepository, HomeCookingRepository homeCookingRepository, AdditionalItemRepository additionalItemRepository) {
        this.mealRepository = mealRepository;
        this.homeCookingRepository = homeCookingRepository;
        this.additionalItemRepository = additionalItemRepository;
    }

    protected void parseMeals(JSONObject json) {
        JSONArray mealsJson = json.getJSONArray("meals");
        json.toString();
        Calendar mealDate = getCalendearFromString(json.getString("entrydateformatted"));
        for (int i = 0; i < mealsJson.length(); i++) {
            JSONObject mealJson = mealsJson.getJSONObject(i);
            Meal meal = parseMeal(mealJson, mealDate);
            mealRepository.save(meal);   
            long mealId = meal.getMealId();
            List<HomeCooking> homeCooking = stringArrayToHomeCookingList(jsonStringArrayToStringArray(mealJson.getJSONArray("menudescription")), mealId);
            homeCookingRepository.saveAll(homeCooking);
            List<AdditionalItem> additionalItems = stringArrayToAdditionalItemList(jsonStringArrayToStringArray(mealJson.getJSONArray("specialslist")), mealId);
            additionalItemRepository.saveAll(additionalItems);
        }
    }


    private Meal parseMeal (JSONObject mealJson, Calendar mealDate) {
        String mealType = mealJson.getString("mealtime");
        String otherCommments = mealJson.getString("othercomments");
        Meal meal = new Meal(mealType, mealDate, otherCommments);
        
        return meal;
    } 

    private List<HomeCooking> stringArrayToHomeCookingList(String[] homeCookingArray, long mealId) {
        List<HomeCooking> homeCookingList = new ArrayList<>();
        for (int i = 0; i < homeCookingArray.length; i++) {
            homeCookingList.add(new HomeCooking(mealId, homeCookingArray[i]));
        }
        return homeCookingList;
    }

    private List<AdditionalItem> stringArrayToAdditionalItemList(String[] additionalItemArray, long mealId) {
        List<AdditionalItem> additionalItems = new ArrayList<>();
        for (int i = 0; i < additionalItemArray.length; i++) {
            additionalItems.add(new AdditionalItem(mealId, additionalItemArray[i]));
        }
        return additionalItems;
    }

    private Calendar getCalendearFromString(String date) {
        String[] dateParts = date.split(" |, ");
        int month = monthToInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar;
    }

    private String[] jsonStringArrayToStringArray(JSONArray jsonArray) {
        String[] stringArray = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            stringArray[i] = jsonArray.getString(i);
        }
        return stringArray;
    }

    

    private static int monthToInt(String month) {
        switch (month.toLowerCase()) {
            case "january":
                return 0;
            case "february":
                return 1;
            case "march":
                return 2;
            case "april":
                return 3;
            case "may":
                return 4;
            case "june":
                return 5;
            case "july":
                return 6;
            case "august":
                return 7;
            case "september":
                return 8;
            case "october":
                return 9;
            case "november":
                return 10;
            case "december":
                return 11;
            default:
                return -1;
        }
    }
}
