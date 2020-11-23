/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.dsa.cheatham;

/**
 *
 * @author novem
 */
public class GenericStack1<E> {
    private int capacity = 3;
    private E[] list = (E[])new Object[capacity];
    private int topOfStack= -1;
    
    public int getSize()
    {
        return topOfStack+1;
    }
    
    public E peek()
    {
        return list[topOfStack];
    }
            
    public void push(E o)
    {
        list[ ++topOfStack] = o;
    }
    
    public E pop()
    {
        return list[topOfStack--];
    }
    
    public boolean isEmpty()
    {
        return topOfStack == -1;
    }
    
    public void clear()
    {
        topOfStack = -1;
    }

    @Override
    public String toString() {
        return "GenericStack1{" + "list=" + list + '}';
    }
    
    public static void main(String[] args) {
        GenericStack1<Integer> stackInt = new GenericStack1();
        GenericStack1<String> stackString = new GenericStack1();
        
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        System.out.println(stackInt);
        
        stackString.push("a");
        stackString.push("b");
        stackString.push("c");
        System.out.println(stackString);
    }
}
