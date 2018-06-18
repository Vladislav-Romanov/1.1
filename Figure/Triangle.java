package ru.ncedu.java.tasks;

public class Triangle extends FigureImpl {

Triangle(double x,double y){
    super(x,y);
}

@Override
public void display(){
    System.out.println("Длина первого катета=" + y + "Длина второго катета="+x);
}

@Override
public void move(double r){
    super.move(r);
}

@Override
public  void scale(double s){
   x=x*s;
   y=y*s;
}

@Override
public  double square(){
    return (x*y)/2;
}

}
