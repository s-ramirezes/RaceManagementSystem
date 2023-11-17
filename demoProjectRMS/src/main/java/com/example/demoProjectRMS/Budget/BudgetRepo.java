package com.example.demoProjectRMS.Budget;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for budget entities.
 * Provides database operations for the budget objects.
 */
public interface BudgetRepo extends JpaRepository<Budget, Long> {

}
