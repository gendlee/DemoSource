package chap9.designPattern.factory;

public class FileLogFactory extends LogFactory{
    @Override
    public Log createLogInstance() {
        System.out.println("create File Log Factory");
        return new FileLog();
    }
}
