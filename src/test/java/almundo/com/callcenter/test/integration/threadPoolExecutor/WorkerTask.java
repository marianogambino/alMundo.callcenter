package almundo.com.callcenter.test.integration.threadPoolExecutor;

import java.util.concurrent.FutureTask;

/**
 * Created by mariano on 20/08/17.
 */
public class WorkerTask extends FutureTask<WorkerTask> implements Comparable<WorkerTask>{

    private final WorkedThreadPriority task;

    public WorkerTask(WorkedThreadPriority task) {
        super(task, null);
        this.task = task;
    }


    public int compareTo(WorkerTask o) {
        return task.getPriority() - o.getTask().getPriority();
    }

    public WorkedThreadPriority getTask() {
        return task;
    }
}
