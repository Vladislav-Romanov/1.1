package ru.ncedu.java.tasks;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Employee {
//private field
private String second_name;     //фамилия
private String first_name;	//имя
private String job;             //должность
private String salary;             //зарплата
ArrayList<String> Emp_List;

//конструктор
Employee(String second_name,String first_name,String job,String salary) { 
    this.second_name = second_name;
    this.first_name = first_name;
    this.job = job;
    this.salary = salary;
}

public String setEmployee(){
    
    System.out.println();
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Введите фамилию сотрудника: ");
    second_name = sc.nextLine();
    
    System.out.println("Введите имя сотрудника: ");
    first_name = sc.nextLine();
    
    System.out.println("Введите должность сотрудника: ");
    job = sc.nextLine();
     
    System.out.println("Введите зарплату сотрудника : ");
    salary = sc.nextLine();
    
    return second_name + " " + first_name + " " + job + " " + salary;
}

//заполнение контейнера данными с клавиатуры
public void  addList(){
ArrayList<String> Emp_List = new ArrayList<>();
Emp_List.add(setEmployee());
}

//вывод информации о сотрудниках на экран
public void display(){
for (int i = 0; i < Emp_List.size(); i++) {
    System.out.println(Emp_List.get(i));
}
}

//поиск сотрудников, состоящих на заданной должности
public void found(String found_job) {
    try {      
    int in=Emp_List.indexOf(found_job);
    System.out.println(Emp_List.get(in));
    
    } catch (NullPointerException e){
    System.out.println("Робота не выбрана");    
    }
          
}

//сортировку списка сотрудников по полю фамилия и по полю зарплата.
public void sort(){
    
}
}
