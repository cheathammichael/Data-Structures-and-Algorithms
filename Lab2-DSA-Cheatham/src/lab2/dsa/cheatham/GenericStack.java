package lab2.dsa.cheatham;


public class GenericStack<E> {

    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void clear()
    {
        list.clear();
    }
    
    @Override
    public String toString() {
        String s = "stack: [";
        for (int i = list.size() - 1; i >=0; --i)
        {
            s += list.get(i);
            s += (i > 0) ? ", " : "]";
        }
        return s;
    }


    public static void main(String[] args) {
        GenericStack<Integer> stackInt = new GenericStack();
        GenericStack<String> stackString = new GenericStack();
        
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        System.out.println(stackInt);
        
        stackString.push("a");
        stackString.push("b");
        stackString.push("c");
        System.out.println(stackString);
        
        stackString.pop();
        System.out.println(stackString);
        
        stackInt.pop();
        System.out.println(stackInt);
        
        System.out.println("stackString top element is " + stackString.peek());
        System.out.println("stackInt top element is " + stackInt.peek());
        
        System.out.println("stackString size is " + stackString.getSize());
        System.out.println("stackInt size is " + stackInt.getSize());
        
        stackInt.clear();
        stackString.clear();
        
        System.out.println("stackInt is empty? " + stackInt.isEmpty());
        System.out.println("stackString is empty? " + stackString.isEmpty());
    }
}


