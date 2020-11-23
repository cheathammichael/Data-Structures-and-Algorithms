/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp4.dsa.cheatham;

import java.util.Scanner;

/**
 *
 * @author novem
 */
public class test2 {
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

    System.out.println("\nQ/q: to quit");
    System.out.println("1: to calculate the square of a number");
    System.out.println("2: to calculate the square root of a number");
    //2. INITIALIZATION OF THE CONDITION

    for (
            String s = scan.next(); s.charAt(0) != 'Q' && s.charAt(0) != 'q'; 
        )
        {
        if (s.charAt(0) == '1' || s.charAt(0) == '2')
            {
            System.out.println("enter the number:");
            double number = scan.nextDouble();
            System.out.println((s.charAt(0) == '1')
            ? "the square : " + (number * number)
            : "the square root : " + Math.pow(number, 0.5));
            }
        else if (s.charAt(0) != 'Q' && s.charAt(0) != 'q')
            {
            System.out.println("invalid character");
            }
        System.out.println("\nQ/q: to quit");
        System.out.println("1: to calculate the square of a number");
        System.out.println("2: to calculate the square root of a number");
        s = scan.next();
        }
    }
}

