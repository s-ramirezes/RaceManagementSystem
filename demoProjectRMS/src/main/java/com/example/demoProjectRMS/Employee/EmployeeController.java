package com.example.demoProjectRMS.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
