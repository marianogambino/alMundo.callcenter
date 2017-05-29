package almundo.com.callcenter.strategy;

import almundo.com.callcenter.model.Call;
import almundo.com.callcenter.model.Empleable;

/**
 *
 */
public interface Strategy {

    /**
     *
     * @param call
     * @return
     */
    Empleable apply(Call call);
}
