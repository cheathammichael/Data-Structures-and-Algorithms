/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsortpleasedontmakeuswritethis;

import java.util.ArrayList;

/**
 *
 * @author novem
 */
public class HeapSort {
   ArrayList<Integer> heap = new ArrayList();
    
    void add( int node)
    {
        heap.add(node);
        int childIndex = heap.size()-1;
        int parentIndex = -1;
        if ( childIndex % 2 != 0 )
            parentIndex = (childIndex - 1 ) / 2;
        else
            parentIndex = (childIndex - 2 ) / 2;
            
        while ( parentIndex >= 0 && 
                heap.get( parentIndex ) <  heap.get( childIndex ) 
                
               )
            {
            int temp = heap.get( parentIndex );
            heap.set(parentIndex, heap.get( childIndex ) );
            heap.set(childIndex, temp);
            
            childIndex = parentIndex;
            
            if ( childIndex % 2 != 0 )
                parentIndex = (childIndex - 1 ) / 2;
            else
                parentIndex = (childIndex - 2 ) / 2;
            
            }
    }
    public void traverseHeap()
    {
        int i = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (i < this.heap.size()&& !arr.contains(this.heap.size() -1))
        {
            
            System.out.println("P: " + this.heap.get(i) + " ");
                arr.add(i);
                if (((2 * i) + 1) < this.heap.size()&& !(arr.contains(((2 * i) + 1))))
                {
                    System.out.println("L: " + this.heap.get((2 * i) + 1));
                    arr.add(((2 * i) + 1));
                
                }
                    if (((2 * i) + 2) < this.heap.size()&& !(arr.contains(((2 * i) + 2))))
                    {
                        System.out.println("R: " + this.heap.get((2 * i) + 2));
                        arr.add((2 * i) + 2);
                    }
                i++;
        }
        
    }
    
    public Integer remove()
    {
        if (heap.size() == 0)
          {
            return null;
          }

        //save the root to return it
        Integer removedObject = heap.get(0);
        //move the last node to the root
        heap.set(0, heap.get(heap.size() - 1));
        //remove the last node
        heap.remove(heap.size() - 1);

        int currentIndex = 0;
        while (currentIndex < heap.size())
          {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= heap.size())
              {
                break; // The tree is a heap
              }
            //find the maximum of the two
            int maxIndex = leftChildIndex;
            if (rightChildIndex < heap.size())
              {
                if (heap.get(maxIndex) < 
                        heap.get(rightChildIndex))
                  {
                    maxIndex = rightChildIndex;
                  }
              }

            // Swap if the current node is less than the maximum
            if (heap.get(currentIndex) <
                    heap.get(maxIndex) )
              {
                Integer temp = heap.get(maxIndex);
                heap.set(maxIndex, heap.get(currentIndex));
                heap.set(currentIndex, temp);
                currentIndex = maxIndex;
              }
            else
              {
                break; // The tree is a heap
              }
          }

        return removedObject;
    }
    
    void testPrintedSorted()
    {
        Integer o = null;
        while ((o = remove()) != null)
        System.out.print(o + " ");
        System.out.println("");
    }
    
    public static void main( String...args)
    {
        //3, 5, 1, 19, 11,22
        //HeapSort hp = new HeapSort();
        //hp.add(3);
        //hp.add(5);
        //hp.add(1);
        //hp.add(19);
        //hp.add(11);
        //hp.add(22);
        //hp.traverseHeap();
        //hp.testPrintedSorted();
    }
     
}
