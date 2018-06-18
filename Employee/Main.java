package ru.ncedu.java.tasks;

import java.util.Scanner;



class Main {
    public static void main(String args[]){
	Employee crd = new Employee("Vlad","Romanov","Student","1000");
        crd.addList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите должность сотрудника: ");
        String found_job = sc.nextLine();
        crd.found(found_job);
	}
}
