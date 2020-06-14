package javaSeTest;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qian
 * @date 2020/2/14 17:28
 */
public class IOServer {
    public static void Server() throws IOException{
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            // 每当接收到客户端的一个请求时，服务器端对应产生一个Socket
            Socket s = ss.accept();
            System.out.println("======客户端来了一个连接======");
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("The message from server!");
            s.close();
            ps.close();
        }
    }

    public static void main(String[] args) throws IOException{
        IOServer.Server();
    }

}
