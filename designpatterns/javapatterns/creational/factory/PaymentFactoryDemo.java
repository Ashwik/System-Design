package designpatterns.javapatterns.creational.factory;

import designpatterns.javapatterns.behavioral.strategy.*;

public class PaymentFactoryDemo {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new PaymentFactory();
        
        // Create different payment methods using the factory
        PaymentStrategy creditCardPayment = paymentFactory.createPayment("creditcard");
        PaymentStrategy paypalPayment = paymentFactory.createPayment("paypal");
        
        // Use the payment methods
        creditCardPayment.pay(100.0);
        paypalPayment.pay(200.0);
    }
} 