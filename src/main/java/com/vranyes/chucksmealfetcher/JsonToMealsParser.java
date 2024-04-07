package com.vranyes.chucksmealfetcher;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Calendar;

public class JsonToMealsParser {

    protected static Meal[] parseMeals(JSONObject json) {
        JSONArray mealsJson = json.getJSONArray("meals");
        Meal[] meals = new Meal[mealsJson.length()];
        Calendar mealDate = getCalendearFromString(json.getString("entrydateformatted"));
        for (int i = 0; i < mealsJson.length(); i++) {
            JSONObject mealJson = mealsJson.getJSONObject(i);
            Meal meal = parseMeal(mealJson, mealDate);
            meals[i] = meal;
        }
        return meals;
    }

    private static Meal parseMeal (JSONObject mealJson, Calendar mealDate) {
        String mealType = mealJson.getString("mealtime");
        String otherCommments = mealJson.getString("othercomments");
        String[] homeCooking = jsonStringArrayToStringArray(mealJson.getJSONArray("menudescription"));
        String[] AdditionalItems = jsonStringArrayToStringArray(mealJson.getJSONArray("specialslist"));

        Meal meal = new Meal(mealType, mealDate, otherCommments);
        return meal;
    } 

    private static HomeCooking[] stringArrayToHomeCookingArray(String[] homeCookingArray, long mealId) {
        HomeCooking[] homeCooking = new HomeCooking[homeCookingArray.length];
        for (int i = 0; i < homeCookingArray.length; i++) {
            homeCooking[i] = new HomeCooking(mealId, homeCookingArray[i]);
        }
        return homeCooking;
    }

    private static AdditionalItem[] stringArrayToAdditionalItemArray(String[] additionalItemArray, long mealId) {
        AdditionalItem[] additionalItems = new AdditionalItem[additionalItemArray.length];
        for (int i = 0; i < additionalItemArray.length; i++) {
            additionalItems[i] = new AdditionalItem(mealId, additionalItemArray[i]);
        }
        return additionalItems;
    }

    private static Calendar getCalendearFromString(String date) {
        String[] dateParts = date.split(" |, ");
        int month = monthToInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar;
    }

    private static String[] jsonStringArrayToStringArray(JSONArray jsonArray) {
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
