package DesignPatterns.Behavioral.Command;

public class TurnOffAcCommand implements Command {

    private final AirConditioner ac;
    public TurnOffAcCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOffAc();
    }

    @Override
    public void undo() {
        ac.turnOnAc();
    }
}
