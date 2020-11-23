/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nov_2_stack;

/**
 *
 * @author novem
 */
public class MyStack2<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public Node<E> pop( )
    {
        if (!this.isEmpty())
        {
               Node<E> p = head;

            {
                for (int i = 0; i < size -2; i++)
                {
                    p = p.link;
                }
                tail = p;
                tail.link = null;
                size--;
                return tail;
            }
        }
        else return null;
    }
        
    
    public Node<E> push(E e)
    {
        Node<E> newNode = new Node();
        newNode.e = e;
        
        {
            this.tail.link = newNode;
            this.tail = newNode;
        }
        
        this.size++;
        return tail;
    }

    @Override
    public String toString() {
        
        Node<E> p = this.head;
        String s = "";
        s = "MyList{";
        while( p != null)
        {
            s += p.e.toString() + " ";
            p = p.link;
        }
        s += "size=" + size + '}';
        return s;
        
    }
    
    public Node<E> peek()
    {
        if (!this.isEmpty())
        return this.tail;
        else return null;
    }
    
    
    public boolean isEmpty()
    {
        return this.head == null && this.tail == null;
    }
    
    class Node<E>
    {
        E e;
        Node<E> link;
    }
    
    
    public static void main(String[] args) {
                MyStack<Integer> stack = new MyStack<>();
        
        System.out.println("Push: " + stack.push(10));
        System.out.println("Push: " + stack.push(20));
        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println(stack);
    }
}
