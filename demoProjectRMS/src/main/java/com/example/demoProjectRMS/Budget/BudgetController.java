package com.example.demoProjectRMS.Budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing budget related requests.
 */
@Controller
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @GetMapping("/all")
    public String getAllItems(Model model,
                              @RequestParam(name = "continue", required = false) String cont) {
        model.addAttribute("itemList", budgetService.getAllItems());
        return "budget/list-budget";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute Budget budget) {
        budgetService.addItem(budget);
        return "redirect:/budget/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        budgetService.deleteItem(id);
        return "redirect:/budget/all";
    }

    @GetMapping("/update/id={id}")
    public String updateItemForm(@PathVariable long id, Model model) {
        Budget item = budgetService.getItemById(id);
        model.addAttribute("item", item);
        return "budget/update-item";
    }

    @PostMapping("/update")
    public String updateItem(@ModelAttribute Budget budget) {
        budgetService.updateItem(budget);
        return "redirect:/budget/all";
    }

    @PostMapping("/deleteItems")
    public String deleteAllItems(){
        budgetService.clearTable();
        return "redirect:/budget/all";
    }


}
