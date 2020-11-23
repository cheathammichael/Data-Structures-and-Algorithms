/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.practice.recursion;

import java.util.ArrayList;

/**
 *
 * @author novem
 */
public class selectionSortRecursive {
    
    public static <E extends Comparable<E>> void SelectionSort(ArrayList<E> arr1)
    {
        int low = 0;
        int high = arr1.size() - 1;
        recurseSort(arr1, low, high);
    }
    
    public static <E extends Comparable<E>> void recurseSort(ArrayList<E> arr1, int low, int high)
    {
        E temp;
        int indexOfMin = low;
        if (low < high)
        {
            for (int i = low; i <= high; i++)
            {
                if (arr1.get(i).compareTo(arr1.get(indexOfMin)) < 0)
                {
                    indexOfMin = i;
                }
            }
         temp = arr1.get(low);
         arr1.set(low, arr1.get(indexOfMin));
         arr1.set(indexOfMin, temp);
         recurseSort(arr1, (low+1), high);
        }
    }
    
    public static void main(String[] args) {
        ArrayList arr1 = new ArrayList<>();
        arr1.add(101);
        arr1.add(56);
        arr1.add(22);
        arr1.add(34);
        arr1.add(77);
        arr1.add(1001);
        arr1.add(58);
        arr1.add(35);
        arr1.add(678);
        arr1.add(999);
        arr1.add(31);
        ArrayList arr2 = new ArrayList<>();
        arr2.add(101.0);
        arr2.add(99.0);
        arr2.add(11.0);
        arr2.add(55.0);
        arr2.add(89.0);
        arr2.add(75.0);
        arr2.add(33.0);
        arr2.add(44.0);
        arr2.add(56.0);
        arr2.add(110.0);
        arr2.add(220.0);
        arr2.add(1.0);
        ArrayList arr3 = new ArrayList<>();
        arr3.add("abc");
        arr3.add("xyz");
        arr3.add("jkl");
        arr3.add("ghi");
        arr3.add("def");
        arr3.add("mno");
        arr3.add("tuv");
        arr3.add("pqr");
        arr3.add("stu");
        
        SelectionSort(arr1);
        SelectionSort(arr2);
        SelectionSort(arr3);
        
        System.out.println(arr1);
        System.out.println("");
        System.out.println(arr2);
        System.out.println("");
        System.out.println(arr3);
        System.out.println("");
    }
    
}
