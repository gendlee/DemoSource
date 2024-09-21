package chap3.fileIO;

import java.io.*;

/**
 * 字符流：处理文本文件
 */
public class CharStreamDemo {
    // 当前目录生成的文件名
    private static final String FILE_NAME = ".\\src\\main\\java\\chap3\\fileIO\\写入的文件.txt";

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter(FILE_NAME);
             FileReader reader = new FileReader(FILE_NAME);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {

            writer.write("FileWriter写入的\n");
            writer.flush(); // 刷入磁盘
            // 使用 FileReader 读取文件
            int character; // 每次读取一个字符
            while ((character = reader.read()) != -1) {
                System.out.print((char) character); // 按字符打印
            }
            bufferedWriter.write("BufferedWriter写入的\n");
            bufferedWriter.flush();
            // 使用 BufferedReader 读取文件
            String line; // 每次读取一行
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // 输出全部写入数据
            }
        } catch (IOException e) {
            System.out.println("文本文件I/O异常：" + e.getMessage());
        }
    }
}
