package DesignPatterns.Creational.Singleton;

//Lazy-Initialization
public class DbConnectionLazy {

    private static DbConnectionLazy connObj = null;
    private DbConnectionLazy() {}

    public static DbConnectionLazy getInstance() {
        if(connObj == null){
            connObj = new DbConnectionLazy();
        }
        return connObj;
    }
}
