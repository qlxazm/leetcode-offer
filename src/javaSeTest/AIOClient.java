package javaSeTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

/**
 * @author qian
 * @date 2020/2/15 19:36
 */
public class AIOClient {
    private final static int PORT = 30000;
    private final static String HOST = "127.0.0.1";

    public static void connect() throws IOException {
        ExecutorService executor = new ThreadPoolExecutor(5,
                10,
                2000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    private int count = 0;
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("客户端进程#" + (++count));
                        return null;
                    }
                }, new ThreadPoolExecutor.CallerRunsPolicy());
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open(channelGroup);
        socketChannel.connect(new InetSocketAddress(HOST, PORT), null, new CompletionHandler<Void, Object>() {
            // 客户端成功连接到服务器
            @Override
            public void completed(Void result, Object attachment) {
                System.out.println("客户端连接到了服务器！");


                // 异步读取服务器端发送来的信息
                ByteBuffer byteBuffer = ByteBuffer.allocate(64);
                byteBuffer.clear();
                socketChannel.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        byteBuffer.flip();
                        String content = StandardCharsets.UTF_8.decode(byteBuffer).toString();
                        System.out.println("服务器端发送来的信息是：" + content);

                        // 准备下一次读取
                        byteBuffer.clear();
                        socketChannel.read(byteBuffer, null, this);
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("读取客户端发送来的信息失败！");
                    }
                });


                // 同步阻塞式发送一条数据到服务器
                try {
                    socketChannel.write(ByteBuffer.wrap("Hello Server!".getBytes())).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("客户端连接服务器失败！" + exc);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        connect();
    }
}
