package designpatterns.javapatterns.behavioral.command;

public class TurnOnAcCommand implements Command {

    private final AirConditioner ac;
    public TurnOnAcCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAc();
    }

    @Override
    public void undo() {
        ac.turnOffAc();
    }
}
