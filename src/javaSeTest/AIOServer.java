package javaSeTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author qian
 * @date 2020/2/15 19:36
 */
public class AIOServer {

    private final static int PORT = 30000;
    private static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

    public static void server() throws IOException {
        // 创建线程池
        ExecutorService executor = new ThreadPoolExecutor(
                5,
                10,
                2000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadFactory() {
                    private int count = 0;
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName(++count + "号线程");
                        return thread;
                    }
                });
        // 以指定的线程池创建一个AsynchronousServerSocketChannel
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup)
                .bind(new InetSocketAddress(PORT));

        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            // 当IO操作完成时触发
            @Override
            public void completed(AsynchronousSocketChannel sc, Object attachment) {
                // 等着处理客户端的下一个请求
                serverSocketChannel.accept(null, this);

                channelList.add(sc);

                // 读取客户端发送来的消息
                ByteBuffer byteBuffer = ByteBuffer.allocate(64);
                byteBuffer.clear();
                sc.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                    // 执行到这个方法的时候，数据已经被读取到byteBuffer中了
                    @Override
                    public void completed(Integer result, Object attachment) {

                        byteBuffer.flip();
                        String content = StandardCharsets.UTF_8.decode(byteBuffer).toString();

                        for (AsynchronousSocketChannel c : channelList) {
                            try {
                                // 同步阻塞式写
                                c.write(ByteBuffer.wrap(content.getBytes())).get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }

                        // 准备接受读取客户端的下一个请求
                        byteBuffer.clear();
                        sc.read(byteBuffer, null, this);
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("读取客户端发送来的数据失败！" + exc);
                        channelList.remove(sc);
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("接受客户端链接失败！" + exc);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        server();
    }
}
