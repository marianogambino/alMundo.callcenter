package almundo.com.callcenter.queue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa una Queue que contiene una tipo de Objeto T determinado.
 * @param <T>
 */
public class Queue<T> {

    private java.util.Queue<T> queue = new LinkedList<T>();

    /**
     * Agrega un objeto a la Queue.
     * @param t objeto ha agregar a la Queue.
     */
    public void push(T t) {
        this.queue.add(t);
    }


    /**
     * Obtiene el primer objeto de la Queue.
     * @return un objeto.
     */
    public T get() {
        return this.queue.peek();
    }

    public void remove(){
        this.queue.remove();
    }

    public int size(){
       return this.queue.size();
    }

}
