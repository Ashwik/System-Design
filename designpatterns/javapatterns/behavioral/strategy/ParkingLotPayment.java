package designpatterns.javapatterns.behavioral.strategy;

public class ParkingLotPayment {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.setStrategy(new CreditCardPayment());
        if (!paymentService.processPayment(50)) {
            System.out.println("Credit card payment failed, trying PayPal...");
            paymentService.setStrategy(new PayPalPayment());
            if (!paymentService.processPayment(50)) {
                System.out.println("PayPal payment failed, trying Cash...");
                paymentService.setStrategy(new CashPayment());
                paymentService.processPayment(50);
            }
        }
    }
} 