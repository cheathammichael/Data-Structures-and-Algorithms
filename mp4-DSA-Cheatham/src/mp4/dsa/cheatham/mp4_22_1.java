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
public class mp4_22_1 {
    
    
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Input a string to see the maximum consecutive increasingly ordered substring: ");
        String str = scan.next();
        String sub = "";
        String min = "";
        int k = 0;
        int j = 0;
        int l = 0;
        
        for (int i = 0; i + 1 < str.length(); i++)
        {
                if (str.charAt(i+1) > str.charAt(i))
                {
                    for (j = i+1, l = i ; j < str.length(); )
                        if ((str.charAt(j) > str.charAt(l)))
                        {
                            j++; 
                            l++;
                        }
                        else break;
                    sub = str.substring(i, j);
                    if (min.compareTo(sub) < 0)
                    min = sub;
                    sub = "";
                    i = j - 1;
                    j = 0;
                    l = 0;
                }
        }
        System.out.println(min);       
    }
}
