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
     *  Explicacion de porque el while true/ false para un fin del loop,
     *  La finalidad es mostrar como las llamadas entran a una cola, se van asignando a cada operador/sup/director
     *  y si hay llamadas pendientes se toma la que esta en la cola, ademas si no hay operadores
     *  disponibles esas llamadas quedan en la misma, por ende con este loop podemos ver que cuando se
     *  se desocupa un operador, vuelve a estar disponible y se le asignado una llamada a traves del
     *  dispatcher.
     */
    public void assignCalls(){

        Boolean bool = true;

        while (bool){
            Call call = QueueCall.getQueue().get();
            //Si existe una llamada y el dispatcher no pudo asignar la misma a un operador/sup/dir.
            if(call != null && !Dispatcher.getInstance().dispatcherCall(call) ){
                QueueCall.getQueue().push(call);
            }

            bool = showQueue(bool);

        }

    }

    /**
     * Este Bloque de Codigo se agrega con el fin de mostrar como se asignan las llamadas
     * al terminar los threads, como se encuentra la queue de llamadas y como los operadores
     * vuelven a estar disponibles para que el dispatcher le vuelva asignar una llamada.
     *
     * Por otra parte se genera un punto de fin para que el loop no quede infinito.
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
