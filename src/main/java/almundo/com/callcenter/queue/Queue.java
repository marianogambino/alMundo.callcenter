package almundo.com.callcenter.queue;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T>
 */
public class Queue<T> {

    private List<T> queue = new ArrayList<T>();

    public void push(T t) {
        this.queue.add(t);
    }

    /**
     *
     * @return
     */
    public T get() {
        T element = null;
        if(this.queue.size()>0) {
            element = this.queue.get(0);
            this.queue.remove(0);
        }
        return element;
    }

    /**
     *
     * @return
     */
    public int size(){
        return queue.size();
    }

    /**
     *
     * @param list
     */
    public void addAll(List<T> list){
        queue.addAll(list);
    }

    /**
     *
     * @param t
     * @return
     */
    public T checkAvailability(T t) {
        T aux = t;
        if(queue.size() > 0 ){
            queue.add(t);
            aux = queue.get(0);
            queue.remove(0);
        }
        return aux;
    }

}
