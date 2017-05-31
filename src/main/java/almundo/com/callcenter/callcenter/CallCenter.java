package almundo.com.callcenter.callcenter;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.dispatcher.Dispatcher;
import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.queue.QueueCall;
import almundo.com.callcenter.util.CallCounter;

/**
 * Clase que representa al CallCenter
 *
 */
public class CallCenter {

    public static CallCenter newInstance(){
        return new CallCenter();
    }

    private static int OPERADORES = 8;
    private static int SUPERVISORES = 2;
    private static int DIRECTORES = 1;

    /**
     * Contructor privado.
     * Genera los empleados a traves de un Builder
     */
    private CallCenter(){
        //Se llama a un builder para construir los operadores, supervisores y directores
        //la cantidad de los mismos se toma de forma arbitraria
        EmpleadoBuilder.crearEmpleado(OPERADORES, TipoEmpleadoEnum.OPERADOR);
        EmpleadoBuilder.crearEmpleado(SUPERVISORES, TipoEmpleadoEnum.SUPERVISOR );
        EmpleadoBuilder.crearEmpleado(DIRECTORES, TipoEmpleadoEnum.DIRECTOR);
    }

    /**
     * Metodo que se encarga de llamar al Dispatcher para asignar una llamada a un operador/supervisor/director
     *
     *  Explicacion de porque el while true/ false.
     *  La finalidad es mostrar como las llamadas entran a una cola, se van asignando a cada operador/sup/director
     *  y si hay llamadas pendientes se toma la que esta en la cola, ademas si no hay operadores
     *  disponibles esas llamadas quedan en la misma, por ende con este loop podemos ver que cuando se
     *  se desocupa un operador, vuelve a estar disponible y se le asigna una llamada a traves del
     *  dispatcher.
     *
     *  Ademas el Dispatcher puede atender 10 llamadas al mismo tiempo ya que lanza hilos que son representados
     *  por cada tipo de empleado, teniendo cada uno de ellos una llamada asignada.
     *
     *  En el caso de que el dispatcher no pueda asignar una llamada la misma queda en la cola de espera.
     */
    public void assignCalls(){

        Boolean bool = true;

        while (bool){
            Call call = QueueCall.getQueue().get();
            // Si existe una llamada y el dispatcher no pudo asignar
            // la misma a un operador/sup/dir.(no hay disponiblidad de empleados)
            // la llamada queda en la cola de espera.
            // Si el dispatcher pudo asignar la llamada, la borra de la cola.
            if(call != null){
                Dispatcher.getInstance().dispatchCall(call);
            }
            bool = showQueue(bool);
        }

    }

    /**
     * Este Bloque de Codigo se agrega con el fin de mostrar como se asignan las llamadas
     * al terminar los threads, como se encuentra la queue de llamadas, como los operadores
     * vuelven a estar disponibles para que el dispatcher le vuelva asignar una llamada y
     * como el dispatche atiende como maximo 10 llamadas.
     *
     * Por otra parte se genera un punto de fin para que el loop no quede infinito o
     * viendo si hay alguna llamada en la Queue de llamadas.
     *
     * La finalidad es mostrar lo que se detalla en el metodo assignCalls
     */
    private Boolean showQueue(Boolean bool){

        try {
            if( EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size()== 0
                    || EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.DIRECTOR).size()== 0
                || EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.SUPERVISOR).size()== 0) {
                Thread.sleep(500);
                System.out.println("LLamadas en la Queue: " + QueueCall.getQueue().size());
                System.out.println("Cantidad de Operadores:  " + EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size());
                System.out.println("Cantidad de Llamadas:  " + CallCounter.count());
            }

            if( CallCounter.count() == 0 ){
                System.out.println("Cantidad de Llamadas:  " + CallCounter.count());
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
