package almundo.com.callcenter.test.integration.thread;

import org.junit.Test;

/**
 * Created by mariano on 07/08/17.
 */
public class TestThreadPool {

    @Test
    public void testThreadPool(){

        ThreadPool threadPool = new ThreadPool(7 );

        for(int i=0 ; i < 5 ; i++){
            Task task = new Task(i);
            threadPool.execute(task);
        }


    }

}
