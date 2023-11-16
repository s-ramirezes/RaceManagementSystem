package com.example.demoProjectRMS.Budget;

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
     *
     * @return
     */
    public List<Budget> getAllItems() {
        return budgetRepo.findAll();
    }

    /**
     *
     * @param budget
     */
    public void addItem(Budget budget) {
        budgetRepo.save(budget);
    }

    /**
     *
     * @param id
     */
    public void deleteItem(Long id) {
        budgetRepo.deleteById(id);
    }

    /**
     *
     * @param productId
     * @return
     */
    public Budget getItemById(long productId) {
        return budgetRepo.getReferenceById(productId);
    }

    /**
     *
     * @param updatedItem
     */
    public void updateItem(Budget updatedItem) {
        Budget existingItem = budgetRepo.findById(updatedItem.getId())
                .orElseThrow(() -> new EntityNotFoundException("Item id not found: " + updatedItem.getId()));

        existingItem.setItemName(updatedItem.getItemName());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setPrice(updatedItem.getPrice());


        budgetRepo.save(existingItem);
    }
    public void clearTable(){
        budgetRepo.deleteAllInBatch();
    }
}
