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
     */
    public void assignCalls(){

        while (true){
            Call call = QueueCall.getQueue().get();
            //Si existe una llamada y el dispatcher no pudo asignar la misma a un operador/sup/dir.
            if(call != null && !Dispatcher.getInstance().dispatcherCall(call) ){
                QueueCall.getQueue().push(call);
            }

            showQueue();

        }

    }

    /**
     * Este Bloque de Codigo se agrega con el fin de mostrar como se asignan las llamadas
     * al terminar los threads, como se encuentra la queue de llamadas y como los operadores
     * vuelven a estar disponibles para tomar las proximas llamadas.
     *
     */
    private void showQueue(){

        try {
            if( EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size()== 0) {
                Thread.sleep(1000);
                System.out.println("LLamadas en la Queue: " + QueueCall.getQueue().size());
                System.out.println("Cantidad de Operadores:  " + EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
