package javaSeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qian
 * @date 2020/2/15 13:11
 */
public class MyServer {

    private static List<Socket> sockets = Collections.synchronizedList(new ArrayList<>());
    private static int PORT = 30000;

    static class ServerThread implements Runnable{

        private Socket socket;
        private BufferedReader br;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                String content = null;
                while ((content = readFromClient()) != null) {
                    System.out.println("服务器端读到了来自客户端的消息：" + content);
                    for (Socket s : MyServer.sockets) {
                        PrintStream ps = new PrintStream(s.getOutputStream());
                        ps.println(content);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String readFromClient() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                sockets.remove(socket);
            }
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        while (true) {
            Socket socket = ss.accept();
            sockets.add(socket);
            // 开启一个线程来读取客户端发送来的数据，并将数据转发到各个客户端
            new Thread(new ServerThread(socket)).start();
        }
    }
}
