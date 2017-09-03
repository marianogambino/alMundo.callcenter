package almundo.com.callcenter.model;

/**
 * Created by mariano on 20/08/17.
 */
public enum PriorityTask {

    OPERATOR(0),
    SUPERVISOR(1),
    DIRECTOR(2);

    private int value;


    PriorityTask(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
