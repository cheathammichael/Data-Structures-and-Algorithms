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
public class mp1_18_23 {
    
    static int count = 0;
    static int count1 = 0;
    public static int bin2Dec(String binaryString)
    {
        if (count < 0)
            return 0;
        return ((int)(Math.pow(2, count--)) * Character.getNumericValue(binaryString.charAt(count1++))) + bin2Dec(binaryString);
        
        
        
    }
    
        public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a binary number to see it converted to decimal:");
        String base = scan.next();
        count = base.length() -1;
        System.out.println(bin2Dec(base));
    }
}
