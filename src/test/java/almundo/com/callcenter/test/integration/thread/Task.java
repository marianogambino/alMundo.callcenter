package almundo.com.callcenter.test.integration.thread;

/**
 * Created by mariano on 07/08/17.
 */
public class Task implements Runnable {

    private int num;

    public Task(int num){
        this.num = num;
    }

    public void run() {
        System.out.println("Task " + num + " is running");
    }

}
