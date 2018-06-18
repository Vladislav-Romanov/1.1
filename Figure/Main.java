package ru.ncedu.java.tasks;

import java.util.Scanner;

class Main {
    public static void main(String args[]){
		System.out.print("Введите любое целое число от 1 до 10: ");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println ("Вы ввели число " + number);
	}
}

