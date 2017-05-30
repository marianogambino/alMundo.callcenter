package almundo.com.callcenter.strategy;

import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;

/**
 * Interface utilizada para contener una estrategia
 */
public interface Strategy {

    /**
     * Metodo de interface especifico para implementar una estrategia determinada.
     *
     * @return una instancia de Empleado (Op/Sup/Dir) contenida en la interface Empleable.
     */
    Empleable get();
}
