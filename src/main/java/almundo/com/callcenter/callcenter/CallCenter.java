package almundo.com.callcenter.callcenter;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.dispatcher.Dispatcher;
import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.queue.QueueCall;

/**
 * Clase que representa al CallCenter
 *
 */
public class CallCenter {

    public static CallCenter newInstance(){
        return new CallCenter();
    }

    /**
     * Contructor privado.
     */
    private CallCenter(){}

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
            // la llamada queda en la cola de espera. Si el dispatcher pudo asignar la llamada
            // la borra la misma de la cola.
            if(call != null){
                Dispatcher.getInstance().dispatcherCall(call);
            }
            bool = showQueue(bool);
        }

    }

    /**
     * Este Bloque de Codigo se agrega con el fin de mostrar como se asignan las llamadas
     * al terminar los threads, como se encuentra la queue de llamadas y como los operadores
     * vuelven a estar disponibles para que el dispatcher le vuelva asignar una llamada.
     *
     * Por otra parte se genera un punto de fin para que el loop no quede infinito o
     * viendo si hay alguna llamada en la Queue de llamadas.
     *
     * La finalidad es mostrar lo que se detalla en el metodo assignCalls
     */
    private Boolean showQueue(Boolean bool){

        try {
            if( EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size()== 0) {
                Thread.sleep(1000);
                System.out.println("LLamadas en la Queue: " + QueueCall.getQueue().size());
                System.out.println("Cantidad de Operadores:  " + EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size());
            }
            if(QueueCall.getQueue().size() == 0){
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
