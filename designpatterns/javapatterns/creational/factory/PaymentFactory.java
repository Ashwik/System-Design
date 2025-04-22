package designpatterns.javapatterns.creational.factory;

import designpatterns.javapatterns.behavioral.strategy.*;

public class PaymentFactory {
    public PaymentStrategy createPayment(String paymentType) {
        return switch (paymentType.toLowerCase()) {
            case "creditcard" -> new CreditCardPayment();
            case "paypal" -> new PayPalPayment();
            default -> throw new IllegalArgumentException("Invalid payment type: " + paymentType);
        };
    }
} 