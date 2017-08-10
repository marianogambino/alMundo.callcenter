package almundo.com.callcenter.dispatcher;

import almundo.com.callcenter.model.*;
import almundo.com.callcenter.queue.QueueCall;
import almundo.com.callcenter.search.SearchAvailabilityEmp;
import almundo.com.callcenter.util.CallCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Representa la clase encargada de antender y derivar las llamadas a un empleado.
 */
public class Dispatcher {

    private static final Integer MAX_CALL = 10;
    private Logger logger = LoggerFactory.getLogger(Dispatcher.class);
    private static Dispatcher instance = new Dispatcher();
    private SearchAvailabilityEmp searhEmp;

    /**
     * Contructor. Instancia el Dispatcher.
     */
    private Dispatcher(){

        //this.searhEmp = SearchAvailabilityEmp.getInstance();

        //create thread pool and add thread by priority.
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

        //Se verifica la cantidad maxima de llamadas.
        if(CallCounter.count() < MAX_CALL) {

            //Obtengo el empleado asignandole la llamada, utilizando una estrategia de asignacion.

//            Empleable empleado = searhEmp.get();
//            //Si existe empleado que atienda la llamada.
//            if (empleado != null) {
//                //lanzo el hilo para tomar las llamadas de forma concurrente
//                empleado.setearLlamada(call);
//                CallCounter.add();
//                throwThread(empleado);
//            }

            //get thread of the thread pool according the priority
            //then set call to thread empleable or employ
            // and start thread.
            //when the thread finished must it back to pool.

        }
    }

    /**
     * Lanza un hilo/thread.
     * @param empleable
     */
    public void throwThread(Empleable empleable){
        Thread thread = new Thread(empleable);
        thread.start();
    }

    /**
     *
     * @param searhEmp
     */
    public void setSearhEmp(SearchAvailabilityEmp searhEmp) {
        this.searhEmp = searhEmp;
    }
}
