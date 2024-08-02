package DesignPatterns.Behavioral.Template;

public class PayToFriend extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("logic for validating payment to friend");
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
