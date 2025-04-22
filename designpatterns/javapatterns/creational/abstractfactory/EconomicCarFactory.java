package designpatterns.javapatterns.creational.abstractfactory;

public class EconomicCarFactory implements CarFactory{
    @Override
    public Car getCarInstance(int value) {

        if(value>1000){
            return new EconomicCar1();
        }
        return new EconomicCar2();
    }
}
