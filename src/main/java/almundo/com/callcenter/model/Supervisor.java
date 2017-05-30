package almundo.com.callcenter.model;

/**
 * Clase que Representa a un Supervisor.
 */
public class Supervisor extends Empleado  {

    /**
     * Retorna una instancia de Supervisor
     * @return instancia de Supervisor.
     */
    public static Empleable newInstance(){
        return new Supervisor();
    }

    /**
     * Retorna una instancia de Supervisor
     * @param nombre nombre del supervisor.
     * @return un supervisor.
     */
    public static Empleable newInstance(String nombre){
        return new Supervisor(nombre);
    }

    /**
     * Constructo privado. Instancia un supervisor.
     */
    private Supervisor(){}

    /**
     * Constructo privado. Instancia un supervisor asignandole un nombre.
     * @param nombre nombre del supervisor.
     */
    private Supervisor(String nombre){
        this.nombre = "Supervisor";
        this.nombre = this.nombre + nombre;
    }
}
