package chap8.templateMethod;

abstract class DataProcessor {
    // 模板方法
    public final void process() {
        // 抽象步骤：读取数据，由子类实现
        readData();

        // 通用步骤1：处理数据
        processData();

        // 通用步骤2：保存数据
        saveData();
    }

    private void processData() {
        System.out.println("Processing data");
    }

    private void saveData() {
        System.out.println("Saving data");
    }

    protected abstract void readData();
}

// 数据来源：CVS
class CSVDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from CSV file");
    }
}

// 数据来源：数据库
class DatabaseDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from database");
    }
}


