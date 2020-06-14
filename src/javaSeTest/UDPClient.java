package javaSeTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author qian
 * @date 2020/2/16 7:32
 */
public class UDPClient {
    private static final int PORT = 30000;
    private static final String HOST = "127.0.0.1";
    private static final int DATA_LEN = 4096;
    private static final byte[] inBuffer = new byte[DATA_LEN];

    public static void connect() throws IOException {

        DatagramPacket outPacket = null;
        DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
        DatagramSocket socket = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 发送消息
            byte[] sendData = scanner.nextLine().getBytes("UTF-8");
            outPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(HOST), PORT);
            socket.send(outPacket);

            // 接受消息
            socket.receive(inPacket);
            String message = new String(inBuffer, 0, inPacket.getLength(), "UTF-8");
            System.out.println("接收到的消息：" + message);
        }
    }

    public static void main(String[] args) {
        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
