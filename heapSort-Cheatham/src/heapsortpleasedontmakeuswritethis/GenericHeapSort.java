/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsortpleasedontmakeuswritethis;

import java.util.Comparator;

/**
 *
 * @author novem
 */
public class GenericHeapSort<E>
{

    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    private java.util.Comparator<? super E> c;

    /**
     * Create a default heap using a natural order for comparison
     */
    public GenericHeapSort()
    {
        this.c = (E e1, E e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a heap with a specified comparator
     */
    public GenericHeapSort(java.util.Comparator<E> c)
    {
        this.c = c;
    }
    /**
     * Sorts the array into comparator order, feeds it back
     * into the array.
     * @param objects 
     */
/**Sorts the array using Comparator's Order
 * 
 * @param ar 
 */
    public void heapSort(  E[] ar  )
    {
       for ( E e :ar )
            add( e);
       E e;
       int i=0;
       while( (e = remove()) != null)
           ar[i++] = e; 
    }
    
    
    /**
     * Create a heap from an array of objects
     */
    private GenericHeapSort(E[] objects)
    {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
          {
            add(objects[i]);
          }
    }

    /**
     * Add a new object into the heap
     */
    public void add(E newObject)
    {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0)
          {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (c.compare(list.get(currentIndex),
                    list.get(parentIndex)) > 0)
              {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
              }
            else
              {
                break; // the tree is a heap now
              }
            currentIndex = parentIndex;
          }
    }

    /**
     * Remove the root from the heap
     */
    public E remove()
    {
        if (list.size() == 0)
          {
            return null;
          }

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size())
          {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size())
              {
                break; // The tree is a heap
              }
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size())
              {
                if (c.compare(list.get(maxIndex),
                        list.get(rightChildIndex)) < 0)
                  {
                    maxIndex = rightChildIndex;
                  }
              }

            // Swap if the current node is less than the maximum
            if (c.compare(list.get(currentIndex),
                    list.get(maxIndex)) < 0)
              {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
              }
            else
              {
                break; // The tree is a heap
              }
          }

        return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize()
    {
        return list.size();
    }

    /**
     * Return true if heap is empty
     */
    public boolean isEmpty()
    {
        return list.size() == 0;
    }
    public static void main(String[] args) {
        GenericHeapSort<Integer> gh = new GenericHeapSort();
        
        Integer[] ar = {50, 2, 90, 44, 3, 77, 8, 120, 8, 12, 12 };
        
        gh.heapSort(ar);
        
        for (Integer i: ar)
            System.out.print(i + " ");
    }
}


