package almundo.com.callcenter.model;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Clase que Representa a un Supervisor.
 */
public class Supervisor extends Empleado  {

    /**
     * Retorna una instancia de Supervisor
     * @return instancia de Supervisor.
     */
    public static Empleable newInstance(){
        return new Supervisor();
    }


    /**
     * Constructo privado. Instancia un supervisor.
     */
    public Supervisor(){}

    /**
     * Constructo privado. Instancia un supervisor asignandole un nombre.
     * @param nombre nombre del supervisor.
     */
    public Supervisor(String nombre, LinkedBlockingQueue<Runnable> queue){
        this.nombre = "Supervisor ";
        this.nombre = this.nombre + nombre;
        this.queue = queue;
    }
}
