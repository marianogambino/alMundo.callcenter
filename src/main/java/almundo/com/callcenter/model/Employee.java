package almundo.com.callcenter.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Clase Empleado.
 */
public class Employee implements Comparable<Employee>, Empleable {

    protected static Logger logger = LoggerFactory.getLogger(Employee.class);

    private String nombre;
    private final PriorityTask priorityTask;
    private Runnable call;

    private final BlockingQueue<Employee> employeeQueue;
    private AtomicInteger countCall;

    /**
     * Contructor.
     * @param nombre que setea al objeto Empleado.
     * @param countCall
     */
    public Employee(String nombre, PriorityTask priorityTask, BlockingQueue<Employee> employeeQueue, AtomicInteger countCall){
        this.nombre = nombre;
        this.priorityTask = priorityTask;
        this.employeeQueue = employeeQueue;
        this.countCall = countCall;
    }

    /**
     * Implementado para lanzar un hilo (Thread).
     * Atiende la llamada telefonica.
     */
    public void run() {

        while(true){
                try {

                    while (call == null){

                       // System.out.println(" Thread: " + this.nombre + " - waiting for call" );
                        Thread.sleep(3000);
                    }

                    System.out.println(" Thread: " + this.nombre + " - attend call: " + this.call.toString());
                    Thread t = new Thread(call);
                    t.start();
                    t.join();
                    System.out.println(" Thread: " + this.nombre + " - finished call: " + call.toString());
                    call = null;


                     synchronized (this.countCall) {
                         this.countCall.decrementAndGet();
                         System.out.println("countCall Employee: " + this.countCall);
                         employeeQueue.add(this);
                     }



                } catch (RuntimeException re) {
                    System.out.println("Thread pool is interrupted due to an issue: " + re.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }

    /**
     * Obtengo el nombre.
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Seteo un nombre.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrior() {
        return priorityTask.getValue();
    }

    public void setCall(Runnable call) {
        this.call = call;
    }

    public int compareTo(Employee o) {
        return this.getPrior() - o.getPrior();
    }
}
