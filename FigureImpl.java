package ru.ncedu.java.tasks;


abstract class FigureImpl implements Figure {
// declare fields   
double x=0;//x-координата 
double y=0;//у-координата

//конструктор
FigureImpl(double x,double y){
    this.x=x;
    this.y=y;
}

//абстрактный метод вывода на экран
public abstract void display();
    
//метод для перемещения
public void move(double r){
    x+=r;
    y+=r;
}  

//абстрактный метод масштабирования - умножения значений координат на масштабный коэффициент
public abstract void scale(double s);

//абстрактный метод подсчета площади
public abstract double square();

}
