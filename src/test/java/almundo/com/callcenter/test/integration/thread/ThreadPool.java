package almundo.com.callcenter.test.integration.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mariano on 07/08/17.
 */
public class ThreadPool {

    private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedBlockingQueue<Runnable> queue;


    public ThreadPool(int nThreads) {
        this.nThreads = nThreads;
        this.threads = new PoolWorker[nThreads] ;
        this.queue = new LinkedBlockingQueue<Runnable>();

        for(int i=0; i<nThreads; i++){
            threads[i]= new PoolWorker(queue);
            threads[i].start();
        }
    }

    public void execute(Runnable task){
        synchronized (queue){
            queue.add(task);
            queue.notify();
        }
    }


}
