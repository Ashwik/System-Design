package designpatterns.javapatterns.creational.singleton;

//Eager-Initialization
public class DbConnection {

    private final static DbConnection connObj = new DbConnection();

    private DbConnection() {
    }

    public static DbConnection getInstance() {
        return connObj;
    }
}
