package com.vranyes.chucksmealfetcher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class HomeCooking {
    @Id
    @SequenceGenerator(name = "home_cooking_sequance", sequenceName = "home_cooking_sequance")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "home_cooking_sequance")
    private long HomeCookingId;
    private long mealId;
    private String itemName;

    public HomeCooking() {
    }

    protected HomeCooking(long mealId, String itemName) {
        this.mealId = mealId;
        this.itemName = itemName;
    }

    public long getHomeCookingId() {
        return HomeCookingId;
    }

    public void setHomeCookingId(long homeCookingId) {
        HomeCookingId = homeCookingId;
    }

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
}
