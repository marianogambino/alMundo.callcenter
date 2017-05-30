package almundo.com.callcenter.builder;

import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.factory.EmpleadoFry;
import almundo.com.callcenter.model.Empleable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class EmpleadoBuilder {

    private static Map<TipoEmpleadoEnum,List<Empleable>> factoryMap = new HashMap<TipoEmpleadoEnum, List<Empleable>>();

    /**
     *
     * @param cantOp
     * @param tipo
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
     *
     * @param tipo
     * @return
     */
    public static List<Empleable> getListaEmpleado(TipoEmpleadoEnum tipo){
        return factoryMap.get(tipo);
    }

    /**
     *
     * @param tipo
     */
    public static void removeItem( TipoEmpleadoEnum tipo){
        factoryMap.get(tipo).remove(0);
    }
}
