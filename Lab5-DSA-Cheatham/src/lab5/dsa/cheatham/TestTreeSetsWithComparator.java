/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.dsa.cheatham;

import java.util.*;

import java.util.*;

public class TestTreeSetsWithComparator {
  public static void main(String[] args) {
    // Create a tree set for geometric objects using a comparator
    Set<GeometricObject> set =
      new TreeSet<>(new GeometricObjectComparator());
    set.add(new Rectangle(4, 5));
    set.add(new Circle(40));
    set.add(new Circle(40));
    set.add(new Rectangle(4, 1));

    // Display geometric objects in the tree set
    System.out.println("A sorted set of geometric objects");
    for (GeometricObject element: set)
      System.out.println("area = " + element.getArea());
  }
}