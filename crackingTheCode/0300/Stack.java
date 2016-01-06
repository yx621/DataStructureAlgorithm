import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>
{
    private int N;  //size of stack
    private Node top;

    private class Node
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
        N = 0;
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
        Node old = top;
        top = new Node(item);
        // top.item = item;
        top.next = old;
        N++;
    }

    public Item pop()
    {
        if (top == null)
            return null;

        //Node old = top.next;
        Item item = top.item;
        top = top.next;
        N--;
        return item;
    }

    public Item peek()
    {
        if (top == null)
            return null;

        return top.item;
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

    private class ListIterator implements Iterator<Itme>
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

            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
