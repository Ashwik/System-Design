package designpatterns.javapatterns.creational.singleton;

//Double-Locking
public class DbConnectionDoubleLocking {

    private static DbConnectionDoubleLocking connObj = null;

    private DbConnectionDoubleLocking() {
    }

    public static DbConnectionDoubleLocking getInstance() {
        if (connObj == null) {
            synchronized (DbConnection.class) {
                if (connObj == null) {
                    connObj = new DbConnectionDoubleLocking();
                }
            }
        }
        return connObj;
    }
}
