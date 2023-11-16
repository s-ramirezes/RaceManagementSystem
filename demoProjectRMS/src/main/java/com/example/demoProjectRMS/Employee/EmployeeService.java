package com.example.demoProjectRMS.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public void saveEmployee(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepo.save(employee);
    }
}
