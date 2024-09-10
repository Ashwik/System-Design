package DesignPatterns.Behavioral.Template;

public class PayMerchant extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("logic for validating payment to merchant");
    }

    @Override
    public void debitAmount() {

    }

    @Override
    public void calculateFees() {

    }

    @Override
    public void creditAmount() {

    }
}
