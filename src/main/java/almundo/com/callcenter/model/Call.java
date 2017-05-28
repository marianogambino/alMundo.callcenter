package almundo.com.callcenter.model;

/**
 * Created by mariano on 26/05/2017.
 */
public class Call {

    private String descipcion;
    private String nroTelefono;

    private Call(){}
    private Call(String nro){
        this.nroTelefono = nro;
    }

    public static Call newInstance(){
        return new Call();
    }

    public static Call newInstance(String nro){
        return new Call(nro);
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }
}
