package almundo.com.callcenter.model;

/**
 *
 */
public class Call {

    private String descipcion;
    private String nroTelefono;

    private Call(){}

    /**
     *
     * @param nro
     */
    private Call(String nro){
        this.nroTelefono = nro;
    }


    /**
     *
     * @return
     */
    public static Call newInstance(){
        return new Call();
    }

    /**
     *
     * @param nro
     * @return
     */
    public static Call newInstance(String nro){
        return new Call(nro);
    }

    /**
     *
     * @return
     */
    public String getNroTelefono() {
        return nroTelefono;
    }

    /**
     *
     * @param nroTelefono
     */
    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    /**
     *
     * @return
     */
    public String getDescipcion() {
        return descipcion;
    }

    /**
     *
     * @param descipcion
     */
    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }
}
