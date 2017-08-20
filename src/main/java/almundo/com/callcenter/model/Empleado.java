package almundo.com.callcenter.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;


/**
 * Clase Empleado.
 */
public class Empleado extends Thread implements Empleable {

    protected static Logger logger = LoggerFactory.getLogger(Empleado.class);

    protected String nombre;
    protected LinkedBlockingQueue<Runnable> queue;


    /**
     * Contructor.
     */
    public Empleado(){}



    /**
     * Contructor.
     * @param nombre que setea al objeto Empleado.
     */
    public Empleado(String nombre){
        this.nombre = nombre;
    }

    /**
     * Implementado para lanzar un hilo (Thread).
     * Atiende la llamada telefonica.
     */
    public void run() {

        Runnable call;
        while(true){

            synchronized (queue) {
                while (queue.isEmpty()) {

                    try {

                        queue.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    call = queue.poll();
                    System.out.println(" Thread: " + this.nombre + " - get call: " + call.toString());
                    call.run();
                } catch (RuntimeException re) {
                    System.out.println("Thread pool is interrupted due to an issue: " + re.getMessage());
                }
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



}
