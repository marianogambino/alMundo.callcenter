package almundo.com.callcenter.test.integration;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.callcenter.CallCenter;
import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.queue.QueueCall;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariano on 28/05/2017.
 */
public class TestCallCenter {

    private List<Call> calls = new ArrayList<Call>();

    @Before
    public void setUp(){
        crearLlamadas(10);
    }

    @Test
    public void testDispatcherCall(){
        CallCenter callcenter = CallCenter.newInstance();
        QueueCall.getQueue().addAll(calls);
        //Se agregan dos llamadas nuevas
        QueueCall.getQueue().push(Call.newInstance( "New Call 11"));
        QueueCall.getQueue().push(Call.newInstance( "New Call 12"));
        callcenter.assignCalls();
    }


    private void crearLlamadas(int cantLlamadas){
        for(int i=0; i<cantLlamadas; i++) {
            calls.add( Call.newInstance( "Call" + (i+1) ));
        }
    }
}
