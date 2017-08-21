package almundo.com.callcenter.test.integration.threadPoolExecutor;

/**
 * Created by mariano on 20/08/17.
 */
public enum Priority {

    HIGHEST(0),
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    LOWEST(4);

    int value;

    Priority(int val) {
        this.value = val;
    }

    public int getValue(){
        return value;
    }

}
