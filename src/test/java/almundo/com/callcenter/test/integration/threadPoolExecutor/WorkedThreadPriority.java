package almundo.com.callcenter.test.integration.threadPoolExecutor;

/**
 * Created by mariano on 08/08/17.
 */
public class WorkedThreadPriority implements Runnable {

    private final String command;
    private final Priority priority;

    public WorkedThreadPriority(String command, Priority priority) {
        this.command = command;
        this.priority = priority;
    }


    public void run() {

        System.out.println( Thread.currentThread().getName() +  " Start Command = "+ command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");

    }

    private void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "WorkedThread{" +
                "command='" + command + '\'' +
                '}';
    }

    public int getPriority() {
        return priority.getValue();
    }
}
