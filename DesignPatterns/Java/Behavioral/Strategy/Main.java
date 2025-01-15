
interface PaymentStrategy{
    public void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Payment by Credit Card: "+amount);
    }
}


class PaypalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Payment by Paypal: "+amount);
    }
}

class PaymentService{
    private PaymentStrategy strategy;
    void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }
    void pay(double amount){
        strategy.pay(amount);
    }
}


public class Main{
    public static void main(String[] args){
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        PaymentStrategy paypalPayment = new PaypalPayment();
        
        PaymentService paymentService = new PaymentService();
        
        paymentService.setStrategy(creditCardPayment);
        paymentService.pay(10);

        paymentService.setStrategy(paypalPayment);
        paymentService.pay(200.0);
    }
}