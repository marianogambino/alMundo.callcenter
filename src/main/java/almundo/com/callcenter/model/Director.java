package almundo.com.callcenter.model;

/**
 * Created by mariano on 26/05/2017.
 */
public class Director  extends Empleado  {


    public static Empleable newInstance(){
        return new Director();
    }

    public static Empleable newInstance(String nombre){
        return new Director(nombre);
    }

    private Director(){}

    private Director(String nombre){
        this.nombre = "Director";
        this.nombre = this.nombre + nombre;
    }

}
