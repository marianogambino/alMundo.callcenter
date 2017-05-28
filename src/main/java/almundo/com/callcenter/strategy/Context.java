package almundo.com.callcenter.strategy;

import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;

/**
 * Created by mariano on 28/05/2017.
 */
public class Context {

    public static Context getContext(Strategy strategy){
        return new Context(strategy);
    }

    private Strategy strategy;

    private Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Empleable executeStrategy(Call call){
        return this.strategy.apply(call);
    }

}
