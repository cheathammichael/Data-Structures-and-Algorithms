/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1cheatham.dsa;

/**
 *
 * @author novem
 */
public class SumSeries1 
{
     public static void main(String[] args)
    {
        System.out.println("1: " + sumSeries1(1));
        System.out.println("2: " + sumSeries1(2));
        System.out.println("3: " + sumSeries1(3));
        System.out.println("4: " + sumSeries1(4));
        System.out.println("5: " + sumSeries1(5));
    }
    
    public static double sumSeries1(double i)
    {
        if(i == 1)
            return 1;
        else
            return sumSeries1(i - 1) + 1.0 / i;
    }
}   