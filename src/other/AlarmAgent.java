package other;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class AlarmAgent {
    // 用于记录是否连接到了服务器
    private volatile boolean connectedToServer = false;

    // 表示前置条件是否成立
    private final Predicate agentConnected = new Predicate() {
        @Override
        public boolean evaluate() {
            return connectedToServer;
        }
    };

    private final Blocker blocker = new ConditionVarBlocker();

    private final Timer heartbeatTimer = new Timer(true);

    public void sendAlarm(final String msg) throws Exception{
         GuardedAction<Void> guardedAction = new GuardedAction<Void>(agentConnected) {
            @Override
            public Void call() throws Exception {
                doSendAlarm(msg);
                return null;
            }
         };
         blocker.callWithGuard(guardedAction);
    }

    private void doSendAlarm(String msg) {
        System.out.println("发送数据");
    }

    public void init() {
        Thread connectingThread = new Thread(new ConnectingTask());
        connectingThread.start();
        // 60000是指从调用该方法开始到第一次执行call方法之间的间隔
        // 2000是在第一次调用之后，两次定时任务之间的间隔
        heartbeatTimer.schedule(new HeartbeatTask(), 60000, 2000);
    }

    protected void onConnected() {
        try{
            blocker.signalAfter(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    connectedToServer = true;
                    System.out.println("已经与服务器建立了连接");
                    return Boolean.TRUE;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void onDisconnected() {
        connectedToServer = false;
    }

    /**
     * 负责与服务器建立连接，建立连接后通知可以发送数据
     */
    private class ConnectingTask implements Runnable{
        @Override
        public void run() {
            try{
                // 模拟建立连接的耗时
                Thread.sleep(100);
            } catch (InterruptedException e) {
                ;
            }
            onConnected();
        }
    }

    private class HeartbeatTask extends TimerTask {
        @Override
        public void run() {
            if (!testConnection()) {
                onDisconnected();
                reconnect();
            }
        }

        private boolean testConnection() {
            // 省略其他代码来测试此时网络连接的正常性
            return true;
        }

        private void reconnect() {
            ConnectingTask connectingTask = new ConnectingTask();
            // 直接在心跳线程中执行
            connectingTask.run();
        }
    }
}
