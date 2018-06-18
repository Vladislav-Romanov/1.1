package ru.ncedu.java.tasks;

public class Circle extends FigureImpl{
// declare fields  
double x_r=0;//координата х для определения радиуса круга
double y_r=0;//координата у для определения радиуса круга

Circle(double x,double y,double x_r,double y_r){
super(x,y);
this.x_r=x_r;
this.y_r=y_r;
}

@Override
public void display(){
    System.out.println("Координата y центра окружности=" + y + "Координата x центра окружности="+x);
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

public double radius(double x_l,double y_l){
return Math.sqrt(Math.pow(x_l-x,2)+Math.pow(y_l-y,2));
}

@Override
public  double square(){
    return Math.pow(radius(x_r,y_r),2)*Math.PI;
}

public void chek_tochka(double x_t,double y_t){
    if(radius(x_r,y_r)>radius(x_t,y_t)){
        System.out.println("Точка  входит в окружность");
    }
    else{
        System.out.println("Точка не входит в окружность");
    }
}

//Проверка того что круг находится полностью в нашем круге
public void chek_circle(double x_o,double y_o){
    if(radius(x_r,y_r)>radius(x_o, y_o)){
        System.out.println("Точка  находится в окружности");
    }
    else{
        System.out.println("Точка не находится в окружности");
    }
    
}

/*
Проверка того что круг находится в кругу частично
public void chek_circle2(double x_o,double y_o){
double z=Math.sqrt(Math.pow(x-x_o,2)+Math.pow(y-y_o,2));
if(z<radius(x_r,y_r)+radius(x_o,y_o)){
    System.out.println("Круг частично находится в окружности");
}
else{
    System.out.println("Круг не находится находится в окружности");
}
}
*/


}
