package almundo.com.callcenter.queue;

import almundo.com.callcenter.model.Call;

/**
 * Clase que contiene una cola de llamadas;
 *
 */
public class QueueCall {
    private static Queue<Call> queue = new Queue<Call>();

    /**
     * Metodo que retorna la cola de llamadas.
     * @return Queue.
     */
    public static Queue<Call> getQueue(){
        return queue;
    }
}
