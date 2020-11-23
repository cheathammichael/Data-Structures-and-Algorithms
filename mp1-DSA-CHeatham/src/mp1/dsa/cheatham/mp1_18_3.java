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
public class mp1_18_3 {
    
    public static int gcd(int var1, int var2)
    {
        if (var1 % var2 == 0)
            return var2;
        else return gcd(var2, var1%var2);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input two integers to find their GCD:");
        int var1 = scan.nextInt();
        int var2 = scan.nextInt();
        System.out.println(gcd(var1, var2));
    }
}
