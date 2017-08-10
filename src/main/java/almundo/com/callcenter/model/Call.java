package almundo.com.callcenter.model;

/**
 * Clase que representa una llamada telefonica.
 */
public class Call {

    private String descipcion;
    private String nroTelefono;

    private Call(){}

    /**
     * Contructor privato que instancia un objeto y setea un nro telefonico.
     * @param nro de telefono.
     */
    private Call(String nro){
        this.nroTelefono = nro;
    }


    /**
     * Instancia un objeto Call.
     * @return un objeto Call.
     */
    public static Call newInstance(){
        return new Call();
    }

    /**
     * Retorna una nueva instacia de Call con un nro de telefono.
     * @param nro de telefono.
     * @return un objeto Call.
     */
    public static Call newInstance(String nro){
        return new Call(nro);
    }

    /**
     * Obtiene el nro de telefono.
     * @return un nro de telefono.
     */
    public String getNroTelefono() {
        return nroTelefono;
    }

    /**
     * Setea un nro de telefono.
     * @param nroTelefono
     */
    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    /**
     * Retorna una descripcion.
     * @return una descripcion.
     */
    public String getDescipcion() {
        return descipcion;
    }

    /**
     * Setea una descripcion.
     * @param descipcion
     */
    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }
}
