package javaSeTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author qian
 * @date 2020/2/16 7:32
 */
public class UDPServer {

    private static final int PORT = 30000;
    private static final int DATA_LEN = 4096;
    private static final byte[] inBuffer = new byte[DATA_LEN];

    private static final DatagramPacket inPacket = new DatagramPacket(inBuffer, DATA_LEN);

    public static void server() throws IOException {
        DatagramSocket udp = new DatagramSocket(PORT);
        DatagramPacket outPacket = null;
        String[] messages = {
                "消息1",
                "消息2",
                "消息3",
                "消息4"
        };

        for (int i = 0; i < 1000; i++) {
            // 接受消息
            udp.receive(inPacket);
            String message = new String(inBuffer, 0, inPacket.getLength(), "UTF-8");
            System.out.println("接收到的信息是：" + message);
            byte[] sendData = messages[i % 4].getBytes("UTF-8");

            // 再向发送方发送一条消息
            outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
            udp.send(outPacket);
        }
    }

    public static void main(String[] args) {
        try {
            server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
