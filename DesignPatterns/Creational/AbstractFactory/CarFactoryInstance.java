package DesignPatterns.Creational.AbstractFactory;

public class CarFactoryInstance {

    public CarFactory getFactoryInstance(String value){
        if(value.equals("Premium")){
            return new LuxuryCarFactory();
        }
        return new EconomicCarFactory();
    }
}
