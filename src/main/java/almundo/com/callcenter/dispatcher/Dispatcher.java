package almundo.com.callcenter.dispatcher;

import almundo.com.callcenter.model.*;
import almundo.com.callcenter.strategy.Context;
import almundo.com.callcenter.strategy.EmpStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 */
public class Dispatcher {

    private Logger logger = LoggerFactory.getLogger(Dispatcher.class);
    private static Dispatcher instance = new Dispatcher();

    /**
     *
     */
    private Dispatcher(){
    }

    public static Dispatcher getInstance(){
        return instance;
    }

    /**
     *
     * @param call
     * @return
     */
    public Boolean dispatcherCall(Call call){
        //Obtengo el empleado asignandole la llamada
        Empleable empleado = Context.getContext(EmpStrategy.getInstance()).executeStrategy(call);
        //Si existe empleado que atienda la llamda
        if(empleado != null){
            //lanzo el hilo para tomar las llamadas de forma concurrente
            throwThread(empleado);
            return true;
        }
        return false;
    }

    /**
     *
     * @param empleable
     */
    private void throwThread(Empleable empleable){
        Thread t = new Thread(empleable);
        t.start();
    }




}
