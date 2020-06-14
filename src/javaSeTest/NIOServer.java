package javaSeTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qian
 * @date 2020/2/14 19:26
 */
public class NIOServer {

    private static Selector selector;
    private final static int PORT = 30000;
    private final static String HOST = "127.0.0.1";

    public static void Server() throws IOException {
        selector = Selector.open();
        // 创建channel并监听端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(HOST, PORT));

        // 将channel注册到selector并绑定监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            if (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        // 处理连接到达事件
                        handlerAccept(selectionKey);
                    } else if (selectionKey.isReadable()) {
                        // 处理读取事件
                        handlerRead(selectionKey);
                    }
                    iterator.remove();
                }
            }
        }
    }

    /**
     * 处理连接事件
     * @param selectionKey
     * @throws IOException
     */
    private static void handlerAccept(SelectionKey selectionKey) throws IOException{

        System.out.println("服务器处理客户端的连接事件！");

        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        // 向客户端发送消息 "Hello Client!"
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.clear();
        byteBuffer.put("Hello Client!".getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }

        // 设置读取事件，读取客户端发送来的信息
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    /**
     * 接受客户端发送来的数据
     * @param selectionKey
     * @throws IOException
     */
    private static void handlerRead(SelectionKey selectionKey) throws IOException{

        System.out.println("服务器接收到了客户端发送来的数据！");

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        int byteNum;
        while ((byteNum = socketChannel.read(byteBuffer)) != -1) {
            // 由写模式切换成读模式
            byteBuffer.flip();
            String message = new String(byteBuffer.array());
            System.out.print("客户端发送来的消息是：" + message);
            byteBuffer.clear();
        }
    }

    public static void main(String[] args) throws IOException{
        NIOServer.Server();
    }
}
