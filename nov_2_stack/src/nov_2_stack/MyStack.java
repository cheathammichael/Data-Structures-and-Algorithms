/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nov_2_stack;

import java.util.ArrayList;

/**
 *
 * @author novem
 */
public class MyStack<E> {
    private ArrayList<E> stack = new ArrayList<>();
    int top = -1;//empty stack
    
    public E push (E e)
    {
        this.stack.add(e);
        top++;
        return e;
    }
    
    public E pop ()
    {
        
        if (!this.isEmpty())
        {   
            top--;
            return this.stack.remove(top + 1);
            
        }
            
        else return null;
    }
    
    public E peek ()
    {
        if (!this.isEmpty())
            return this.stack.get(top);
        else return null;
    }

    @Override
    public String toString() {
        return "MyStack{" + "stack=" + stack + ", top=" + top + '}';
    }
    
    public boolean isEmpty()
    {
        return (this.top == -1);
            
    }
    
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        
        System.out.println(stack.push(10));
        System.out.println(stack.push(20));
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
        
        
    }
}
