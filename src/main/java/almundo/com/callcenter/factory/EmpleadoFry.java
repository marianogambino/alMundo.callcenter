package almundo.com.callcenter.factory;

import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Director;
import almundo.com.callcenter.model.Empleable;
import almundo.com.callcenter.model.Operador;
import almundo.com.callcenter.model.Supervisor;

/**
 *
 */
public class EmpleadoFry {

    /**
     *
     * @param tipo
     * @param nombre
     * @return
     */
    public static Empleable createOperator(TipoEmpleadoEnum tipo, String nombre){
        Empleable e = null;
        switch (tipo){
            case OPERADOR:
                e =  Operador.newInstance(nombre);
                break;
            case SUPERVISOR:
                e = Supervisor.newInstance(nombre);
                break;
            case DIRECTOR:
                e = Director.newInstance(nombre);
                break;
            default:
                break;
        }
        return e;
    }
}
