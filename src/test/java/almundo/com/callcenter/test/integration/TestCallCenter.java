package almundo.com.callcenter.test.integration;

import almundo.com.callcenter.callcenter.CallCenter;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.queue.QueueCall;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test de Integracion
 *
 * Prueba de integracion del CallCenter
 *
 */
public class TestCallCenter {

    private List<Call> calls = new ArrayList<Call>();

    /**
     *
     */
    @Before
    public void setUp(){
        crearLlamadas(10);
    }

    /**
     *
     */
    @Test
    public void testCallCenter(){
        CallCenter callcenter = CallCenter.newInstance();
        QueueCall.getQueue().addAll(calls);
        callcenter.assignCalls();
    }

    /**
     *
     */
    @Test
    public void testConMasDiezDeLlamadas(){
        CallCenter callcenter = CallCenter.newInstance();
        //Se agregan diez llamadas a una queue.
        QueueCall.getQueue().addAll(calls);
        //Se agregan dos llamadas nuevas
        QueueCall.getQueue().push(Call.newInstance( "New Call 11"));
        QueueCall.getQueue().push(Call.newInstance( "New Call 12"));
        QueueCall.getQueue().push(Call.newInstance( "New Call 13"));
        callcenter.assignCalls();
    }

    /**
     *
     * @param cantLlamadas
     */
    private void crearLlamadas(int cantLlamadas){
        for(int i=0; i<cantLlamadas; i++) {
            calls.add( Call.newInstance( "Call" + (i+1) ));
        }
    }
}
