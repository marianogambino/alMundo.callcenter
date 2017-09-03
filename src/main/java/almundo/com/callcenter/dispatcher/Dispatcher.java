package almundo.com.callcenter.dispatcher;

import almundo.com.callcenter.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Representa la clase encargada de antender y derivar las llamadas a un empleado.
 */
public class Dispatcher implements Runnable {


    private Logger logger = LoggerFactory.getLogger(Dispatcher.class);
    private static Dispatcher instance = new Dispatcher();

    private Queue<Call> queue = new LinkedList<Call>();

    private BlockingQueue<Employee> employeeQueue = new PriorityBlockingQueue<Employee>();



    private AtomicInteger countCall = new AtomicInteger(0);

    /**
     * Contructor. Instancia el Dispatcher.
     */
    public Dispatcher(){
        addEmployes();
    }

    /**
     * Obtiene siempre la misma instacia del dispatcher.
     * @return la instancia del dispatcher.
     */
    public static Dispatcher getInstance(){
        return instance;
    }

    /**
     * Se encarga de asignar una llamada a un empleado siendo este un hilo/thread.
     * @param call representa una llamada.
     */
    public void dispatchCall(Call call) throws InterruptedException {

        Employee emp = null;

        countCall.incrementAndGet();

        if(countCall.get() <= 10){

            emp = employeeQueue.poll();

            if(emp!=null) {
                //System.out.println("employeeQueue size: " + employeeQueue.size());
                //System.out.println("emp " + emp.getNombre());
                Call c = call;
                if(this.queue.size() > 0){
                    this.queue.add(call);
                    c = this.queue.poll();
                }
                emp.setCall(c);

            }else{
                this.queue.add(call);
            }

        }else{
            this.queue.add(call);
            Thread.sleep(2000);
        }

    }


    private void addEmployes(){

        Employee e = new Operador("1" , employeeQueue, countCall);
        Employee e1 =  new Operador("2", employeeQueue, countCall);
        Employee e2 = new Operador("3", employeeQueue, countCall);
        Employee e3 = new Operador("4", employeeQueue, countCall);
        Employee e4 = new Operador("5", employeeQueue, countCall);
        Employee e5 = new Operador("6", employeeQueue, countCall);

        Employee e6 = new Supervisor("1", employeeQueue, countCall);
        Employee e7 = new Supervisor("2", employeeQueue, countCall);
        Employee e8 = new Director("1", employeeQueue, countCall);
        Employee e9 = new Director("2", employeeQueue, countCall);

        employeeQueue.add(e);
        employeeQueue.add(e1);
        employeeQueue.add(e2);
        employeeQueue.add(e3);
        employeeQueue.add(e4);
        employeeQueue.add(e5);

        //employeeQueue.add(e6);
        employeeQueue.add(e7);
        //employeeQueue.add(e8);
        employeeQueue.add(e9);


        runThread(e);
        runThread(e1);
        runThread(e2);
        runThread(e3);
        runThread(e4);
        runThread(e5);
        runThread(e6);
        runThread(e7);
        runThread(e8);
        runThread(e9);

    }

    private void runThread(Employee r){
        Thread t = new Thread(r);
        t.start();
    }


    public void run() {
        while(true){
            System.out.println("employeeQueue size: " + employeeQueue.size());
            System.out.println("countCall: " + this.countCall.get());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
