/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3.dsa.cheatham;

/**
 *
 * @author novem
 */
import java.util.Scanner;
import java.util.TreeSet;


public class mp3_21_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a URL: ");
        String url = input.nextLine();
        crawler(url);
    }
    
    public static void crawler(String startingURL)
    {
        TreeSet<String> listOfPendingURLs = new TreeSet<>();
        TreeSet<String> listOfTraversedURLs = new TreeSet<>();
        
        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() && 
                listOfTraversedURLs.size() <=100)
        {
            
            String urlString = listOfPendingURLs.pollFirst();
            if (!listOfTraversedURLs.contains(urlString))
            {
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawl " + urlString);
                
                for (String s : getSubURLs(urlString))
                {
                    if (!listOfTraversedURLs.contains(s))
                    {
                        listOfPendingURLs.add(s);
                    }
                }
            }
        }
        
    }
    public static TreeSet<String> getSubURLs(String urlString)
        {
            TreeSet<String> list = new TreeSet<>();
            try 
            {
                java.net.URL url = new java.net.URL(urlString);
                Scanner input = new Scanner(url.openStream());
                int current = 0;
                while (input.hasNext())
                {
                    String line = input.nextLine();
                    current = line.indexOf("https:", current);
                    while (current > 0)
                    {
                        int endIndex = line.indexOf("\"", current);
                        if (endIndex > 0)
                        {
                            list.add(line.substring(current, endIndex));
                            current = line.indexOf("https:", endIndex);
                        }
                        else current = -1;
                    }
                        
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
            return list;
        }
    
}
