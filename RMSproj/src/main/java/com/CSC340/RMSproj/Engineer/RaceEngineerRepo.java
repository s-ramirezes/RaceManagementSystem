package com.CSC340.RMSproj.Engineer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaceEngineerRepo extends JpaRepository<RaceEngineer, Long> {
    Optional<RaceEngineer> findById(Long aLong);
}
