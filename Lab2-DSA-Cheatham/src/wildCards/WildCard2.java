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
public class WildCard2 {
    public static void print(lab2.dsa.cheatham.GenericStack<?> stack)
    {
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop() + " ");
        }
    }
    public static void main(String[] args) {
        lab2.dsa.cheatham.GenericStack<Integer> intStack = new lab2.dsa.cheatham.GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
        
        print(intStack);
    }
}
