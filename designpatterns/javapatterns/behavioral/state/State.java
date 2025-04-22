package designpatterns.javapatterns.behavioral.state;

interface VendingMachineState{
    void pressInsertCoinButton();
    void insertCoin();
    void pressChooseProductButton();
    void chooseProduct();
    void dispense();
    void cancel();
    void refund();
}

class IdleState implements VendingMachineState{
    VendingMachine machine;
    public IdleState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void pressInsertCoinButton(){
        machine.setState(machine.getHasCoinsState());
        System.out.println("Pressed Insert Coin button");
    }
    @Override
    public void insertCoin(){
        System.out.println("Not a valid option");
    }
    @Override
    public void pressChooseProductButton(){
        System.out.println("Not a valid option");
    }
    @Override
    public void chooseProduct(){
        System.out.println("Not a valid option");
    }
    @Override
    public void dispense(){
        System.out.println("Not a valid option");
    }
    @Override
    public void cancel(){
        System.out.println("Not a valid option");
    }
    @Override
    public void refund(){
        System.out.println("Not a valid option");
    }
}

class HasCoinsState implements VendingMachineState{
    VendingMachine machine;
    private boolean coinsInserted;
    public HasCoinsState(VendingMachine machine){
        this.machine = machine;
        coinsInserted = false;
    }
    @Override
    public void pressInsertCoinButton(){
        System.out.println("Not a valid option");
    }
    @Override
    public void insertCoin(){
        System.out.println("Coins inserted");
        coinsInserted = true;
    }
    @Override
    public void pressChooseProductButton(){
        System.out.println("Pressed Choose Product button");
        coinsInserted = false;
        machine.setState(machine.getSelectionState());
    }
    @Override
    public void chooseProduct(){
        System.out.println("Not a valid option");
    }
    @Override
    public void dispense(){
        System.out.println("Not a valid option");
    }
    @Override
    public void cancel(){
        System.out.println("Cancelled");
        if(coinsInserted){
            refund();
        }else{
            machine.setState(machine.getIdleState());
        }
        
    }
    @Override
    public void refund(){
        System.out.println("Money Refunded");
        machine.setState(machine.getIdleState());
        coinsInserted = false;
    }
}

class SelectionState implements VendingMachineState{
    VendingMachine machine;
    public SelectionState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void pressInsertCoinButton(){
        System.out.println("Not a valid option");
    }
    @Override
    public void insertCoin(){
        System.out.println("Not a valid option");
    }
    @Override
    public void pressChooseProductButton(){
        System.out.println("Not a valid option");
    }
    @Override
    public void chooseProduct(){
        System.out.println("Choosen a Product");
        machine.setState(machine.getDispenseState());
    }
    @Override
    public void dispense(){
        System.out.println("Not a valid option");
    }
    @Override
    public void cancel(){
        System.out.println("Cancelled");
        refund();
    }
    @Override
    public void refund(){
        System.out.println("Money Refunded");
        machine.setState(machine.getIdleState());
    }
}

class DispenseState implements VendingMachineState{
    VendingMachine machine;
    public DispenseState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void pressInsertCoinButton(){
        System.out.println("Not a valid option");
    }
    @Override
    public void insertCoin(){
        System.out.println("Not a valid option");
    }
    @Override
    public void pressChooseProductButton(){
        System.out.println("Not a valid option");
    }
    @Override
    public void chooseProduct(){
       System.out.println("Not a valid option");
    }
    @Override
    public void dispense(){
        System.out.println("Product Dispensed");
        machine.setState(machine.getIdleState());
    }
    @Override
    public void cancel(){
        System.out.println("Not a valid option");
    }
    @Override
    public void refund(){
        System.out.println("Not a valid option");
    }
}

class VendingMachine {
    private VendingMachineState idleState;
    private VendingMachineState hasCoinsState;
    private VendingMachineState selectionState;
    private VendingMachineState dispenseState;

    private VendingMachineState currentState;

    public VendingMachine() {
        idleState = new IdleState(this);
        hasCoinsState = new HasCoinsState(this);
        selectionState = new SelectionState(this);
        dispenseState = new DispenseState(this);

        currentState = idleState;
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getHasCoinsState() {
        return hasCoinsState;
    }

    public VendingMachineState getSelectionState() {
        return selectionState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public void pressInsertCoinButton() {
        currentState.pressInsertCoinButton();
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void pressChooseProductButton() {
        currentState.pressChooseProductButton();
    }

    public void chooseProduct() {
        currentState.chooseProduct();
    }

    public void dispense() {
        currentState.dispense();
    }

    public void cancel() {
        currentState.cancel();
    }
}

public class State{
    public static void main(String[] args){
        VendingMachine vm = new VendingMachine();
        vm.pressInsertCoinButton();
        vm.insertCoin();
        vm.pressChooseProductButton();
        vm.cancel();
        System.out.println("-------------------");
        vm.pressInsertCoinButton();
        vm.insertCoin();
        vm.pressChooseProductButton();
        vm.chooseProduct();
        vm.dispense();
        System.out.println("-------------------");
        vm.pressInsertCoinButton();
        vm.cancel();
        
    }
}