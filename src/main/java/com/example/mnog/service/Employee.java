package com.example.mnog.service;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int departament;
    private int salary;

    public Employee(String firstName, String lastName, int departament) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartament() {
        return departament;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departament=" + departament +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return departament == employee.departament && salary == employee.salary && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDepartament());
    }

}
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import java.util.Objects;
//
//public class Employee {
//
//    @JsonProperty("firstName")
//    private String name;
//    @JsonProperty("lastName")
//    private String surname;
//
//    public Employee(String name, String surname) {
//        this.name = name;
//        this.surname = surname;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname);
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "firstName='" + name + '\'' +
//                ", lastName='" + surname + '\'' +
//                '}';
//    }
//}
//
