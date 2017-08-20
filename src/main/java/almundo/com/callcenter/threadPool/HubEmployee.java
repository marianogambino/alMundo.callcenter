package almundo.com.callcenter.threadPool;

import almundo.com.callcenter.model.*;


import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mariano on 10/08/17.
 */
public class HubEmployee {

    public int nThread;
    public LinkedBlockingQueue<Runnable> queue;
    public Empleado[] empleado;

    public HubEmployee(int nThread){
        this.nThread = nThread;
        this.queue = new LinkedBlockingQueue<Runnable>();
        this.empleado = new Empleado[this.nThread];
        createOperator();
        createSupervisor();
        createDirector();
    }


    private void createOperator(){
        for (int i=0; i < 3; i++){
            this.empleado[i] = new Operador( "op.: " + i, queue);
            this.empleado[i].setPriority(10);
            this.empleado[i].start();
        }
    }

    private void createSupervisor(){
        for (int i=3; i < 3*2; i++){
            this.empleado[i] = new Supervisor( "sup.: " + i, queue);
            this.empleado[i].setPriority(5);
            this.empleado[i].start();
        }
    }

    private void createDirector(){
        for (int i=3*2; i < 3*3; i++){
            this.empleado[i] = new Director( "dir.: " + i, queue);
            this.empleado[i].setPriority(3);
            this.empleado[i].start();
        }
    }


    public void execute(Runnable t){
        synchronized (queue) {
            this.queue.add(t);
            this.queue.notify();
        }
    }
}
