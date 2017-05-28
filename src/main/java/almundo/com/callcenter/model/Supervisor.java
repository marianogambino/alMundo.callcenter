package almundo.com.callcenter.model;

/**
 * Created by mariano on 26/05/2017.
 */
public class Supervisor extends Empleado  {


    public static Empleable newInstance(){
        return new Supervisor();
    }

    public static Empleable newInstance(String nombre){
        return new Supervisor(nombre);
    }

    private Supervisor(){}

    private Supervisor(String nombre){
        this.nombre = "Supervisor";
        this.nombre = this.nombre + nombre;
    }
}
