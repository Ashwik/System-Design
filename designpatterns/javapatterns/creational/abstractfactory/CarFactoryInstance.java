package designpatterns.javapatterns.creational.abstractfactory;

public class CarFactoryInstance {

    public CarFactory getFactoryInstance(String value){
        if(value.equals("Premium")){
            return new LuxuryCarFactory();
        }
        return new EconomicCarFactory();
    }
}
