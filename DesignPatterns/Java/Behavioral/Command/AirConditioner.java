package DesignPatterns.Behavioral.Command;

public class AirConditioner {

    private boolean isOn;
    int temperature;

    public void turnOnAc(){
        isOn = true;
        System.out.println("AC is turned on");
    }

    public void turnOffAc(){
        isOn = false;
        System.out.println("AC is turned of");
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
        System.out.println("AC temperature: "+temperature);
    }
}
