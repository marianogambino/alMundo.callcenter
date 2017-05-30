package almundo.com.callcenter.model;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Clase Empleado.
 */
public class Empleado implements Empleable {

    protected static Logger logger = LoggerFactory.getLogger(Empleado.class);

    protected String nombre;

    protected Call call;

    /**
     * Contructor.
     */
    public Empleado(){}

    private Random ran = new Random();

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
        try {
            System.out.println("Soy " +  this.nombre + " - Tomo la Llamada " + this.call.getNroTelefono());
            //Obtengo la cantidad de segundos, entre 5 y 10 de forma aleatoria.
            int x = (ran.nextInt(6) + 5 ) * 1000;
            //Simulo duracion de la llamada telefonica.
            Thread.sleep(x);
            //El empleado vuelve a la lista correspondiente para tener disponibilidad y
            // atender otra llamada.
            EmpleadoBuilder.getListaEmpleado(Util.getTipo(this)).add(this);
        }
        catch(InterruptedException iex){
            logger.info("La Llamada atendida por {}  fue interrumpida", this.nombre);
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

    /**
     * Seteo una llamada telefonica.
     * @param llamada telefonica.
     */
    public void asignarLLamada(Call llamada) {
         this.call = llamada;
    }
}
