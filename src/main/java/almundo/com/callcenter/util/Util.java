package almundo.com.callcenter.util;

import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Empleable;
import almundo.com.callcenter.model.Operador;
import almundo.com.callcenter.model.Supervisor;

/**
 * Clase de Utilidades.
 */
public class Util {

    /**
     * Metodo utilizado para obtener un enum dependiendo de la instancia.
     * @param emp interface que contiene una instancia (Operador/Supervisor/Director).
     * @return un Enumerador
     */
    public static TipoEmpleadoEnum getTipo(Empleable emp){
        if(emp instanceof Operador){
            return TipoEmpleadoEnum.OPERADOR;
        }else if(emp instanceof Supervisor){
            return TipoEmpleadoEnum.SUPERVISOR;
        }
        return TipoEmpleadoEnum.DIRECTOR;
    }
}
