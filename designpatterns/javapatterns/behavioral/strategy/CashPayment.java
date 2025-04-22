package designpatterns.javapatterns.behavioral.strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payment through Cash, Amount: " + amount);
    }
} 