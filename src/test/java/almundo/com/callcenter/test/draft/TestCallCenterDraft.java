package almundo.com.callcenter.test.draft;

import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by mariano on 27/05/2017.
 */
public class TestCallCenterDraft {

    private static Logger logger = LoggerFactory.getLogger(TestCallCenterDraft.class);
    private List<Call> calls = new ArrayList<Call>();
    private static List<Call> QUEUE_CALL = new ArrayList<Call>();

    @Before
    public void setUp(){
        crearLlamadas(12);
    }

    @Test
    public void testDispatcherCall(){

        EmpleadoBuilder.crearEmpleado(5, TipoEmpleadoEnum.OPERADOR);
        EmpleadoBuilder.crearEmpleado(3, TipoEmpleadoEnum.SUPERVISOR);
        EmpleadoBuilder.crearEmpleado(2, TipoEmpleadoEnum.DIRECTOR);

        //Con la lista de llamadas obtener op, sino sup , sino dir y sino poner llamada en una cola
        //con lo que si no hay llamadas pendientes asignar operador, si hay llamadas pendientes poner llamada en la cola de espera
        //, obtener llamada de la cola (es un list simple) la llamada y asignarla

        //Para asignar operadores verifico si tengo operadores disponibles

        Call callDispatcher;
        Empleable empleable;
        //llamadas entrantes

        //FALTA ################### cuando un operador termina tiene que volver a la cola para atender la proxima llamada
        for(Call call: calls){

            //El Dispacther siempre obtiene la misma instancia de si misma

            //Verifico si hay llamadas en espera/pendientes
            callDispatcher = call;
            if(QUEUE_CALL.size() > 0) {
                QUEUE_CALL.add(call);
                callDispatcher = QUEUE_CALL.get(0);
                QUEUE_CALL.remove(0);
            }

            if (EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size() > 0) {
                empleable = EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).get(0);
                empleable.asignarLLamada(callDispatcher);
                Thread t = new Thread(empleable);
                t.start();
                EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).remove(0);

            } else if (EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.SUPERVISOR).size() > 0) {
                empleable = EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.SUPERVISOR).get(0);
                empleable.asignarLLamada(callDispatcher);
                Thread t = new Thread(empleable);
                t.start();
                EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.SUPERVISOR).remove(0);

            } else if (EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.DIRECTOR).size() > 0) {
                empleable = EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.DIRECTOR).get(0);
                empleable.asignarLLamada(callDispatcher);
                Thread t = new Thread(empleable);
                t.start();
                EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.DIRECTOR).remove(0);
            } else {
                QUEUE_CALL.add(callDispatcher);
            }

        }

        logger.info("Calls en la Queue: {} " , QUEUE_CALL.size());


    }

    @Test
    public void testRandom(){
       Random ran = new Random();
        int x = 0;

        for(int i=0; i < 30 ; i++) {
            x = ran.nextInt(6) + 5;
            logger.info("Ramdon: {} ", x* 1000);
        }
    }

    @Test
    public void random2(){
        Random ran = new Random();
        int dig3 = ran.nextInt(900)+100; //siempre 3 digitos
        int dig5 = ran.nextInt(90000)+10000; //siempre 5 digitos
        //9000000000L
        long dig13 = ran.nextLong() +1000000000000L; //siempre 13 digitos
        logger.info("Ramdon: {} ", dig13);
    }

    private void crearLlamadas(int cantLlamadas){
        for(int i=0; i<cantLlamadas; i++) {
            calls.add( Call.newInstance( "Call" + (i+1) ));
        }
    }



}
