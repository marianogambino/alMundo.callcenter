package almundo.com.callcenter.test.integration.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mariano on 07/08/17.
 */
public class PoolWorker extends Thread {

    private LinkedBlockingQueue<Runnable> queue;


    public PoolWorker(LinkedBlockingQueue<Runnable> queue){
        this.queue = queue;
    }

    public void run() {

        Runnable task;

        while(true){

            synchronized (queue){

                while (queue.isEmpty()){

                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                    }

                }

                // If we don't catch RuntimeException,
                // the pool could leak threads

                try {
                    task = queue.poll();
                    task.run();
                }catch (RuntimeException re){
                    System.out.println("Thread pool is interrupted due to an issue: " + re.getMessage());

                }
            }
        }

    }
}
