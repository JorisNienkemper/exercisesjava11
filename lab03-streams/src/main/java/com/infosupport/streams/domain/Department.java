package com.infosupport.streams.domain;

import java.util.ArrayList;
import java.util.List;

public class Department implements Comparable<Department> {
    private final int id;
    private final String name;
    private final String location;
    private List<Employee> employees;

    public Department(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public int compareTo(Department otherDepartment) {
        return Integer.valueOf(id).compareTo(otherDepartment.id);
    }
}


class DepartmentDataRow {

    private final int id;
    private final String name;
    private final String location;


    public DepartmentDataRow(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;

    }

    public Department createDepartment(){
        return new Department(id,name,location);
    }
}
