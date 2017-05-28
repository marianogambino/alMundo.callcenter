package almundo.com.callcenter.model;

/**
 * Created by mariano on 26/05/2017.
 */
public class Operador extends Empleado {


    public static Empleable newInstance(){
        return new Operador();
    }

    public static Empleable newInstance(String nombre){
        return new Operador(nombre);
    }

    private Operador(){}

    private Operador(String nombre){
        this.nombre = "Operador";
        this.nombre = this.nombre + nombre;
    }

}
