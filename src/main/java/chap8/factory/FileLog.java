package chap8.factory;

public class FileLog extends Log{
    @Override
    public void writeLog() {
        System.out.println("File Log is writing...");
    }
}
