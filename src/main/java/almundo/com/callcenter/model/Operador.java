package almundo.com.callcenter.model;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que Representa a un Operador.
 */
public class Operador extends Employee {


    /**
     * Constructor privado. Instancia un Operador asignandole un nombre.
     * @param nombre
     */
    public Operador(String nombre, BlockingQueue<Employee> employeeBlockingQueue, AtomicInteger countCall){
        super("Operador " + nombre, PriorityTask.OPERATOR, employeeBlockingQueue, countCall);
    }

}
