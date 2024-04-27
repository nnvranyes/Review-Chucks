package com.vranyes.chucksmealfetcher;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Meal {
    @Id
    @SequenceGenerator(name = "meals_seqance", sequenceName = "meals_seqance")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meals_seqance")
    private long mealId;
    private String mealType;
    private Calendar mealDate;
    private String otherComments;

    public Meal() {
    }

    public Meal(String mealType, Calendar mealDate, String otherComments) {
        this.mealType = mealType;
        this.mealDate = mealDate;
        this.otherComments = otherComments;
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
    
    public Calendar getMealDate() {
        return mealDate;
    }
    
    public void setMealDate(Calendar mealDate) {
        this.mealDate = mealDate;
    }

    public String getOtherComments() {
        return otherComments;
    }

    public void setOtherComments(String otherComments) {
        this.otherComments = otherComments;
    }
    
}

