package DesignPatterns.Behavioral.ChainOfResponsbility;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String message){
        if(logLevel == DEBUG){
            System.out.println("Debug: "+ message);
        }else{
            super.log(logLevel, message);
        }
    }
}
