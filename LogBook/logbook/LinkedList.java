package logbook;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly-Linked List with a front and back reference.  
 * @author Alexander Iannuzzi
 * @version 1->5/29/19
 * @copyright Alexander Iannuzzi 5/28/19
 * @param <T> Generic Argument
 */
public class LinkedList<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;
    
    /**
     * Constructor for the DoublyLinkedList class.  
     */
    public LinkedList()
    {
        front = new Node<T>();
        back = new Node<T>();
        front.setNext(back);
        back.setPrev(front);
        size = 0;
    }
    
    /**
     * Adds a new Item at the back of the list.  
     * @param data Data to be stored in the list.  
     */
    public void add(T data)
    {
        add(data, size);
    }
    
    /**
     * Adds a new Item at a specified index of the list.  
     * @param data Data to be stored in the list.  
     */
    public void add(T data, int index)
    {
        if (data == null)
        {
            throw new IllegalArgumentException();
        }
        else if (index > size)
        {
            throw new IllegalStateException();
        }
        else if (size == 0)
        {
            Node<T> newItem = new Node<T>(data);
            front.setNext(newItem);
            back.setPrev(newItem);
            newItem.setPrev(front);
            newItem.setNext(back);
            size++;
        }
        else 
        {
            int counter = 0;
            Node<T> current = front.getNext();
            while (counter < index)
            {
                current = current.getNext();
                counter++;
            }
            Node<T> temp = current.getPrev();
            Node<T> newItem = new Node<T>(data);
            newItem.setNext(current);
            current.setPrev(newItem);
            newItem.setPrev(temp);
            temp.setNext(newItem);
            size++;
        }
    }
    
    /**
     * Replaces the element at the specified index with new data.  
     * @param data The data replacing the old data.  
     * @param index Location of the replacement.  
     */
    public void set(T data, int index)
    {
        if (data == null)
        {
            throw new IllegalArgumentException();
        }
        else if (index > size || size == 0)
        {
            throw new IllegalStateException();
        }
        else 
        {
            int counter = 0;
            Node<T> current = front;
            while (counter <= index)
            {
                current = current.getNext();
                counter++;
            }
            current.setData(data);
        }
    }
    
    /**
     * Returns the number of items contained in the list.  
     * @return Size of the list.  
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * Returns the data stored at a specified index of the list.  
     * @param index The index of the data.  
     * @return Data from the list.  
     */
    public T get(int index)
    {
        if (index < 0 || index > size - 1)
        {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = front.getNext();
        int counter = 0;
        while (counter < index)
        {
            current = current.getNext();
            counter++;
        }
        return current.getData();
    }
    
    /**
     * Removes an element at a specific index.  
     * @param index Index of the element being removed.  
     */
    public void remove(int index)
    {
        if (index < 0 || index > size - 1)
        {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0)
        {
            front.setNext(front.getNext().getNext());
            front.getNext().setPrev(front);
            size--;
        }
        else if (index == size - 1)
        {
            back.setPrev(back.getPrev().getPrev());
            back.getPrev().setNext(back);
            size--;
        }
        else
        {
            Node<T> removeNode = front.getNext();
            int counter = 0;
            while (counter < index)
            {
                removeNode = removeNode.getNext();
                counter++;
            }
            Node<T> tempBefore = removeNode.getPrev();
            Node<T> tempAfter = removeNode.getNext();
            tempBefore.setNext(tempAfter);
            tempAfter.setPrev(tempBefore);
            size--;
        }
    }
    
    /**
     * Removes an element from the back of the list.  
     */
    public void remove()
    {
        remove(size - 1);
    }
    
    /**
     * Clears the list and returns it to the original state.  
     */
    public void clear()
    {
        front.setNext(back);
        back.setPrev(front);
        size = 0;
    }
    
    /**
     * Returns the index of a specified entry.  
     * @param obj Object being searched for in the list.  
     * @return Index of the object or -1 if the object is not 
     * found in the list.  
     */
    public int indexOf(T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException();
        }
        if (front.getData().equals(obj))
        {
            return 0;
        }
        int counter = 0;
        Node<T> current = front;
        while (counter < size)
        {
            current = current.getNext();
            counter++;
            if (current.getData().equals(obj))
            {
                return counter;
            }
        }
        return -1;
    }
    
    /**
     * Determines whether or not the specified object is found 
     * in the list.  
     * @param obj The object being searched for.  
     * @return True if the object is found, false otherwise.  
     */
    public boolean contains(T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        Node<T> current = front;
        while (counter < size)
        {
            current = current.getNext();
            counter++;
            if (current.getData().equals(obj))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Determines whether or not the list is empty.  
     * @return True if the list is empty, false otherwise.  
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * Returns an array representation of the state of the list.  
     * @return Array representation of the list.  
     */
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = get(i);
        }
        return array;
    }
    
    /**
     * Creates a shallow copy of this list and returns it to the client.  
     * @return Shallow clone of the list.  
     */
    public LinkedList<T> clone()
    {
        LinkedList<T> list = new LinkedList<T>();
        for (int i = 0; i < size; i++)
        {
            list.add(get(i));
        }
        return list;
    }
    
    /**
     * Returns an Iterator object from this list.  
     * @return Iterator for the list.  
     */
    public Iterator<T> iterator()
    {
        return new ListIterator<T>();
    }
    
    /**
     * Inner class of Nodes to contain the data.  
     * @author Alexander Iannuzzi
     * @version 1->5/28/19
     * @copyright Alexander Iannuzzi 5/28/19
     * @param <E> Generic Argument
     */
    private class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        
        /**
         * Constructor for the Node class.  
         * @param data Data being contained in the Node.  
         */
        public Node(E data)
        {
            this.data = data;
            next = null;
            prev = null;
        }
        
        /**
         * Default Constructor for the Node class.  
         */
        public Node()
        {
            this(null);
        }
        
        /**
         * Getter method for the next node.  
         * @return Next node reference.  
         */
        public Node<E> getNext()
        {
            return next;
        }
        
        /**
         * Sets the next node reference for this.  
         * @param node Next node reference.  
         */
        public void setNext(Node<E> node)
        {
            next = node;
        }
        
        /**
         * Sets the previous node reference for this.  
         * @param node Previous node reference.  
         */
        public void setPrev(Node<E> node)
        {
            prev = node;
        }
        
        /**
         * Getter method for the previous node reference.  
         * @return previous node reference.  
         */
        public Node<E> getPrev()
        {
            return prev;
        }
        
        /**
         * Getter method for the data contained in the node.  
         * @return Data in the node.  
         */
        public E getData()
        {
            return data;
        }
        
        /**
         * Setter method for the data contained in the node.  
         * @param data The data that will be stored in this node.  
         */
        public void setData(E data)
        {
            this.data = data;
        }
    }
    
    /**
     * Private inner class that defines the behavior of an iterator 
     * for a DoublyLinkedList.  
     * @author Alexander Iannuzzi
     * @version 1->5/29/19
     * @copyright Alexander Iannuzzi 5/29/19
     * @param <A> Generic Argument
     */
    private class ListIterator<A> implements Iterator<T>
    {
        private Node<T> next;
        
        /**
         * Constructor for the Iterator class.  
         */
        public ListIterator()
        {
            next = LinkedList.this.front.getNext();
        }
        
        /**
         * Returns true if there exists another element in the list.  
         * @return True if there is another element, false if not.  
         */
        public boolean hasNext()
        {
            return next.getNext() != null;
        }
        
        /**
         * Returns the next element and advances the Iterator's cursor 
         * forward one 
         * @return Next element in the list.  
         */
        public T next()
        {
            if (hasNext())
            {
                T answer = next.getData();
                next = next.getNext();
                return answer;
            }
            else
            {
                throw new NoSuchElementException("No more elements in the list");
            }
        }
    }
    
    
    public String toString()
    {
    	String ans = "[ ";
    	Node<T> curr = front;
    	
    	while (curr.getNext().getData() != null)
    	{
    		ans += curr.getNext().getData().toString();
    		ans += " ";
    		curr = curr.getNext();
    	}
    	ans += "]";
    	return ans;
    }
    
}
