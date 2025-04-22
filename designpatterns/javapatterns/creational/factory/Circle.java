package designpatterns.javapatterns.creational.factory;

public class Circle implements Shape{

    @Override
    public void computeArea() {
        System.out.println("Compute Circle Area");
    }
}
