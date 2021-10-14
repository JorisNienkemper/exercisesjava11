package com.infosupport.streams.domain;

import java.time.LocalDate;
import java.util.*;

public class ScottObjectDb{
    private final List<Department> departments = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<SalaryGrade> salaryGrades = new ArrayList<>();

    public ScottObjectDb() {
        var scottDB = new ScottDB();
        var employeeDataRows = scottDB.getEmployeeDataRows();
        var departmentDataRows = scottDB.getDepartmentDataRows();
        var salaryGradeDataRows = scottDB.getSalaryGradeDataRows();
        mapRowsToObjects(employeeDataRows,departmentDataRows,salaryGradeDataRows);

    }

    private void mapRowsToObjects(List<EmployeeDataRow> employeeDataRowRows, List<DepartmentDataRow> departmentDataRowRows, List<SalaryGradeData> salaryGradeDataRows) {

        Map<Integer,Department> departmentByIdMap= new HashMap<>();

        Map<Integer, Employee> employeeByIdMap = new HashMap<>();

        for(SalaryGradeData salaryGradeData: salaryGradeDataRows){
            var salaryGrade = salaryGradeData.createSalaryGrade();
            salaryGrades.add(salaryGrade);
        }
        for(DepartmentDataRow departmentDataRow : departmentDataRowRows){
            var department = departmentDataRow.createDepartment();
            departments.add(department);
            departmentByIdMap.put(department.getId(),department);
        }


        for(EmployeeDataRow employeeDataRow : employeeDataRowRows){
            var employee = employeeDataRow.createEmployee();
            employees.add(employee);
            employeeByIdMap.put(employee.getId(),employee);
            linkEmployeeToItsManager(employeeByIdMap, employeeDataRow, employee);
            linkEmployeeToItsDepartmentAndVisaVersa(departmentByIdMap, employeeDataRow, employee);
        }
    }
    //Employee <--> Department is bi-directional
    private void linkEmployeeToItsDepartmentAndVisaVersa(Map<Integer, Department> departmentByIdMap, EmployeeDataRow employeeDataRow, Employee employee) {
        var departmentOfEmployee = departmentByIdMap.get(employeeDataRow.getDepartmentId());
        employee.setDepartment(departmentOfEmployee);
        departmentOfEmployee.getEmployees().add(employee);
    }
    //Employee --> Manager is uni-directional
    private void linkEmployeeToItsManager(Map<Integer, Employee> employeeByIdMap, EmployeeDataRow employeeDataRow, Employee employee) {
        if(employeeDataRow.getManagerId() != null){
            employee.setManager(employeeByIdMap.get(employeeDataRow.getManagerId()));
        }
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<SalaryGrade> getSalaryGrades() {
        return salaryGrades;
    }

    private class ScottDB {

        private final List<DepartmentDataRow> departmentDatumRows;
        private final List<EmployeeDataRow> employeeDatumRows;
        private final List<SalaryGradeData> salaryGradeData;

        ScottDB() {
            this.departmentDatumRows = Arrays.asList(
                    new DepartmentDataRow(10, "ACCOUNTING", "NEW YORK"),
                    new DepartmentDataRow(20, "RESEARCH", "DALLAS"),
                    new DepartmentDataRow(30, "SALES", "CHICAGO"),
                    new DepartmentDataRow(40, "OPERATIONS", "BOSTON")
            );
            this.salaryGradeData = Arrays.asList(
                    new SalaryGradeData(1, 700, 1200),
                    new SalaryGradeData(2, 1201, 1400),
                    new SalaryGradeData(3, 1401, 2000),
                    new SalaryGradeData(4, 2001, 3000),
                    new SalaryGradeData(5, 3001, 9999)
            );
            this.employeeDatumRows = setEmployees();
        }

        List<DepartmentDataRow> getDepartmentDataRows() {
            return departmentDatumRows;
        }

        List<EmployeeDataRow> getEmployeeDataRows() {
            return employeeDatumRows;
        }

        List<SalaryGradeData> getSalaryGradeDataRows() {
            return salaryGradeData;
        }

        private List<EmployeeDataRow> setEmployees() {
            //List is ordered, the highest manager is the first entry in the list and so on.
            return Arrays.asList(
                    new EmployeeDataRow(7839, null, LocalDate.of(1981, 11, 17), "KING", "PRESIDENT", 5000, null, 10),
                    new EmployeeDataRow(7566, null, LocalDate.of(1981, 4, 2), "JONES", "MANAGER", 2975, 7839, 20),
                    new EmployeeDataRow(7698, null, LocalDate.of(1981, 5, 1), "BLAKE", "MANAGER", 2850, 7839, 30),
                    new EmployeeDataRow(7782, null, LocalDate.of(1981, 6, 9), "CLARK", "MANAGER", 2450, 7839, 10),
                    new EmployeeDataRow(7902, null, LocalDate.of(1981, 12, 3), "FORD", "ANALYST", 3000, 7566, 20),
                    new EmployeeDataRow(7788, null, LocalDate.of(1987, 4, 19), "SCOTT", "ANALYST", 3000, 7566, 20),
                    new EmployeeDataRow(7369, null, LocalDate.of(1980, 12, 17), "SMITH", "CLERK", 800, 7902, 20),
                    new EmployeeDataRow(7499, 300., LocalDate.of(1981, 2, 20), "ALLEN", "SALESMAN", 1600, 7698, 30),
                    new EmployeeDataRow(7521, 500., LocalDate.of(1981, 2, 22), "WARD", "SALESMAN", 1250, 7698, 30),
                    new EmployeeDataRow(7654, 1400., LocalDate.of(1981, 9, 28), "MARTIN", "SALESMAN", 1250, 7698, 30),
                    new EmployeeDataRow(7844, 0., LocalDate.of(1981, 9, 8), "TURNER", "SALESMAN", 1500, 7698, 30),
                    new EmployeeDataRow(7876, null, LocalDate.of(1987, 5, 23), "ADAMS", "CLERK", 1100, 7788, 20),
                    new EmployeeDataRow(7900, null, LocalDate.of(1981, 12, 3), "JAMES", "CLERK", 950, 7698, 30),
                    new EmployeeDataRow(7934, null, LocalDate.of(1982, 1, 23), "MILLER", "CLERK", 1300, 7782, 10)
            );
        }
    }
}


