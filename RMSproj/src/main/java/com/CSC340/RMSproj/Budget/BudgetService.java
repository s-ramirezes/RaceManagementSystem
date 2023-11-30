package com.CSC340.RMSproj.Budget;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides methods for handling operations using budgetRepo.
 */
@Service
public class BudgetService {
    @Autowired
    private BudgetRepo budgetRepo;

    /**
     * List all the items in the budget.
     *
     * @return all the items.
     */
    public List<Budget> getAllItems() {
        return budgetRepo.findAll();
    }

    /**
     * adds up the column price in budget table
     *
     * @return total price of items
     */
    public Double getTotal(){
        return budgetRepo.itemTotal();
    }

    /**
     * Add an item to the budget.
     *
     * @param budget
     */
    public void addItem(Budget budget) {
        budgetRepo.save(budget);
    }

    /**
     * Delete an item by id.
     *
     * @param id
     */
    public void deleteItem(Long id) {
        budgetRepo.deleteById(id);
    }

    /**
     * Find an item by id.
     *
     * @param productId
     * @return the ite,
     */
    public Budget getItemById(long productId) {
        return budgetRepo.getReferenceById(productId);
    }

    /**
     * Update an item.
     *
     * @param updatedItem
     */
    public void updateItem(Budget updatedItem) {
        Budget existingItem = budgetRepo.getReferenceById(updatedItem.getId());

        if (updatedItem.getDatePurchased() != null) {
            existingItem.setDatePurchased(updatedItem.getDatePurchased());
        }
        if (updatedItem.getItemName() != null) {
            existingItem.setItemName(updatedItem.getItemName());
        }
        if (updatedItem.getDescription() != null) {
            existingItem.setDescription(updatedItem.getDescription());
        }
        if (updatedItem.getPrice() != null) {
            existingItem.setPrice(updatedItem.getPrice());
        }

        budgetRepo.save(existingItem);
    }

    /**
     * Clears the budget table.
     *
     */
    public void clearTable() {
        budgetRepo.deleteAllInBatch();
    }


}
