import edu.princeton.cs.algs4.Stack;
public class SetOfStacks<E>
{
    private int plateSize;
    private int plateNumber;
    private int palteInUse;

    private Stack<E> [] stackset;
    

    public SetOfStacks()
    {
        plateNumber = 2;
        plateSize = 10;
        palteInUse = 0;
        // stackset = (E []) new Stack<Object>[plateNumber];
        stackset = (Stack<E> []) new Stack[plateNumber];
        
        for (int nIndex = 0; nIndex < plateNumber; nIndex++)
        {
            stackset[nIndex] = new Stack<E>();
        }
    }

    public SetOfStacks(int number)
    {
        plateNumber = number;
        plateSize = 10;
        palteInUse = 0;
        stackset = (Stack<E> []) new Stack[number];

        for (int nIndex = 0; nIndex < number; nIndex++)
        {
            stackset[nIndex] = new Stack<E>();
        }
    }

    public SetOfStacks(int number, int size)
    {
        plateNumber = number;
        plateSize = size;
        palteInUse = 0;
        stackset = (Stack<E> []) new Stack[number];

        for (int nIndex = 0; nIndex < number; nIndex++)
        {
            stackset[nIndex] = new Stack<E>();
        }
    }


    public void push(E item)
    {
        if ((palteInUse == plateNumber - 1) && (stackset[palteInUse].size() == plateSize))
        {
            System.out.println("stack out of memory, need to resize");
            return;
        }

        if (stackset[palteInUse].size() < plateSize)
        {
            stackset[palteInUse].push(item);
            return;
        }

        else if (palteInUse < plateNumber - 1)
        {
            palteInUse++;
            stackset[palteInUse].push(item);   
            return;
        }

        else
        {
            System.out.println("stack out of memory, need to resize");
            return;   
        }
    }


    public E pop()
    {
        if (stackset == null)
            return null;

        if (stackset[palteInUse].size() == 0)
            return null;

        if (stackset[palteInUse].size() > 1)
            return stackset[palteInUse].pop();
        
        else if (stackset[palteInUse].size() == 1)
        {
            palteInUse--;
            return stackset[palteInUse+1].pop();
        }

        return null;
    }

    public E popAt(int index)
    {
        if (index > palteInUse)
        {
            System.out.println("stack array out of bound");
            return null;
        }

        if (stackset[index].size() == 0)
        {
            System.out.println("this sub-stack has been empty");
            return null;
        }

        return stackset[index].pop();
    }

    public static void main(String[] args) 
    {
        SetOfStacks<Integer> setstack = new SetOfStacks<Integer>();

        setstack.push(0);

        for (int nIndex = 0; nIndex < 12; nIndex++)
            setstack.push(nIndex+1);

        System.out.println("**********************");
        for (int nIndex = 0; nIndex < 15; nIndex++)
        {
            System.out.print(setstack.popAt(0) + " ");
        }

        System.out.println("\n**********************");

        for (int nIndex = 0; nIndex < 13; nIndex++)
        {
            System.out.print(setstack.pop() + " ");
        }

        System.out.println("\n**********************");
    }



}