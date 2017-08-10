package almundo.com.callcenter.search;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Empleable;

/**
 * Clase se encarga de buscar un empleado disponible.
 *
 */
public class SearchAvailabilityEmp implements SearchAvailability {

    public static SearchAvailabilityEmp instance = new SearchAvailabilityEmp();
    public static SearchAvailabilityEmp getInstance(){
        return instance;
    }

    /**
     * Constructor Privado.
     *
     */
    private SearchAvailabilityEmp(){

    }

    /**
     * Metodo encargado de obtener un Empleado disponible (Operador/Supervisor/Director).
     * @return un empleado.
     */
    public Empleable get(){
        Empleable emp = null;
        TipoEmpleadoEnum[] tipo = TipoEmpleadoEnum.values();
        for( int i=0 ; i < tipo.length && emp == null; i++ ) {
            emp = getEmpleable(tipo[i]);
        }
        return emp;
    }

    /**
     * Metodo encargado de verificar la disponibilidad de un empleado, asignar la llamada
     * y sacarlo de la lista de operadores disponibles.
     * @param tipo de empleado.
     * @return empleado.
     */
    private Empleable getEmpleable(TipoEmpleadoEnum tipo){
        Empleable empleable = null;
        if (EmpleadoBuilder.getListaEmpleado(tipo).size() > 0) {
            empleable = EmpleadoBuilder.getListaEmpleado(tipo).get(0);
            EmpleadoBuilder.removeItem(tipo,empleable);
        }
        return empleable;
    }

}
