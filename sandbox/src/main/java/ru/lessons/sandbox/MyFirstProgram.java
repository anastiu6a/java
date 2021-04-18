package ru.lessons.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

   Point p1 = new Point(2,5);
   Point p2 = new Point(10,12);
   System.out.println("Расстояние между точками " + p1.x+";"+p1.y + " и " + p2.x+";"+p2.y + " = "  + p1.distance(p2));
  }

}




