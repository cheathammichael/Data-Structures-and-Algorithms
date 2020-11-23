/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildCards;

/**
 *
 * @author novem
 */
public class WildCardWithSuper {
    public static <T> void add(lab2.dsa.cheatham.GenericStack<T> stack1, 
            lab2.dsa.cheatham.GenericStack<? super T> stack2 )
    {
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
    }
        public static <T> void add1(lab2.dsa.cheatham.GenericStack<String> stack1, 
                lab2.dsa.cheatham.GenericStack<? super Object> stack2 )
    {
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        lab2.dsa.cheatham.GenericStack<String> stack1 = new lab2.dsa.cheatham.GenericStack<>();
        lab2.dsa.cheatham.GenericStack<Object> stack2 = new lab2.dsa.cheatham.GenericStack<>();
        stack2.push("one");
        stack2.push(2);
        stack1.push("one");
        
        add(stack1, stack2);
        WildCard2.print(stack2);
    }
}   
