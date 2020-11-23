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
public class mp1_18_13 {
    static int count = 0;
    static int max = 0;
    public static int findMax(int[] n)
    {
        count++;
        if (count > 8)
            return max;
        else if (n[count - 1] > max)
        {
            max = n[count - 1];
        }
        findMax(n);
            return max;
    }
    
    
    public static void main(String[] args) {
        int[] n = new int[8]; 
        Scanner input = new Scanner(System.in);
        System.out.println("Enter eight integers to see the greatest in the series: ");
        for (int i = 0; i < 8; i++)
        {
            n[i] = (input.nextInt());
        }
        System.out.println(findMax(n));
    }
}
