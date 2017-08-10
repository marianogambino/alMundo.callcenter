package almundo.com.callcenter.test.integration.ThreadPoolExecutor;

/**
 * Created by mariano on 08/08/17.
 */
public class WorkedThread implements Runnable {

    private final String command;

    public WorkedThread(String command) {
        this.command = command;
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
}
