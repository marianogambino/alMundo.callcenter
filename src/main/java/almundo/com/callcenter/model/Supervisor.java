package almundo.com.callcenter.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que Representa a un Supervisor.
 */
public class Supervisor extends Employee {



    /**
     * Constructo privado. Instancia un supervisor asignandole un nombre.
     * @param nombre nombre del supervisor.
     */
    public Supervisor(String nombre,BlockingQueue<Employee> employeeBlockingQueue, AtomicInteger countCall){
        super("Supervisor " + nombre, PriorityTask.SUPERVISOR, employeeBlockingQueue, countCall);
    }
}
