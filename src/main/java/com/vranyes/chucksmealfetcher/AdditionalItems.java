package com.vranyes.chucksmealfetcher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;

@Entity
public class AdditionalItems {
    
    @Id
    @SequenceGenerator(name = "additional_items_sequence", sequenceName = "additional_items_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "additional_items_sequence")
    private long additionalItemId;
    private long mealId;
    private String itemName;

    public long getAdditionalItemId() {
        return additionalItemId;
    }

    public void setAdditionalItemId(long additionalItemId) {
        this.additionalItemId = additionalItemId;
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
