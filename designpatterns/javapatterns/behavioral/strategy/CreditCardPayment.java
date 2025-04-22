package designpatterns.javapatterns.behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount){
        System.out.println("Payment through CreditCard, Amount: "+amount);
    }
}
