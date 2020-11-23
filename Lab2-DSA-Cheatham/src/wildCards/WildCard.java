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
public class WildCard {
    public static double max(lab2.dsa.cheatham.GenericStack<? extends Number> stack)
    {
        double max = -888;
        
        while (!stack.isEmpty())
        {double value = stack.pop().doubleValue();
        if (value > max)
        {
            max = value;
        }
        }
        return max;
    }
    
    public static void main(String[] args) {
        lab2.dsa.cheatham.GenericStack<Integer> intStack = new lab2.dsa.cheatham.GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
        System.out.println("The max number is " + max(intStack));
        
        lab2.dsa.cheatham.GenericStack<Double> doubleStack = new lab2.dsa.cheatham.GenericStack<>();
        doubleStack.push(1.0);
        doubleStack.push(2.0);
        doubleStack.push(3.0);
        System.out.println("The max number is " + max(doubleStack));
        //To demonstrate that the bounded wildcard allows for all sub-types
        //of the declared superclass.
    }
}
