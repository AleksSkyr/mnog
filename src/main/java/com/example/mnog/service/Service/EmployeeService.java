package com.example.mnog.service.Service;

import com.example.mnog.service.Employee;
import com.example.mnog.service.exeption.EmployeeAlreadyAddedException;
import com.example.mnog.service.exeption.EmployeeNotFoundException;
import com.example.mnog.service.exeption.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeService {

    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(String firstName, String lastName, int departament) {
        if (employees.size() == LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        var key = empKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(key, new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), departament));

    }

    public Employee findEmployee(String firstName, String lastName, int departament) {
        var emp = employees.get(empKey(firstName, lastName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    public boolean removeEmployee(String firstName, String lastName, int departament) {
        Employee rem = employees.remove(empKey(firstName, lastName));
        if (rem == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }

    public Map<Integer, List<Employee>> getAll() {


        return (Map<Integer, List<Employee>>) employees.values();
    }

    private String empKey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }


}

//@Service
//public class EmployeeService {
//    private static final int LIMIT = 10;
//    private final Map<String,Employee> employee = new HashMap<>();
//
//    public Employee add(String firstNaim) {
//        Employee employee = new Employee(firstName, lastName);
//        String key = getKey(firstName,lastName);
//        if (employees.containsKey(key)) {
//            throw new EmployeeAlreadyAddedException();
//        }
//        if (employees.size() < LIMIT) {
//            employees.put(key,employee);
//            return employee;
//        }
//        throw new EmployeeStorageIsFullException();
//    }
//
//    public Employee findEmployee(String firstName, String lastName) {
//        String key = getKey(firstName,lastName);
//        if (!employees.containsKey(key)) {
//            throw new EmployeeNotFoundException();
//        }
//        return employees.get(key);
//    }
//    public Employee removeEmployee(String firstName, String lastName) {
//        String key = getKey(firstName,lastName);
//        if (!employees.containsKey(key)) {
//            throw new EmployeeNotFoundException();
//        }
//        return employees.remove(key);
//    }
//
//    public List<Employee> getAll() {
//        return new ArrayList<>(employees.values());
//    }
//    public String getKey (String firstName, String lastName){
//        return firstName+lastName;
//    }
//}
