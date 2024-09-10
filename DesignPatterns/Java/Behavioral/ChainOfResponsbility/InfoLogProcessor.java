package DesignPatterns.Behavioral.ChainOfResponsbility;

public class InfoLogProcessor extends LogProcessor{

    InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String message){
        if(logLevel == INFO){
            System.out.println("Info: "+ message);
        }else{
            super.log(logLevel, message);
        }
    }
}
