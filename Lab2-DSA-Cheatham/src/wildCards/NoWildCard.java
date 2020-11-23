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
public class NoWildCard {
    public static double max(lab2.dsa.cheatham.GenericStack<Number> stack)
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
        //This line makes this class unusable
        //System.out.println("The max number is " + max(intStack));
    }
}
