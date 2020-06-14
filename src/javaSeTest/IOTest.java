package javaSeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author qian
 * @date 2020/2/14 9:46
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        // 进程之间交换信息
       /* Process p = Runtime.getRuntime().exec("javac");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream())))
        {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }*/

      /* String filePath = "E:\\IDEAWorkSpace\\javaTest\\src\\javaSeTest\\nio.txt";
       try(RandomAccessFile accessFile = new RandomAccessFile(filePath, "rw"))
       {
           System.out.println("文件记录指针的位置：" + accessFile.getFilePointer());
           FileChannel fileChannel = accessFile.getChannel();
           ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
           int readedCharNum;
           // 调用read方法相当于向buffer中写入数据
           while ((readedCharNum = fileChannel.read(byteBuffer)) != -1) {
               // buffer从写模式转换成读模式
               byteBuffer.flip();
               while (byteBuffer.hasRemaining()) {
                   System.out.print((char)byteBuffer.get());
               }
               byteBuffer.compact();
           }

           byte a = 1;
           byteBuffer.put(a);
           byteBuffer.flip();
           // 调用write方法相当于从buffer中读取数据
           fileChannel.write(byteBuffer);
       } catch (IOException e) {
           e.printStackTrace();
       }*/

       Path path = Paths.get("..");
       System.out.println("path的根路径：" + path.getRoot());
       System.out.println(path.toAbsolutePath().normalize());
       System.out.println(path.toRealPath());

    }

}
