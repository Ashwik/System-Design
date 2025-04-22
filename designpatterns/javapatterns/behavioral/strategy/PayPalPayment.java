package designpatterns.javapatterns.behavioral.strategy;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Payment through Paypal, Amount: "+amount);
    }
}
