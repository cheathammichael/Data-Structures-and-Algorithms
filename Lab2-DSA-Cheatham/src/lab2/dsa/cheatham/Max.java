/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.dsa.cheatham;

/**
 *
 * @author novem
 * @param <E>
 */
public class Max<E> {

    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0) {
            return o1;
        } else {
            return o2;
        }
    }

    public static <E extends Comparable<E>> E maxSafe(E e1, E e2) {
        if (e1.compareTo(e2) > 0) {
            return e1;
        } else {
            return e2;
        }
    }

    public static void main(String[] args) {
        System.out.println(max(1, 2));
        try {
            System.out.println(maxSafe(1, 2));
            System.out.println(maxSafe("abc", "ABC"));
            System.out.println("");
            //System.out.println(maxSafe(1, "two"));
            System.out.println(max(1, "two"));
        } catch (Exception e) {
            System.err.println("Danger Will Robinson!");
        }
    }
}
