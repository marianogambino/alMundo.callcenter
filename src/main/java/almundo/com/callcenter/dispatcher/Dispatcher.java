package almundo.com.callcenter.dispatcher;

import almundo.com.callcenter.model.*;
import almundo.com.callcenter.threadPool.HubEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Representa la clase encargada de antender y derivar las llamadas a un empleado.
 */
public class Dispatcher {


    private Logger logger = LoggerFactory.getLogger(Dispatcher.class);
    private static Dispatcher instance = new Dispatcher();

    private HubEmployee hub;

    /**
     * Contructor. Instancia el Dispatcher.
     */
    public Dispatcher(){
     this.hub = new HubEmployee(10);
    }

    /**
     * Obtiene siempre la misma instacia del dispatcher.
     * @return la instancia del dispatcher.
     */
    public static Dispatcher getInstance(){
        return instance;
    }

    /**
     * Se encarga de asignar una llamada a un empleado siendo este un hilo/thread.
     * @param call representa una llamada.
     */
    public void dispatchCall(Call call){
        this.hub.execute(call);
    }




}
