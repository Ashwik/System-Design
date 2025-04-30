package designpatterns.javapatterns.structural.decorator;

public class PizzaShop {
    public static void main(String[] args){
        Pizza pizza = new PlainPizza();
        ToppingsDecorator olivesPizza = new OlivesToppings(pizza);
        ToppingsDecorator cheesePizza = new CheeseToppings(olivesPizza);

        System.out.println(olivesPizza.getDescription());
        System.out.println(cheesePizza.getDescription());
    }
}
