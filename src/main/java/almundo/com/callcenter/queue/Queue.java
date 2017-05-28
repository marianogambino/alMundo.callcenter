package almundo.com.callcenter.queue;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariano on 27/05/2017.
 */
public class Queue<T> {

    private List<T> queue = new ArrayList<T>();

    public void push(T t) {
        this.queue.add(t);
    }

    public T get() {
        T element = null;
        if(this.queue.size()>0) {
            element = this.queue.get(0);
            this.queue.remove(0);
        }
        return element;
    }

    public int size(){
        return queue.size();
    }

    public void addAll(List<T> list){
        queue.addAll(list);
    }

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
