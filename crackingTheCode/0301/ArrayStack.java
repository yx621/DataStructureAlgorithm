import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<Item> implements Iterable<Item>
{
    private Item[] a;
    private int N;

    public ArrayStack()
    {
        a = (Item []) new Object[2];
        N = 0;
        //need to remember that
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private void resize(int capacity)
    {
        assert capacity > N;

        Item[] temp = (Item []) new Object[capacity];

        for (int nIndex = 0; nIndex < N; nIndex++)
            temp[nIndex] = a[nIndex];
        a = temp;
    }

    public void push(Item item)
    {
        if (N == a.length)
            resize(2 * a.length);

        a[N++] = item;

    }

    public Item pop()
    {
        if (isEmpty())
            return null;

        Item item = a[N - 1];

        a[N - 1] = null;

        N--;
        return item;
    }

    public Item peek()
    {
        if (isEmpty())
            return null;

        return a[N-1];
    }

    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i;

        public ReverseArrayIterator()
        {
            i = N - 1;
        }

        public boolean hasNext()
        {
            return i >= 0;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (!hasNext())
                return null;

            Item item = a[i];
            i--;
            return item;
        }
    }


}