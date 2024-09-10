package DesignPatterns.Creational.Singleton;

//Synchronized-Method
public class DbConnectionSync {

    private static DbConnectionSync connObj = null;
    private DbConnectionSync() {}

    synchronized public static DbConnectionSync getInstance() {
        if(connObj == null){
            connObj = new DbConnectionSync();
        }
        return connObj;
    }
}
