/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaanonymousandcomparator;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author novem
 */
public class LambdaAnonymousAndComparator {


    public I1 testAnonymousClass()
    {
       
        I1 i1 = (int x) -> ++x;
        return i1;
    }
    
    public I2 testAnonymous1()
    {
        I2 i2 = (int x, int y) -> x + y;
        return i2;
    }
    
    public I3 testAnonymous2()
    {
        I3 i3 = new I3() {
            @Override
            public int method1() {
                return 1;}
        };
        return i3;
    }
    
    public void testAnonymous3()
    {
        I4 i4 = new I4() {
            @Override
            public void method1() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int method2(int x) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyCollection mc = new MyCollection();
        
        Comparator c = mc.comparator();
        
        System.out.println(c.compare(new A(10), new A(20)));
    }
 
}

interface I1
{
    int method1(int x);
}

interface I2
{
    int method1(int x, int y);
}

interface I3
{
    int method1();
}

interface I4
{
    void method1();
    int method2(int x);
}

class MyCollection
{
    private ArrayList<A> list = new ArrayList();
    
    public Comparator<A> comparator()
    {
       Comparator<A> c = (A o1, A o2) -> o1.x - o2.x ;
       return c;
    }
    
}

class A
{
    int x;
    public A(int x){this.x = x;}
}