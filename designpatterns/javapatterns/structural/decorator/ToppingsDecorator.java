package designpatterns.javapatterns.structural.decorator;

public abstract class ToppingsDecorator implements Pizza {

    Pizza pizza;
    public ToppingsDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class OlivesToppings extends ToppingsDecorator{

    public OlivesToppings(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 20.0;
    }
}

class CheeseToppings extends ToppingsDecorator{

    public CheeseToppings(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}
