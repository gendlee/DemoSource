package chap9.factory;

public class FactoryTest {
    public  static void main(String[] args) {
        LogFactory logFactory = new FileLogFactory();
        Log log = logFactory.createLogInstance();

        log.writeLog();

        LogFactory logFactory1 = new DBLogFactory();
        Log log1 = logFactory.createLogInstance();

        log1.writeLog();
    }
}
