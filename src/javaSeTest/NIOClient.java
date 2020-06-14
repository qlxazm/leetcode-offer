package javaSeTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qian
 * @date 2020/2/14 19:27
 */
public class NIOClient {

    private static Selector selector;

    private final static int PORT = 30000;

    private final static String HOST = "127.0.0.1";

    public static void Connect() throws IOException {
        selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(HOST, PORT));

        // 注册channel
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            if (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isConnectable()) {
                        handlerConnect(selectionKey);
                    } else if (selectionKey.isReadable()) {
                        handlerRead(selectionKey);
                    }
                    iterator.remove();
                }
            }
        }
    }

    private static void handlerConnect(SelectionKey selectionKey) throws IOException{

        System.out.println("客户端连接事件触发！");

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        socketChannel.configureBlocking(false);
        // channel.finishConnect()才能完成连接
        if (socketChannel.isConnectionPending()) {
            socketChannel.finishConnect();
        }

        // 给服务器端发送一条消息
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.clear();
        byteBuffer.put("Hello Server!".getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }

        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void handlerRead(SelectionKey selectionKey) throws IOException {

        System.out.println("客户端开始读取服务器端发送来的消息!");

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        int byteNum;
        while ((byteNum = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            String message = new String(byteBuffer.array());
            System.out.print("从服务器端接受到的信息：" + message);
            byteBuffer.clear();
        }
    }

    public static void main(String[] args) throws IOException{
        NIOClient.Connect();
    }
}
