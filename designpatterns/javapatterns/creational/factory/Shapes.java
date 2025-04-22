package designpatterns.javapatterns.creational.factory;

public class Shapes {
    public static void main(String[] args){
        ShapeInstanceFactory factoryObj = new ShapeInstanceFactory();
        Shape circle = factoryObj.getShapeInstance("Circle");
        circle.computeArea();
    }
}
