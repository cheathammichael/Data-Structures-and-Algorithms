/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3.dsa.cheatham;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author novem
 */
public class mp3_21_15 {
    public static void main(String[] args) {
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);
        TreeSet<Integer> incorrect = new TreeSet<>();
        Scanner input = new Scanner(System.in);
        
        System.out.println(""
        + "What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();
        if (number1 + number2 != answer)    
            incorrect.add(answer);
        int count = 0;
        while (number1 + number2 != answer)
        {
            if (count > 0 && incorrect.contains(answer))
            {
                System.out.println("You already tried " + answer + ". Guess another number.");
            }
            else System.out.println("Wrong answer. Try again.");
            if (!incorrect.contains(answer))
                incorrect.add(answer);
            System.out.println(""
            + "What is " + number1 + " + " + number2 + "? ");
            answer = input.nextInt();
            count++;
            
        }
        System.out.println("You got it!");
    }
}
