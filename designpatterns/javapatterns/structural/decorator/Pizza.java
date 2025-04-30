package designpatterns.javapatterns.structural.decorator;

public interface Pizza {
    public String getDescription();
    public double getCost();
}

class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}

