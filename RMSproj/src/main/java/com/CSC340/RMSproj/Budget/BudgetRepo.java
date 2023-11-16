package com.CSC340.RMSproj.Budget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for budget entities.
 * Provides database operations for the budget objects.
 */
public interface BudgetRepo extends JpaRepository<Budget, Long> {

}
