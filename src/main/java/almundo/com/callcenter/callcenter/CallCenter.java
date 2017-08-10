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
     */
    private CallCenter(){
           }

    /**
     *
     */
    public void assignCalls(){

        Boolean bool = true;
        do{
            Call call = QueueCall.getQueue().get();
            QueueCall.getQueue().remove();
            Dispatcher.getInstance().dispatchCall(call);
        }while (QueueCall.getQueue().get()!=null);

    }


}
