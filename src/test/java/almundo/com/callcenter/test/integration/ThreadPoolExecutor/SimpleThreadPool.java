package almundo.com.callcenter.test.integration.ThreadPoolExecutor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mariano on 08/08/17.
 */
public class SimpleThreadPool {

   public static void main(String[] args){

       ExecutorService executor = Executors.newFixedThreadPool(5);
       for(int i = 0 ; i< 10 ; i++){
           Runnable worker = new WorkedThread(" " + i);
           executor.execute(worker);
       }
       executor.shutdown();
       while (!executor.isTerminated()){
       }

       System.out.println("Finished all threads");



   }
}
