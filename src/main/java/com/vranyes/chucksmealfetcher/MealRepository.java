package com.vranyes.chucksmealfetcher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
    // Add custom methods here if needed
}