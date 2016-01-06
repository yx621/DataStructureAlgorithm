import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>
{
    Node front;
    Node back;
    int N;


    private class Node
    {
        Item item;
        Node next;

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

    public Queue()
    {
        front = null;
        back = null;
        N = 0;
    }

    public void enqueue(Item item)
    {
        if (front == null)
        {
            back = new Node(item);
            front = back;
            N++;
        }

        else
        {
            Node NTemp = new Node(item);
            back.next = NTemp;
            back = back.next;
            N++;
        }
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return front == null;
    }

    public Item dequeue()
    {
        if (front == null)
            return null;

        if (front == back)
        {
            Item item = front.item;
            front = null;
            back = null;
            N--;
            return item;
        }

        Item item = front.item;
        front = front.next;
        N--;
        return item;
    }

    public Item peek()
    {
        if (front == null)
            return null;

        return front.item;
    }

    public String toString()
    {
        StrignBuilder str = new StrignBuilder();
        for (Item item : this)
            str.append(item + " ");

        return str.toString;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator<Item>(front);
    }

    private class ListIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;

        public ListIterator(Node <Item> front)
        {
            current = front;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
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