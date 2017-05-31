package almundo.com.callcenter.test.unit;

import almundo.com.callcenter.dispatcher.Dispatcher;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;
import almundo.com.callcenter.model.Operador;
import almundo.com.callcenter.queue.QueueCall;
import almundo.com.callcenter.search.SearchAvailabilityEmp;
import almundo.com.callcenter.util.CallCounter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * JUnit Test dispatchCall
 */
public class UnitTestDispatcher {


    @Before
    public void setUp(){

    }

    @Test
    public void testDispatchCall(){
        Call call = mock(Call.class);
        QueueCall.getQueue().push(call);
        Dispatcher dispatcher = spy(Dispatcher.getInstance());

        Empleable empleable = mock(Operador.class);
        SearchAvailabilityEmp searhEmp = mock(SearchAvailabilityEmp.class);

        when(searhEmp.get()).thenReturn(empleable);
        Mockito.doNothing().when(dispatcher).throwThread(empleable);

        dispatcher.setSearhEmp(searhEmp);
        dispatcher.dispatchCall(call);

        Assert.assertTrue(QueueCall.getQueue().size() == 0);

    }

    @Test
    public void sinEmpleadoDisponibles(){
        Call call = mock(Call.class);
        QueueCall.getQueue().push(call);
        Dispatcher dispatcher = spy(Dispatcher.getInstance());

        Empleable empleable = null;
        SearchAvailabilityEmp searhEmp = mock(SearchAvailabilityEmp.class);

        when(searhEmp.get()).thenReturn(empleable);
        Mockito.doNothing().when(dispatcher).throwThread(empleable);

        dispatcher.setSearhEmp(searhEmp);
        dispatcher.dispatchCall(call);

        Assert.assertTrue(QueueCall.getQueue().size() == 1);

    }

    @Test
    public void conLimiteMaximaDeLlamadas(){
        Call call = mock(Call.class);
        QueueCall.getQueue().push(call);
        Dispatcher dispatcher = spy(Dispatcher.getInstance());

        Empleable empleable = mock(Operador.class);
        SearchAvailabilityEmp searhEmp = mock(SearchAvailabilityEmp.class);

        for(int i=1;i<=10;i++) {
            CallCounter.add();
        }
        when(searhEmp.get()).thenReturn(empleable);
        Mockito.doNothing().when(dispatcher).throwThread(empleable);

        dispatcher.setSearhEmp(searhEmp);
        dispatcher.dispatchCall(call);

        Assert.assertTrue(QueueCall.getQueue().size() == 1);

    }
}
