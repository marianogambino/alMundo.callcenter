package almundo.com.callcenter.model;

/**
 *
 */
public class Director  extends Empleado  {

    /**
     *
     * @return
     */
    public static Empleable newInstance(){
        return new Director();
    }

    /**
     *
     * @param nombre
     * @return
     */
    public static Empleable newInstance(String nombre){
        return new Director(nombre);
    }

    private Director(){}

    /**
     *
     * @param nombre
     */
    private Director(String nombre){
        this.nombre = "Director";
        this.nombre = this.nombre + nombre;
    }

}
