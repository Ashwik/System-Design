package DesignPatterns.Behavioral.ChainOfResponsbility;

public class Main {
    public static void main(String []args) {
        LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logger.log(LogProcessor.INFO, "In InfoLogProcessor");
        logger.log(LogProcessor.DEBUG, "Debug Mode");
        logger.log(LogProcessor.ERROR, "Exception");
    }
}
