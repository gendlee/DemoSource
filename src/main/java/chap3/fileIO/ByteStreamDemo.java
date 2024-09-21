package chap3.fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节文件流处理：以读写照片为例
 */
public class ByteStreamDemo {

    // 当前目录待读取的图片文件
    private static final String SOURCE_PIC_FILE = ".\\src\\main\\java\\chap3\\fileIO\\parrot.jpg";
    // 当前目录复制生成的图片文件
    private static final String DEST_PIC_FILE = ".\\src\\main\\java\\chap3\\fileIO\\copied_parrot.jpg";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(SOURCE_PIC_FILE);
             FileOutputStream fos = new FileOutputStream(DEST_PIC_FILE)) {

            byte[] buffer = new byte[1024];  // 缓冲区
            int length;

            // 循环读取图片数据并写入到目标文件
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }

            System.out.println("图片复制成功！");
        } catch (IOException e) {
            System.out.println("二进制文件I/O异常：" + e.getMessage());
        }
    }
}
