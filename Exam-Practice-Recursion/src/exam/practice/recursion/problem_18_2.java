/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.practice.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author novem
 */
public class problem_18_2 {
 /**       public static boolean anagramHelper(String s, String d)
    {
        if (s.length() != d.length())
            return false;
        int duration = s.length() -1;
    ArrayList<Character> chars1 = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            chars1.add(c);}
    ArrayList<Character> chars2 = new ArrayList<Character>();
        for (char e : d.toCharArray()) {
            chars2.add(e);}
               
        return anagram(chars1, chars2, duration);
        
} **/
    public static boolean anagramHelper(String s, String d)
    {
        int duration = s.length()-1;
        return anagram(s, d, duration);
    }
    
    public static boolean anagram(String s, String d, int duration)
    {
        if (s.length()!= d.length())
            return false;
        if (duration == 0)
        {
            for (int i = 0; i < d.length(); i++)
            {
                if (s.charAt(duration)==d.charAt(i))
                    return true;
            }
            return false;
        }
        else
            for (int i = 0; i < d.length(); i++)
            {
                if (!(s.charAt(duration)==d.charAt(i)))
                    return false;
            }  
        
        return anagram(s,d,--duration);
        
    }
    
    public static void main(String[] args) {
        String s;
        String d;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input two words to see if they are anagrams of each other:");
        s = scan.next();
        d = scan.next();
        System.out.println("Are they anagrams of each other?");
        System.out.println(anagramHelper(s, d));
        
    }
}
