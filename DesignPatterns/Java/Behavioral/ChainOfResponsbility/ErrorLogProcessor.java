package DesignPatterns.Behavioral.ChainOfResponsbility;

public class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String message){
        if(logLevel == ERROR){
            System.out.println("Error: "+ message);
        }else{
            super.log(logLevel, message);
        }
    }
}
