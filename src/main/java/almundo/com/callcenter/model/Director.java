package almundo.com.callcenter.model;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Clase que Representa a un Director.
 */
public class Director  extends Empleado  {

    /**
     * Retorna una instancia de Director
     * @return instancia de Director.
     */
    public static Empleable newInstance(){
        return new Director();
    }


    /**
     * Constructo privado. Instancia un Director.
     */
    public Director(){}

    /**
     * Constructo privado. Instancia un Director asignandole un nombre.
     * @param nombre
     */
    public Director(String nombre, LinkedBlockingQueue<Runnable> queue){
        this.nombre = "Director ";
        this.nombre = this.nombre + nombre;
        this.queue = queue;
    }

}
