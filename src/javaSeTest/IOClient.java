package javaSeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 读取来自服务器端的信息
 * @author qian
 * @date 2020/2/14 17:28
 */
public class IOClient {
    public static void Connect() {
        try (
                Socket socket = new Socket("127.0.0.1", 30000);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                String message = br.readLine();
                System.out.println("接收到的来自服务器端的消息：" + message);
        }catch (IOException o) {
            o.printStackTrace();
        }

    }

    public static void main(String[] args) {
        IOClient.Connect();
    }

}
