package almundo.com.callcenter.test.integration.threadPoolExecutor;


import java.util.concurrent.*;

/**
 * Created by mariano on 08/08/17.
 */
public class ExecutorThreadPool {

   public static void main(String[] args) throws InterruptedException {

       PriorityBlockingQueue queue = new PriorityBlockingQueue();
       ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
               10, 1000, TimeUnit.MILLISECONDS, queue);

       //for(int i = 0 ; i< 10 ; i++){

       WorkedThreadPriority worker1 = new WorkedThreadPriority(" " + 1, Priority.LOW);
       WorkedThreadPriority worker2 = new WorkedThreadPriority(" " + 2, Priority.LOW);
       WorkedThreadPriority worker3 = new WorkedThreadPriority(" " + 3, Priority.HIGH);
       WorkedThreadPriority worker4 = new WorkedThreadPriority(" " + 4, Priority.HIGHEST);

        Thread.sleep(1000);
       executor.execute(new WorkerTask(worker2));
       executor.execute(new WorkerTask(worker1));
       executor.execute(new WorkerTask(worker3));
       executor.execute(new WorkerTask(worker4));

       //}

       executor.shutdown();
       while (!executor.isTerminated()){
       }

       System.out.println("Finished all threads");



   }
}
