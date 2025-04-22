package designpatterns.javapatterns.creational.abstractfactory;

public class LuxuryCarFactory implements CarFactory{
    @Override
    public Car getCarInstance(int value) {
        if (value > 10000) {
            return new LuxuryCar1();
        }
        return new LuxuryCar2();
    }
}
