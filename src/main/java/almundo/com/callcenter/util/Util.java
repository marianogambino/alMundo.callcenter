package almundo.com.callcenter.util;

import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Empleable;
import almundo.com.callcenter.model.Operador;
import almundo.com.callcenter.model.Supervisor;

/**
 * Created by mariano on 28/05/2017.
 */
public class Util {

    public static TipoEmpleadoEnum getTipo(Empleable emp){
        if(emp instanceof Operador){
            return TipoEmpleadoEnum.OPERADOR;
        }else if(emp instanceof Supervisor){
            return TipoEmpleadoEnum.SUPERVISOR;
        }
        return TipoEmpleadoEnum.DIRECTOR;
    }
}
