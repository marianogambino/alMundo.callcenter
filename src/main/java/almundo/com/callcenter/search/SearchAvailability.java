package almundo.com.callcenter.search;

import almundo.com.callcenter.model.Empleable;

/**
 * Interface utilizada para contener una estrategia
 */
public interface SearchAvailability {

    /**
     * Metodo de interface especifico para implementar una estrategia determinada.
     *
     * @return una instancia de Empleado (Op/Sup/Dir) contenida en la interface Empleable.
     */
    Empleable get();
}
