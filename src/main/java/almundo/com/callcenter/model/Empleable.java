package almundo.com.callcenter.model;

/**
 * Interface Empleable con tiene un objeto (Empleado).
 */
public interface Empleable extends Runnable {

    /**
     * Setea una llamada telefonica.
     * @param llamada telefonica.
     */
    void asignarLLamada(Call llamada);
}
