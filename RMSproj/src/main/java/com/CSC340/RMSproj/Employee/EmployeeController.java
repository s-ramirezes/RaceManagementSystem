package com.CSC340.RMSproj.Employee;

import com.CSC340.RMSproj.Budget.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/all")
    public String getAllEmployees(Model model,
                              @RequestParam(name = "continue",required = false) String cont) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "employee/list-employee";
    }
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee/all";
    }
}
