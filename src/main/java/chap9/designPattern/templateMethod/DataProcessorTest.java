package chap9.designPattern.templateMethod;

public class DataProcessorTest  {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();

        DataProcessor dbProcessor = new DatabaseDataProcessor();
        dbProcessor.process();
    }
}
