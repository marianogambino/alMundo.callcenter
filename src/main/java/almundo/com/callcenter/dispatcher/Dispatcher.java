package almundo.com.callcenter.dispatcher;

import almundo.com.callcenter.model.*;
import almundo.com.callcenter.queue.QueueCall;
import almundo.com.callcenter.strategy.Context;
import almundo.com.callcenter.strategy.EmpStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Representa la clase encargada de antender y derivar las llamadas a un empleado.
 */
public class Dispatcher {

    private Logger logger = LoggerFactory.getLogger(Dispatcher.class);
    private static Dispatcher instance = new Dispatcher();

    /**
     * Contructor. Instancia el Dispatcher.
     */
    private Dispatcher(){
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
    public void dispatcherCall(Call call){
        //Obtengo el empleado asignandole la llamada, utilizando una estrategia de asignacion.
        Empleable empleado = Context.getContext(EmpStrategy.getInstance()).executeStrategy();
        //Si existe empleado que atienda la llamada.
        if(empleado != null){
            //lanzo el hilo para tomar las llamadas de forma concurrente
            empleado.asignarLLamada(call);
            QueueCall.getQueue().remove(call);
            throwThread(empleado);
        }
    }

    /**
     * Lanza un hilo/thread.
     * @param empleable
     */
    private void throwThread(Empleable empleable){
        Thread t = new Thread(empleable);
        t.start();
    }




}
