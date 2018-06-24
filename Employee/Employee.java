package ru.ncedu.java.tasks;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Employee  {
//private field
private String second_name=null;     //фамилия
private String first_name=null;	//имя
private String job=null;             //должность
private int  salary=0;             //зарплата
ArrayList<Employee> Emp_List = new ArrayList<Employee>();
String job_f = null;


//конструктор
public Employee(String second_name,String first_name,String job,int salary) { 
    this.second_name = second_name;
    this.first_name = first_name;
    this.job = job;
    this.salary = salary;
}



//заполнение контейнера данными с клавиатуры
public void setEmployee(){
    
    System.out.println();
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Введите фамилию сотрудника: ");
    second_name = sc.nextLine();
    
    System.out.println("Введите имя сотрудника: ");
    first_name = sc.nextLine();
    
    System.out.println("Введите должность сотрудника: ");
    job = sc.nextLine();
    
    
    System.out.println("Введите зарплату сотрудника : ");
    salary = sc.nextInt();
    
    Emp_List.add(new Employee(second_name,first_name,job,salary));
}


public String getSecond_name(){
	return second_name;
}

public String getFirst_name(){
	return first_name;
}

public String getJob(){
	return job;
}

public int getSalary(){
	return salary;
}



//вывод информации о сотрудниках на экран
public void display(){
   for(int i=0;i<Emp_List.size();i++){
    System.out.println(Emp_List.get(i).toString());
   }
}

public String toString()
{ 
    return "Фамилия-"+this.second_name+" Имя-"+this.first_name+" Должность-"+this.job+" Зарплата-"+this.salary;
}

//поиск сотрудников, состоящих на заданной должности
public void job(String job_f){
    boolean f = false;
    for (int i=0; i<Emp_List.size();i++) {
        f=Emp_List.get(i).toString().contains(job_f);
        if(f == true){
            System.out.println(Emp_List.get(i).toString());
            f = false;
        }
    } 

}


//сортировку списка сотрудников по полю фамилия и по полю зарплата.






}













