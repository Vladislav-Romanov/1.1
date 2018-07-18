package app;

import app.model.ManagementSystem;
import app.entities.Employee;
import java.lang.String;
import java.sql.ResultSet;


public class Main {




    public static void main(String args[]) throws Exception {
        //считывание данных с базы данных
        ManagementSystem managementSystem=new ManagementSystem();
        System.out.println(managementSystem.getAllStudents());
        Employee employee=new Employee(6,"Alex",2222);
        managementSystem.insertEmployee(employee);
        System.out.println(managementSystem.getAllStudents());
    }

}
