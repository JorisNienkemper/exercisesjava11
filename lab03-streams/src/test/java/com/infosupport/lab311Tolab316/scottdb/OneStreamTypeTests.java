package com.infosupport.lab311Tolab316.scottdb;


import com.infosupport.streams.domain.Department;
import com.infosupport.streams.domain.Employee;
import com.infosupport.streams.domain.SalaryGrade;
import com.infosupport.streams.domain.ScottObjectDb;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class OneStreamTypeTests {

    private ScottObjectDb objectDb = new ScottObjectDb();

    private Consumer<Object> objectPrinter = x -> System.out.println(x);

    @Test
    @DisplayName("Familiarize yourself with the object model of ScottObjectDb class and the Employees, " +
                 "Departments and SalaryGrades classes.\n" +
                 "See the package com.infosupport.streams.domain in src/main/java.\n" +
                 "Disregard the DataRow types like EmployeeDataRow, that just represents data.\n" +
                 "Then, do the following exercises.\n")
    void printObjects(){

        //Print all Employees
        //Hint use  objectDb.getEmployees().stream() to enter the stream abstraction


        //Print all Departments

    }


    @Test
    @DisplayName("Find all employees with job is Clerk\n")
    void findAllTheClerks(){

       //TODO Implement test

    }
    
    @Test
    @DisplayName("Find all employees with job is Clerk and sort by salary (small to high).\n")
    void findAllClerksAndSortBySalaryAscending(){

        Comparator<? super Employee> salaryComparator = (e1, e2) -> (int)(e1.getSalary() - e2.getSalary());

        //TODO Implement test

    }

    @Test
    @DisplayName("What are all the unique jobs of the employees?\n")
    void findAllUniqueJobs(){

        //TODO Implement test
    }

    @Test
    @DisplayName("Find all employees working on department 10 and sort them by name.\n")
    void findEmployeesInDepartment10AndSortByName(){

        //TODO Implement test


    }

    @Test
    @DisplayName("Find all employees working on department 10 and sort them by name.\n" +
                 "Starting from Department each department has a list of employees.\n" +
                 "How to get rid of the list -> make it a stream too!\n" +
                 "But then we get a stream in a stream! Try to flatten it.\n")
    void findEmployeesInDepartment10AndSortByNameStartingWithDepartment(){

        //TODO Implement test, a new method is introduced the flatMap

    }




    @Test
    @DisplayName("Return one string that contains all the employeeDataRow names sorted alphabetically like this:\n" +
                 "Hello ADAMS, ALLEN, BLAKE, CLARK, FORD, JAMES, JONES, KING, MARTIN, MILLER, SCOTT, SMITH, TURNER, WARD Good Bye!\n" +
                 "Look at the Collectors class for a suitable collector!\n")
    void returnOneString(){
        //TODO Implement test
    }

    @Test
    @DisplayName("Are there any employees based in New York?\n")
    void areThereEmployeesInNewYork(){

        //TODO Implement test
    }

    @Test
    @DisplayName("Print all employees having a salary in scale 2\n")
    void printAllEmployeesInSalaryScale2(){

        //TODO Implement test

    }

    @Test
    @DisplayName("How many employees earn a salary in scale 2 or 3\n")
    void printNumberOfEmployeesInScale2or3(){

        //TODO Implement test

    }

    @Test
    @DisplayName("What's the highest value of all the salaries?\n")
    void printTopMostSalary(){

        //TODO Implement test
    }

    @Test
    @DisplayName("Who is the employee with the highest salary?\n" +
                 "What happens if there are 2 employees earning the same highest salary?\n")
    void printEmployeeHighestSalary(){

        //TODO Implement test
    }

    @Test
    @DisplayName("Find total sum of salaries for all employees.\n")
    void findTotalSumAllSalaries(){
        //TODO Implement test
    }

    @Test
    @DisplayName("Show all employees grouped by job.\n")
    void printAllEmployeesGroupedByJob(){

        //TODO Implement test

    }

    @Test
    @DisplayName("Count the number of employees for each department\n")
    void printTheNumberOfEmployeesInEachDepartment(){

        //TODO Implement test
    }

    @Test
    @DisplayName("Show all employeese for each department, each employee on a new line\n" +
                 "(use Collectors.mapping(..)).\n")
    void printEmployeesForEachDepartmentUsingCollectorsMapping(){


        //TODO Implement test

    }

    @Test
    @DisplayName("Show the highest salary for each job.\n")
    void printHighestSalaryForEachJob(){

        //TODO Implement test
    }

    @Test
    @DisplayName("For each job show the employees working there, grouped by department, like this:\n" +
                 "Job: SALESMAN\n" +
                 "DepartmentId: 30\n" +
                 "    Employee [id=(...)\n" +
                 "    (...)\n" +
                 "Job: CLERK\n" +
                 "DepartmentId: 20\n" +
                 "    Employee [id=(...)\n" +
                 "    (...)\n" +
                 "DepartmentId: 10\n" +
                 "    Employee [id=(...)\n" +
                 "    (...)\n" +
                 "(...)\n" +
                 "(...)\n")
    void printEmployeeReportAsSpecifiedAbove(){

        //TODO Implement test
    }
}
