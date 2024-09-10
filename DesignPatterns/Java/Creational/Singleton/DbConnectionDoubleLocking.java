package DesignPatterns.Creational.Singleton;

//Double-Locking
public class DbConnectionDoubleLocking {

    private static DbConnectionDoubleLocking connObj = null;
    private DbConnectionDoubleLocking() {}

    public static DbConnectionDoubleLocking getInstance() {
        if(connObj == null){
            synchronized (DbConnection.class) {
                connObj = new DbConnectionDoubleLocking();
            }
        }
        return connObj;
    }
}
