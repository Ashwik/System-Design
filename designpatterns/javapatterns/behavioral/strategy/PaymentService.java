package designpatterns.javapatterns.behavioral.strategy;

public class PaymentService{
    private PaymentStrategy strategy;
    void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }
    void pay(double amount){
        strategy.pay(amount);
    }

    boolean processPayment(double amount) {
        try {
            strategy.pay(amount);
            return true;
        } catch (Exception e) {
            System.out.println("Payment failed: " + e.getMessage());
            return false;
        }
    }
}
