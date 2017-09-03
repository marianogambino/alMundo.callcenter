package almundo.com.callcenter.test.integration;

import almundo.com.callcenter.dispatcher.Dispatcher;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Operador;
import almundo.com.callcenter.model.PriorityTask;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;


/**
 * Test de Integracion
 *
 * Prueba de integracion del CallCenter
 *
 */
public class TestCallCenter {


    /**
     *
     */
    @Before
    public void setUp(){

    }

    /**
     *
     */
    @Test
    public void testCallCenter() throws InterruptedException {

        Dispatcher dispatcher = new Dispatcher();
        Thread dispatch = new Thread(dispatcher);
        dispatch.start();

        for(int i=0; i< 20; i++){
            Call call = new Call("Call "+ (i+1), "156666777"+ (i+1));
            dispatcher.dispatchCall(call);
        }

        dispatch.join();

    }

    /**
     *
     */
    @Test
    public void testConMasDiezDeLlamadas(){

    }


}
