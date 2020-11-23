/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1.dsa.cheatham;

import java.util.Scanner;

/**
 *
 * @author novem
 */
public class mp1_18_7 {
    
    static int count = 0;
    
     public static long fib(long index) {
        
         count++;
            if (index == 0)
                    return 0;
            else if (index == 1)
                    return 1;
            else return fib(index - 1) + fib(index - 2);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an index for a Fibonacci number:");
        int index = input.nextInt();
        
        System.out.println("The Fibonacci number at index " + index + " is " + fib(index) 
        + " and the method was called " + count + " times!");
    }
}
