package almundo.com.callcenter.model;

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
     * Retorna una instancia de Operador
     * @param nombre nombre del Operador.
     * @return un Operador.
     */
    public static Empleable newInstance(String nombre){
        return new Operador(nombre);
    }

    /**
     * Constructo privado. Instancia un Operador.
     */
    private Operador(){}

    /**
     * Constructo privado. Instancia un Operador asignandole un nombre.
     * @param nombre
     */
    private Operador(String nombre){
        this.nombre = "Operador";
        this.nombre = this.nombre + nombre;
    }

}
