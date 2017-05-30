package almundo.com.callcenter.queue;


import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una Queue que contiene una tipo de Objeto T determinado.
 * @param <T>
 */
public class Queue<T> {

    private List<T> queue = new ArrayList<T>();

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
        T element = null;
        if(this.queue.size()>0) {
            element = this.queue.get(0);
            //this.queue.remove(0);
        }
        return element;
    }

    public void remove(T t){
        if(this.queue.size()>0) {
            this.queue.remove(t);
        }
    }

    /**
     * Obtiene el tamanio de la Queue.
     * @return un entero.
     */
    public int size(){
        return queue.size();
    }

    /**
     * Agregar todos los objetos de una lista.
     * @param list lista de objetos.
     */
    public void addAll(List<T> list){
        queue.addAll(list);
    }

    /**
     * Checkea si hay disponiblidad en la Queue.
     * Si existen objetos en la cola, toma el primer objeto y pone en la cola
     * aquel que se recibe por parametro sino retorma el mismo.
     * @param t objeto que se recibe por parametro.
     * @return objeto de la Queue o el parametro recibido.
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
