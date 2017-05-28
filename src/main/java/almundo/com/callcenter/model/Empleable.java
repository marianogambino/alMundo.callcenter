package almundo.com.callcenter.model;

/**
 * Created by mariano on 26/05/2017.
 */
public interface Empleable extends Runnable {

    void asignarLLamada(Call llamada);
}
