package almundo.com.callcenter.strategy;

import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;

/**
 * Contexto, clase que contiene y ejecuta una estrategia determinada.
 */
public class Context {

    /**
     * Metodo estatico que retonar una instancia de contexto
     * para ejecutar una estrategia determinada.
     * @param strategy estrategia determinada.
     * @return una instancia de contexto.
     */
    public static Context getContext(Strategy strategy){
        return new Context(strategy);
    }

    private Strategy strategy;

    /**
     * Contructo privado
     * @param strategy una instancia de estrategia.
     */
    private Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * Metodo que ejecuta una estrategia.
     * @return una instancia de empleado.
     */
    public Empleable executeStrategy(){
        return this.strategy.get();
    }

}
