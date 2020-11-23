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
public class mp1_18_22 {

    static StringBuilder result = new StringBuilder("");
    static String result1 = "";

    public static String dec2Hex(int value) {
        if (value <= 0) {
            result1 = result.reverse().toString();
            return result1;
        } else {
            int resultPart = (value % 16);
            if (resultPart < 10) {
                result = result.append(resultPart);
            } else {
                switch (resultPart) {
                    case 10:
                        result.append("A");
                        break;
                    case 11:
                        result.append("B");
                        break;
                    case 12:
                        result.append("C");
                        break;
                    case 13:
                        result.append("D");
                        break;
                    case 14:
                        result.append("E");
                        break;
                    case 15:
                        result.append("F");
                        break;
                }
            }
            dec2Hex(value / 16);
        }
        return result1;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a decimal number to see it converted to hexadecimal:");
        int base = scan.nextInt();
        System.out.println(dec2Hex(base));
    }
}
