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
public class mp1_18_21 {
    static String result = "";
    public static String dec2Bin(int value)
    {
        if (value == 0)
            return result;
        result = result + String.valueOf(value % 2);
        dec2Bin(value/2);
            return result;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a decimal number to see it converted to binary:");
        int base = scan.nextInt();
        System.out.println(dec2Bin(base));
    }
}
