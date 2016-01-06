import edu.princeton.cs.algs4.Stack;
public class queueStack<E>
{
    private Stack<E> inqueue = new Stack<E>();
    private Stack<E> outqueue = new Stack<E>();

    public queueStack()
    {
        inqueue = new Stack<E>();
        outqueue = new Stack<E>();
    }
    public void enqueue(E e)
    {
        inqueue.push(e);
    }

    public E dequeue()
    {
        if (inqueue == null && outqueue == null)
            return null;

        if (outqueue.isEmpty())
        {
            while (!inqueue.isEmpty())
            {
                outqueue.push(inqueue.pop());
            }
        }
        
        if (outqueue.isEmpty())
            return null;

        return outqueue.pop();
    }


    public static void main(String[] args) 
    {
        queueStack<Integer> queue1 = new queueStack<Integer>();

        for (int nIndex = 0; nIndex < 5; nIndex++)
        {
            queue1.enqueue(nIndex);

        }


        for (int nIndex = 0; nIndex < 3; nIndex ++)
        {
            System.out.print(queue1.dequeue() + " ");
        }


        for (int nIndex = 0; nIndex < 10; nIndex ++)
        {
            queue1.enqueue(nIndex + 5);
        }

        for (int nIndex = 0; nIndex < 20; nIndex ++)
        {
            System.out.print(queue1.dequeue() + " ");   
        }
    }

}