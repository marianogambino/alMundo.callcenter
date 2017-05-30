package almundo.com.callcenter.builder;

import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.factory.EmpleadoFry;
import almundo.com.callcenter.model.Empleable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase Buider encargada de crear los empleados.
 *
 */
public class EmpleadoBuilder {

    private static Map<TipoEmpleadoEnum,List<Empleable>> factoryMap = new HashMap<TipoEmpleadoEnum, List<Empleable>>();

    /**
     * Crea una cantidad determinada de empleados segun el tipo de empleado.
     *
     * Crea una lista de empleados y por cada lista se agrega a un mapa segun el tipo de empleado.
     * El mapa es utlizado como factory.
     * @param cantOp cantidad de empleados ha crear
     * @param tipo de empleado
     */
    public static void crearEmpleado(int cantOp, TipoEmpleadoEnum tipo){
        List<Empleable> list = new ArrayList<Empleable>();
        for(int i=0; i<cantOp; i++){
            Empleable op = EmpleadoFry.crearEmpleado(tipo,  " - " + (i+1));
            list.add(op);
        }
        factoryMap.put(tipo, list);
    }

    /**
     * Obtiene una lista de empleados segun el tipo.
     * @param tipo Enumerador que representa al tipo de empleado (Operador, Supervisor, Director)
     * @return
     */
    public static List<Empleable> getListaEmpleado(TipoEmpleadoEnum tipo){
        return factoryMap.get(tipo);
    }

    /**
     * Elimina un empleado de la lista segun el tipo.
     * @param tipo Enumerador que representa al tipo de empleado (Operador, Supervisor, Director)
     * @param empleado (Operador, Supervisor, Director)
     */
    public static void removeItem( TipoEmpleadoEnum tipo, Empleable empleado){
        factoryMap.get(tipo).remove(empleado);
    }
}
