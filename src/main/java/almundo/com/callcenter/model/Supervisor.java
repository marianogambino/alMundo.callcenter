package almundo.com.callcenter.model;

/**
 * Created by mariano on 26/05/2017.
 */
public class Supervisor extends Empleado  {

    /**
     *
     * @return
     */
    public static Empleable newInstance(){
        return new Supervisor();
    }

    /**
     *
     * @param nombre
     * @return
     */
    public static Empleable newInstance(String nombre){
        return new Supervisor(nombre);
    }

    /**
     *
     */
    private Supervisor(){}

    /**
     *
     * @param nombre
     */
    private Supervisor(String nombre){
        this.nombre = "Supervisor";
        this.nombre = this.nombre + nombre;
    }
}
