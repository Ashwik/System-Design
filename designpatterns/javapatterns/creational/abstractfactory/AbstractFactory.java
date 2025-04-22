package designpatterns.javapatterns.creational.abstractfactory;

public class AbstractFactory {

    public static void main(String[] args){

        CarFactoryInstance carFactoryInstance = new CarFactoryInstance();
        CarFactory carFactoryObj = carFactoryInstance.getFactoryInstance("Premium");
        Car carObj = carFactoryObj.getCarInstance(20000);
        System.out.println(carObj.getTopSpeed());
    }
}
