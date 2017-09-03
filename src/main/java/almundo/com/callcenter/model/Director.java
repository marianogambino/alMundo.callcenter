package almundo.com.callcenter.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que Representa a un Director.
 */
public class Director  extends Employee {


    /**
     * Constructo privado. Instancia un Director asignandole un nombre.
     * @param nombre
     */
    public Director(String nombre, BlockingQueue<Employee> employeeBlockingQueue, AtomicInteger countCall){
        super("Director " + nombre, PriorityTask.DIRECTOR, employeeBlockingQueue, countCall);
    }

}
