package chap8.factory;

public class DBLogFactory extends LogFactory{
    @Override
    public Log createLogInstance() {
        System.out.println("create DB Log Factory");
        return new DBLog();
    }
}
