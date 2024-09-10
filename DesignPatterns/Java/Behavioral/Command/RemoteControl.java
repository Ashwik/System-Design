package DesignPatterns.Behavioral.Command;

import java.util.Stack;

public class RemoteControl {

    private Command command;
    Stack<Command> acCommandHistory = new Stack<>();

    RemoteControl(){

    }

    public void setCommand(Command command){
        this.command = command;
        acCommandHistory.add(command);
    }

    public void pressButton(){
        command.execute();
    }

    public void undo(){
        if(!acCommandHistory.isEmpty()){
            Command lastcommand = acCommandHistory.pop();
            lastcommand.undo();
        }
    }
}
