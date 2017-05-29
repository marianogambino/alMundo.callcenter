package almundo.com.callcenter.strategy;

import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;

/**
 *
 */
public class Context {

    public static Context getContext(Strategy strategy){
        return new Context(strategy);
    }

    private Strategy strategy;

    /**
     *
     * @param strategy
     */
    private Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     *
     * @param call
     * @return
     */
    public Empleable executeStrategy(Call call){
        return this.strategy.apply(call);
    }

}
