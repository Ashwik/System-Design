package DesignPatterns.Creational.AbstractFactory;

public class Main {

    public static void main(String[] args){

        CarFactoryInstance carFactoryInstance = new CarFactoryInstance();
        CarFactory carFactoryObj = carFactoryInstance.getFactoryInstance("Premium");
        Car carObj = carFactoryObj.getCarInstance(20000);
        System.out.println(carObj.getTopSpeed());
    }
}
