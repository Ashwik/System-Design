package designpatterns.javapatterns.behavioral.strategy;
public class Payment{
    public static void main(String[] args){
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        PaymentStrategy paypalPayment = new PayPalPayment();

        PaymentService paymentService = new PaymentService();

        paymentService.setStrategy(creditCardPayment);
        paymentService.pay(10);

        paymentService.setStrategy(paypalPayment);
        paymentService.pay(200.0);
    }
}