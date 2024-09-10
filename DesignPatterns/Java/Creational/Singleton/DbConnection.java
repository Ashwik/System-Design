package DesignPatterns.Creational.Singleton;

//Eager-Initialization
public class DbConnection {

    private static DbConnection connObj = new DbConnection();
    private DbConnection() {}

    public static DbConnection getInstance() {
        return connObj;
    }
}
