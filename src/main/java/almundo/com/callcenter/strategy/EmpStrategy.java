package almundo.com.callcenter.strategy;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;

/**
 *
 */
public class EmpStrategy implements Strategy {

    public static EmpStrategy instance = new EmpStrategy();
    public static EmpStrategy getInstance(){
        return instance;
    }

    /**
     *
     */
    private EmpStrategy(){
        //Se llama a un builder para construir los operadores, supervisores y directores
        //cantidad de los mismos se toma de forma arbitraria
        EmpleadoBuilder.crearEmpleado(5, TipoEmpleadoEnum.OPERADOR);
        EmpleadoBuilder.crearEmpleado(3, TipoEmpleadoEnum.SUPERVISOR );
        EmpleadoBuilder.crearEmpleado(2, TipoEmpleadoEnum.DIRECTOR);
    }

    /**
     *
     * @param call
     * @return
     */
    public Empleable apply(Call call){
        Empleable emp = null;
        TipoEmpleadoEnum[] tipo = TipoEmpleadoEnum.values();
        for( int i=0 ; i < tipo.length && emp == null; i++ ) {
            emp = getEmpleable(tipo[i], call);
        }
        return emp;
    }

    /**
     *
     * @param tipo
     * @param callDispatcher
     * @return
     */
    private Empleable getEmpleable(TipoEmpleadoEnum tipo, Call callDispatcher){
        Empleable empleable = null;
        if (EmpleadoBuilder.getListaEmpleado(tipo).size() > 0) {
            empleable = EmpleadoBuilder.getListaEmpleado(tipo).get(0);
            empleable.asignarLLamada(callDispatcher);
            EmpleadoBuilder.removeItem(tipo);
        }
        return empleable;
    }

}
