package javaSeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author qian
 * @date 2020/2/15 12:55
 */
public class MyClient {

    private static int PORT = 30000;
    private static String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // 连接服务器
        Socket socket = new Socket(HOST, PORT);

        // 开启一个线程读取来自服务器端的数据
        new Thread(new ClientThread(socket)).start();

        // 读取键盘输入的数据并传递到服务器端
        PrintStream ps = new PrintStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println("读取到客户端输入了：" + line);
            ps.println(line);
        }
    }

}
