package  designpatterns.javapatterns.behavioral.command;

public class Main {
    public static void main(String[] args){
        AirConditioner airconditioner = new AirConditioner();

        RemoteControl remoteControlObj = new RemoteControl();

        remoteControlObj.setCommand(new TurnOnAcCommand(airconditioner));
        remoteControlObj.pressButton();

        remoteControlObj.undo();
    }
}
