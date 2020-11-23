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
public class mp4_22_2 {
     
        public static void main(String[] args) {
     
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Input a string to see the maximum consecutive increasingly ordered substring: ");
        String str = scan.next();
        String max = "";
        String temp = "";
        int temp1 = 0;
        int temp2 = 0;
        
        for (int i = 0; i < str.length(); i++)
        {
            temp += str.charAt(i);
            for (int j = i + 1; j < str.length(); j++)
            {
                if (str.charAt(j) > str.charAt(j-1))
                {
                    temp += str.charAt(j);
                    temp1 += (int)str.charAt(j);
                }
            }
            if (temp1 > temp2)
            {
                max = temp;
                temp2 = temp1;
            }
            temp1 = 0;
            temp = "";
        }
            System.out.println(max);
    }
}
