package almundo.com.callcenter.strategy;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Empleable;

/**
 * Clase que implementa una estrategia de asignacion
 * de llamda a un empleado determinado (Op, Sup, Dir),
 * dependiendo la disponibilidad.
 *
 */
public class EmpStrategy implements Strategy {

    public static EmpStrategy instance = new EmpStrategy();
    public static EmpStrategy getInstance(){
        return instance;
    }

    /**
     * Constructor Privado.
     * Genera la cantidad de Operadores, Supervisores y Directores.
     *
     */
    private EmpStrategy(){
        //Se llama a un builder para construir los operadores, supervisores y directores
        //la cantidad de los mismos se toma de forma arbitraria
        EmpleadoBuilder.crearEmpleado(10, TipoEmpleadoEnum.OPERADOR);
        EmpleadoBuilder.crearEmpleado(2, TipoEmpleadoEnum.SUPERVISOR );
        EmpleadoBuilder.crearEmpleado(1, TipoEmpleadoEnum.DIRECTOR);
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
