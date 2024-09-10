package DesignPatterns.Creational.Factory;

public class Main {

    public static void main(String[] args){
        ShapeInstanceFactory factoryObj = new ShapeInstanceFactory();
        Shape circle = factoryObj.getShapeInstance("Circle");
        circle.computeArea();
    }
}
