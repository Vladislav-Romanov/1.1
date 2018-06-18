package ru.ncedu.java.tasks;


public class Rectangle extends FigureImpl {
    
Rectangle(double x,double y){
    super(x,y);
}

@Override
public void display(){
    System.out.println("Длина=" + y + "Ширина="+x);
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
    return x*y;
}

}
