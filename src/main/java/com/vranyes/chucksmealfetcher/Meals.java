package com.vranyes.chucksmealfetcher;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Meals {
    @Id
    @SequenceGenerator(name = "meals_seqance", sequenceName = "meals_seqance")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meals_seqance")
    private long mealId;
    private String mealType;
    private Date mealDate;

    public Meals(long mealId, String mealType, Date mealDate) {
        this.mealId = mealId;
        this.mealType = mealType;
        this.mealDate = mealDate;
    }

    public long getMealId() {
        return mealId;
    }
    
    public void setMealId(long mealId) {
        this.mealId = mealId;
    }
    
    public String getMealType() {
        return mealType;
    }
    
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
    
    public Date getMealDate() {
        return mealDate;
    }
    
    public void setMealDate(Date mealDate) {
        this.mealDate = mealDate;
    }
    
}

