import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class Stack<Item> implements Iterable<Item>
{
    private int N;  //size of stack
    private Node top;
    private Comparator<Item> comparator;
    private Item min;

    // private class Node<Item> implements Comparable<Node>
    private class Node<Item>
    {
        private Item item;

        private Node next;

        public Node()
        {
            item = null;
            next = null;
        }

        public Node(Item item)
        {
            item = item;
            next = null;
        }
    }
    
    public Stack()
    {
        top = null;
        min = null;
        N = 0;
        comparator = null;
    }
    
    public Stack(Comparator<Item> comparator)
    {
        this();
        this.comparator = comparator;
        
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public void push(Item item)
    {
        if (top == null)
        {
            top = new Node(item);
            top.item = item;
            N++;
            min = item;
            return;
        }


        Node old = top;
        
        if (comparator == null)
        {
            if (((Comparable<Item>) item).compareTo(min) < 0)
                min = item;
        }
        
        else if (comparator != null)
        {
            if (comparator.compare(min, item) > 0)
                min = item;
        }
        
        top = new Node(item);
        top.item = item;
        // top.item = item;
        top.next = old;
        N++;
    }

    public Item min()
    {
        return min;
    }

    public Item pop()
    {
        if (top == null)
            return null;

        //Node old = top.next;
        Item item = (Item) top.item;
        // System.out.println("(" + item + ", " + min + ")");
        top = top.next;
        N--;

        // System.out.println("(" + item + ", " + min + ")");
        if (top == null)
            return item;

        else if (((Comparable<Item>) item).compareTo(min) <= 0)
        {
            Node current = top;
            System.out.println("The node after remove the top is " + current.item);
            min = (Item) current.item;
            item = (Item) current.item;
            while (current != null)
            {
                if (((Comparable <Item>) item).compareTo(min) < 0)
                {
                    System.out.println(item + " is less than " + min + "? " + (((Comparable <Item>) item).compareTo(min) <= 0));
                    //very strange here... 
                    System.out.println("minimu before the remove is " + min);
                    min = (Item) current.item;
                    System.out.println("minimu after the remove is " + min);
                }

                current = current.next;
            }
        }

        return item;
    }

    public Item peek()
    {
        if (top == null)
            return null;

        return (Item)top.item;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();

        for (Item item : this)
            str.append(item + " ");

        return str.toString();
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = top;

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new NoSuchElementException();
        }

        public Item next()
        {
            if (!hasNext())
                return null;

            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) 
    {
        Stack<Integer> nStack = new Stack<Integer>();

        nStack.push(0);
        System.out.println(nStack.min());

        nStack.push(1);
        nStack.push(2);
        System.out.println(nStack.min());
        // System.out.println(nStack.min());
        System.out.println(nStack.pop());
        System.out.println(nStack.min());
        System.out.println(nStack.pop());
    }
}
