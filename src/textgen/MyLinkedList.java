package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;
        
    LLNode<E> dummy;


    /** Create a new empty LinkedList */
    public MyLinkedList() {
        // TODO: Implement this method
        size = 0;
        head = new LLNode<E>(null);
        tail = new LLNode<E>(null);
        
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Appends an element to the end of the list
     * @param element The element to add
     */
    public boolean add(E element ) 
    {
	// TODO: Implement this method
        if(element == null){
            throw new NullPointerException();
        }
	// TODO: Implement this method
        LLNode<E> nuevaLista = new LLNode<E>();
        nuevaLista.data = element;
        
        nuevaLista.next = tail;
        nuevaLista.prev = tail.prev;
        tail.prev.next = nuevaLista;
        tail.prev = nuevaLista;
        
        size++;
        return false;
    }

    /** Get the element at position index 
     * @throws IndexOutOfBoundsException if the index is out of bounds. */
    public E get(int index) 
    {
        // TODO: Implement this method.
        if(size==0 || index <0 || index>=size){
            throw new IndexOutOfBoundsException(); 
        }
        
        dummy = head.next;
        
        for(int i=0;i<size;i++){
            if(i==index){
                return dummy.data;
            }
            dummy = dummy.next;
        }
        return null;
    }

    /**
     * Add an element to the list at the specified index
     * @param The index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element ) 
    {
        // TODO: Implement this method
        if(element == null){
            throw new NullPointerException("");
        }
        if(index <0 || index>size){
            throw new IndexOutOfBoundsException("add"); 
        }
        
        LLNode<E> nuevaLista = new LLNode<E>();
        nuevaLista.data = element;
        
        dummy = head.next;
        
        for(int i=0;i<=size;i++){
            if(i==index){
                nuevaLista.next = dummy;
                nuevaLista.prev = dummy.prev;
                dummy.prev.next = nuevaLista;
                dummy.prev = nuevaLista;
                size++;
                break;
            }
            dummy = dummy.next;
        }
    }


	/** Return the size of the list */
    public int size() 
    {
        return size;
    }

    /** Remove a node at the specified index and return its data element.
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     * 
     */
    public E remove(int index) 
    {
        // TODO: Implement this method
        if(size==0 || index <0 || index>=size){
            throw new IndexOutOfBoundsException(); 
        }
                
        dummy = head.next;
        for(int i=0;i<size;i++){
            if(i==index){
                dummy.prev.next = dummy.next;
                dummy.next.prev = dummy.prev;
                                
                size--;
                return dummy.data;
            }
            dummy = dummy.next;
        }  
        return dummy.data;
    }

    /**
     * Set an index position in the list to a new element
     * @param index The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) 
    {
        // TODO: Implement this method
        if(element == null){
            throw new NullPointerException("");
        }
        if(size==0 || index <0 || index>=size){
            throw new IndexOutOfBoundsException(); 
        }
                
        dummy = head.next;
        
        for(int i=0;i<size;i++){
            if(i==index){
                dummy.data = element;
                return dummy.data;
            }
            dummy = dummy.next;
        }
        return dummy.data;
    }   
}

class LLNode<E> 
{
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    // TODO: Add any other methods you think are useful here
    // E.g. you might want to add another constructor

    public LLNode(E e) 
    {
        this.data = e;
	this.prev = null;
	this.next = null;
    }
    
    public LLNode() 
    {
	this.data = null;
	this.prev = null;
	this.next = null;
    }

}
