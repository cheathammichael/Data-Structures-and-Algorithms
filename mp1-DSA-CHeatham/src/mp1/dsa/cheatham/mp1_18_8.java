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
public class mp1_18_8 {
    static int count = 0;
    static String n = "";
    /**
     * Previous method, before I realized 
     * I needed an integer as the parameter. 
     * Adapted to use an integer, but methodology
     * remains the same.
     * 
    public static void reverse(String n)
    {
        if (count == 0)
            System.out.print(n.charAt(0));
        else
        {
            System.out.print(n.charAt(count--));
            reverse(n);
        }
    }
    **/
    
    public static void reverseDisplay(int value)
    {
        n = String.valueOf(value);
        
        if (count == 0)
            System.out.print(n.charAt(0));
        else
        {
            System.out.print(n.charAt(count--));
            reverseDisplay(value);
        }
    }
    public static void main(String[] args) {
        
                Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to see it displayed in reverse: ");
        int base = input.nextInt();
        n = String.valueOf(base);
        count = n.length() - 1;
        reverseDisplay(base);
        System.out.println("");
    }
    
}
