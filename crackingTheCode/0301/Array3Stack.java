import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array3Stack<Item>
{
    private Item[] a;
    private int N1, N2, N3;
    private int size;

    public Array3Stack()
    {
        size = 10;

        a = (Item []) new Object[3*size];
        N1 = 0;
        N2 = 0;
        N3 = 0;
    }

    public boolean isEmpty()
    {
        return N1 == 0 && N2 == 0 && N3 == 0;
    }

    public int size()
    {
        return N1 + N2 + N3;
    }

    //not accurate, but leave it now

    private void resize(int capacity)
    {
        assert capacity > size;

        Item[] temp = (Item []) new Object[capacity*3];

        for(int nIndex = 0; nIndex < N1; nIndex++)
            temp[nIndex] = a[nIndex];

        for (int nIndex = 0; nIndex < N2; nIndex++)
            temp[nIndex+capacity] = a[nIndex+capacity/2];

        for (int nIndex = 0; nIndex < N3; nIndex++)
            temp[nIndex + capacity*2] = a[nIndex + capacity];

        a = temp;
    }

    public void push(int select, Item item)
    {
        if (select == 0)
        {
            if (N1 == size)
            {
                resize(2*size);
                size = 2*size;
            }

                a[N1++] = item;
        }

        else if (select == 1)
        {
            if (N2 == size)
            {
                resize(2*size);
                size = 2*size;
            }

            a[size + N2++] = item;
        }

        else if (select == 2)
        {
            if (N3 == size)
            {
                resize(2*size);
                size = 2*size;
            }

            a[size*2 + N3++] = item;
        }

    }


    public Item pop(int select)
    {
        if (select == 0)
        {
            if (N1 == 0)
                return null;
            N1--;
            return a[N1];
        }

        if (select == 1)
        {
            if (N2 == 0)
                return null;
            N2--;
            return a[size + N2];
        }

        if (select == 2)
        {
            if (N3 == 0)
                return null;
            N3--;
            int index = size*2 + N3;
            return a[index];
        }

        return null;

    }
}