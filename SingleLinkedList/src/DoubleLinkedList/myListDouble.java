/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;

/**
 *
 * @author novem
 */
public class myListDouble<E> {
     private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public void remove( int index )
    {
        if (( index < 0 || index > size || (size == 0)))
            throw new IndexOutOfBoundsException();
        
        if (size == 1)//1 node exactly
        {
            head = tail = null;
            size--;
        }
        else//2 or more nodes
        {
            Node<E> p = head;
            //case we remove at head
            if (index == 0)
            {
                head = head.next;
                head.previous = null;
            }
            //case we remove at tail (size - 1)
            else if (index  == size-1)
            {
                tail = tail.previous;
                tail.next = null;
            }
            //case we remove in the middle
            else 
            {   for (int i = 0; i < index -1; i++)
                p = p.next;
                p.next = p.next.next;
                p.next.previous = p;
            }
        }
        size--;
        
    }
    
    public void add( E e, int index)
    {
        Node<E> newNode = new Node();
        newNode.e = e;
        
        if ( isEmpty() )//list is empty
        {
            head = tail = newNode;
        }
        else if ( index == 0 )//insert at position 0
        {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        else if ( index >= size-1 )//insert at the end of the list
        {
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        else //insert in the middle
        {
            //go to the point of insertion
            Node<E> p = this.head;
            for (int i = 0; i < index - 1; i++)
                p = p.next;
                
                //p points at the node before the insert
                
                newNode.next = p.next;
                newNode.previous = p;
                p.next.previous = newNode;
                p.next = newNode;
                
            
        }
        this.size++;
    }

    @Override
    public String toString() {
        
        Node<E> p = this.head;
        String s = "";
        s = "MyList{";
        while( p != null)
        {
            s += p.e.toString() + " ";
            p = p.next;
        }
        s += "size=" + size + '}';
        return s;
        
    }
    
    public void clear()
    {
        head = tail = null;
        size = 0;
    }
    
    
    public boolean isEmpty()
    {
        return this.head == null && this.tail == null;
    }
    
    class Node<E>
    {
        E e;
        Node<E> next;
        Node<E> previous;
    }
    
    public static void main(String[] args) {
        myListDouble<Integer> list = new myListDouble<Integer>();
        
        list.add(10, 0);
        list.add(20, 1);
        list.add(30, 3);
        list.add(40, 5);
        list.add(5, 0);
        list.add(15, 2);
        
        
        System.out.println(list);
        
        list.remove(0);
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        
        list.clear();
        System.out.println(list);
        
        list.add(10, 0);
        list.add(20, 1);
        list.add(30, 3);
        list.add(40, 5);
        list.add(5, 0);
        list.add(15, 2);
        
        System.out.println(list);
        
    }
}
