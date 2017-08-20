package almundo.com.callcenter.test.integration;

import almundo.com.callcenter.dispatcher.Dispatcher;
import almundo.com.callcenter.model.Call;
import org.junit.Before;
import org.junit.Test;

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
        Thread.sleep(3000);

        for(int i=0; i< 10; i++){
            Call call = new Call("Call "+ i, "156666777"+i);
            dispatcher.dispatchCall(call);
        }

    }

    /**
     *
     */
    @Test
    public void testConMasDiezDeLlamadas(){

    }


}
