package designpatterns.javapatterns.behavioral.chainofresponsbility;

enum LogLevel {
    DEBUG, ERROR, INFO;
}

abstract class LogProcessor{

    LogProcessor nextLogProcessor;
    LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(LogLevel loglevel, String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(loglevel,message);
        }
    }
}

class DebugLogProcessor extends LogProcessor{
    DebugLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    @Override
    public void log(LogLevel loglevel, String message){
        if(loglevel==LogLevel.DEBUG){
            System.out.println("DEBUG: "+message);
        }else{
            super.log(loglevel,message);
        }
    }
}

class ErrorLogProcessor extends LogProcessor{
    ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    @Override
    public void log(LogLevel loglevel, String message){
        if(loglevel==LogLevel.ERROR){
            System.out.println("ERROR: "+message);
        }else{
            super.log(loglevel,message);
        }
    }
}

class InfoLogProcessor extends LogProcessor{
    InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    @Override
    public void log(LogLevel loglevel, String message){
        if(loglevel==LogLevel.INFO){
            System.out.println("INFO: "+message);
        }else{
            super.log(loglevel,message);
        }
    }
}


public class Logger{
    public static void main(String[] args){
        LogProcessor logger = new DebugLogProcessor(new ErrorLogProcessor(new InfoLogProcessor(null)));
        logger.log(LogLevel.DEBUG," Debuged");
        logger.log(LogLevel.INFO," Exception occurred at line 12");
        logger.log(LogLevel.ERROR," Info");
    }
}