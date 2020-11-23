/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.dsa.cheatham;

/**
 *
 * @author novem
 * @param <E>
 */
public class GenericStack2<E> extends java.util.ArrayList<E> {
    
    
    public int getSize()
    {
        return this.size();
    }
    
    public void push(E o)
    {
        this.add(o);
    }
    
    public E peek()
    {
        return this.get(this.size()-1);
    }
    public E pop()
    {
        return this.remove(this.size()-1);
    }
    
    
    @Override
    public boolean isEmpty()
    {
        return (this.size() == 0);

    }
    
    
    public void clear()
    {
        this.clear();
    }
    

    public static void main(String[] args) {
    
    GenericStack2<Integer> stackInt = new GenericStack2();
    GenericStack2<String> stackString = new GenericStack2();
    
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
