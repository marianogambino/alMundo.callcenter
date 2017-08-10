package almundo.com.callcenter.test.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mariano on 28/07/17.
 */
public class TestQueue {

    private Queue<String> queue = new LinkedList<String>();

    @Before
    public void setUp(){
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
    }

    /**
     * Get a element but the queue is empty throws NoSuchElementException
     */
    @Test
    public void getElement(){
        String e = queue.element();
        Assert.assertEquals("A" , e);
    }

    /**
     * just like element() operation it retrieves
     * and returns the head of the queue, without removing it.
     * In this situation when the queue is empty, it returns null
     */
    @Test
    public void peek(){
        String e = queue.peek();
        Assert.assertEquals("A" , e);
    }

    /**
     * Insert a element to tail of the queue. If there is no space available because of capacity
     * restriction IllegalStateException is throws.
     */
    @Test
    public void addElement(){
        Queue<String> queue = new LinkedList<String>();
        queue.add("E");
        String e = queue.peek();
        Assert.assertEquals("E" , e);
    }

    /**
     * Adds the element e to the tail of the queue.
     * If the insertion is successful the method returns true, otherwise it returns false
     */
    @Test
    public void offerElement(){
        Queue<String> queue = new LinkedList<String>();
        queue.offer("E");
        String e = queue.peek();
        Assert.assertEquals("E" , e);
    }

    /**
     * Remove a element but the queue is empty throws NoSuchElementException
     */
    @Test
    public void removeElement(){
        queue.remove();
        String e = queue.peek();
        Assert.assertEquals("B" , e);
    }

    /**
     * like remove() function,
     * it retrieves and removes the head of the queue.
     * The only difference from remove() is that poll() operation returns null when the queue is empty.
     */
    @Test
    public void pollElement(){
        String e = queue.poll();
        String ele = queue.peek();
        Assert.assertEquals("A" , e);
        Assert.assertEquals("B" , ele);
    }
}
