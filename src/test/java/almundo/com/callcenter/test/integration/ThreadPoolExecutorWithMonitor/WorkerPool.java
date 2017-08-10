package almundo.com.callcenter.test.integration.ThreadPoolExecutorWithMonitor;

import almundo.com.callcenter.test.integration.ThreadPoolExecutor.WorkedThread;

import java.util.concurrent.*;

/**
 * Created by mariano on 08/08/17.
 */
public class WorkerPool {

    public static void main(String[] args) throws InterruptedException {

        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandlerImpl();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4 , 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        MyMonitorThreadPool monitor = new MyMonitorThreadPool(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        for(int i=0 ; i<10; i++){
            executorPool.execute(new WorkedThread("CMD"+i));
        }

        Thread.sleep(300000);
        executorPool.shutdown();
        Thread.sleep(5000);
        monitor.shutdown();
    }
}
