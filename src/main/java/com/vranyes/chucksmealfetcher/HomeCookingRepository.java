package com.vranyes.chucksmealfetcher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeCookingRepository extends JpaRepository<HomeCooking, Long> {
    // Add custom methods here if needed
}