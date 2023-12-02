package com.CSC340.RMSproj.Employee;

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

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(long id) {
        return employeeRepo.getReferenceById(id);
    }

    public void saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public void updateEmployee(Employee updatedEmployee) {
        Employee existingEmployee = employeeRepo.getReferenceById(updatedEmployee.getId());

        if (updatedEmployee.getUsername() != null) {
            existingEmployee.setUsername(updatedEmployee.getUsername());
        }
        if (updatedEmployee.getPassword() != null) {
            existingEmployee.setPassword(passwordEncoder.encode(updatedEmployee.getPassword()));
        }
        if (updatedEmployee.getRole() != null) {
            existingEmployee.setRole(updatedEmployee.getRole());
        }

        employeeRepo.save(existingEmployee);
    }
}
