package almundo.com.callcenter.test.integration.ThreadPoolExecutorWithMonitor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by mariano on 08/08/17.
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(  r.toString() + " is rejected");
    }
}
