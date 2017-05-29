package almundo.com.callcenter.model;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 *
 */
public class Empleado implements Empleable {

    protected static Logger logger = LoggerFactory.getLogger(Empleado.class);

    protected String nombre;

    protected Call call;

    public Empleado(){}

    private Random ran = new Random();

    /**
     *
     * @param nombre
     */
    public Empleado(String nombre){
        this.nombre = nombre;
    }

    /**
     *
     */
    public void run() {
        try {
            System.out.println("Soy " +  this.nombre + " - Tomo la Llamada " + this.call.getNroTelefono());
            int x = (ran.nextInt(6) + 5 ) * 1000;
            Thread.sleep(x);
            EmpleadoBuilder.getListaEmpleado(Util.getTipo(this)).add(this);
        }
        catch(InterruptedException iex){
            logger.info("La Llamada antendida por {}  fue interrumpida", this.nombre);
        }
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param llamada
     */
    public void asignarLLamada(Call llamada) {
         this.call = llamada;
    }
}
