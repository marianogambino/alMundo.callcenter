package almundo.com.callcenter.model;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Clase que Representa a un Operador.
 */
public class Operador extends Empleado {


    /**
     * Retorna una instancia de Operador
     * @return instancia de Operador.
     */
    public static Empleable newInstance(){
        return new Operador();
    }


    /**
     * Constructo privado. Instancia un Operador.
     */
    public Operador(){}

    /**
     * Constructo privado. Instancia un Operador asignandole un nombre.
     * @param nombre
     */
    public Operador(String nombre, LinkedBlockingQueue<Runnable> queue){
        this.nombre = "Operador ";
        this.nombre = this.nombre + nombre;
        this.queue = queue;
    }

}
