package ru.ncedu.java.tasks;

public interface Figure {

//Абстрактный метод вывода на экран.Метод выводит характеристики фигуры
public abstract void display();
    
//Метод для перемещения.Параметр r означает на сколько мы будет двигать нашу фигуру
public void move(double r);

//Абстрактный метод масштабирования - умножения значений координат на масштабный коэффициент.
//Параметр s означает масштабный коэффициент.
public abstract void scale(double s);

//Абстрактный метод подсчета площади
public abstract double square();

}
