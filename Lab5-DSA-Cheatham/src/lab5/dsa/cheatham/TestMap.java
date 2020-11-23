/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.dsa.cheatham;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author novem
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap(); 
        hashMap.put("Smith", 20); 
        hashMap.put("Anderson", 21); 
        hashMap.put("Lewis", 18); 
        hashMap.put("Cook", 18); 

        System.out.println("Display entries in HashMap"); System.out.println(hashMap + "\n"); 
// a TreeMap from the preceding HashMap 
        Map<String, Integer> treeMap = new TreeMap<>(hashMap); 
        System.out.println("Display entries in ascending order of key"); 
        System.out.println(treeMap); 
// Create a LinkedHashMap 
//The load factor measures how full the set is allowed to 
//be before its capacity is increased 

    Map<String, Integer> linkedHashMap = new LinkedHashMap(16, 0.75f, true); 
    linkedHashMap.put("Smith", 20); 
    linkedHashMap.put("Anderson", 21); 
    linkedHashMap.put("Lewis", 19); 
    linkedHashMap.put("Cook", 19); 

// Display the age for Lewis 
    System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis")); 
    System.out.println("Display entries in LinkedHashMap"); 
    System.out.println(linkedHashMap); 
// Display each entry with name and age 
    System.out.println("\n--TreeMap for each--- Names and ages are "); 
    treeMap.forEach( (name, age) -> System.out.print(name + ": " + age + " ")); 
        System.out.println("");

// Display each entry with name and age 
    System.out.println("\n--LinkedHashMap for each--- Names and ages are "); 
    linkedHashMap.forEach((name, age)-> System.out.println(name + ": " + age + " "));
    
// Display each entry with name and age 
    System.out.println("\n--HashMap for each--- Names and ages are "); 
    hashMap.forEach( (name, age) -> System.out.println(name + ": " + age + " ")); 
    System.out.println(); 

    }
   
}