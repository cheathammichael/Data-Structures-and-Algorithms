/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.dsa.cheatham;

/**
 *
 * @author novem
 */
public class CircularList<E> {
        private Node<E> head;
    private int size;
    
    public void remove( int index )
    {
        if (( index < 0 || index > size || (size == 0)))
            throw new IndexOutOfBoundsException();
        
        if (size == 1)//1 node exactly
        {
            head = null;
            size--;
        }
        else//2 or more nodes
        {
            Node<E> p = head;
            //case we remove at head
            if (index == 0)
            {
                head = head.link;
            }
            //case we remove at tail (size - 1)
            else if (index  == size-1) 
            {   for (int i = 0; i < size -2; i++)
                    p = p.link;
                p.link = head;
                {
                 //do nothing, just adbvance p   
                }
            }
            //case we remove in the middle
            else 
            {   for (int i = 0; i < index -1; i++)
                    p = p.link;
                p.link = p.link.link;
                {
                 //do nothing, just adbvance p   
                }
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
            head = newNode;
        }
        else if ( index == 0 )//insert at position 0
        {
            newNode.link = head;
            head = newNode;
        }
        else if ( index >= size-1 )//insert at the end of the list
        {
            Node<E> p = this.head;
            for (int i = 0; i < size - 1; i++)
                p = p.link;
                
                //p points at the node before the insert
            newNode.link = p.link;
            p.link = newNode;
            }
        else //insert in the middle
        {
            //go to the point of insertion
            Node<E> p = this.head;
            for (int i = 0; i < index -1; i++)
                p = p.link;
                
                //p points at the node before the insert
                newNode.link = p.link;
                p.link = newNode;
            
        }
        this.size++;
    }

    @Override
    public String toString() {
        
        Node<E> p = this.head;
        String s = "";
        s = "MyList{";
        for (int i = 0; i < size; i++)
        {
            s += p.e.toString() + " ";
            p = p.link;
        }
        s += "size=" + size + '}';
        return s;
        
    }
    
    public void clear()
    {
        head = null;
        size = 0;
    }
    
    
    public boolean isEmpty()
    {
        return this.head == null;
    }
    
    class Node<E>
    {
        E e;
        Node<E> link;
    }
    
    public static void main(String[] args) {
        CircularList<Integer> list = new CircularList<Integer>();
        
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
