package pro.sky.java.course2.hw28.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw28.data.Employee;
import pro.sky.java.course2.hw28.exeptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }


    public void addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employees.put(createKey(lastName, firstName), employee);
    }

    public void removeEmployee(String lastName, String firstName) {
        if (!employees.containsKey(createKey(lastName, firstName))) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(createKey(lastName, firstName));
    }

    public Employee findEmployee(String lastName, String firstName) {
        if (!employees.containsKey(createKey(lastName, firstName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(createKey(lastName, firstName));
    }

    public Map<String,Employee> printEmployees() {
        return employees;
    }

    private String createKey(String lastName, String firstName) {
        return lastName + firstName;
    }

}


