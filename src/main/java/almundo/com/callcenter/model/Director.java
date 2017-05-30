package almundo.com.callcenter.model;

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
     * Retorna una instancia de Director
     * @param nombre nombre del Director.
     * @return un Director.
     */
    public static Empleable newInstance(String nombre){
        return new Director(nombre);
    }

    /**
     * Constructo privado. Instancia un Director.
     */
    private Director(){}

    /**
     * Constructo privado. Instancia un Director asignandole un nombre.
     * @param nombre
     */
    private Director(String nombre){
        this.nombre = "Director";
        this.nombre = this.nombre + nombre;
    }

}
