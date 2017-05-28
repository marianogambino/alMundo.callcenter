package almundo.com.callcenter.strategy;

import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;

/**
 * Created by mariano on 28/05/2017.
 */
public interface Strategy {
    Empleable apply(Call call);
}
