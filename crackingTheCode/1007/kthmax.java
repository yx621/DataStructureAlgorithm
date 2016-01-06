import edu.princeton.cs.algs4.Queue;
import java.util.ArrayList;

public class kthmax
{
    public static int getk(int nNumber)
    {
        if (nNumber == 1)
            return 1;

        if (nNumber <= 0)
        {
            System.out.println("Illegal input data " + nNumber);
            return -1;
        }

        Queue<Integer> Q3 = new Queue<Integer>();
        Queue<Integer> Q5 = new Queue<Integer>();
        Queue<Integer> Q7 = new Queue<Integer>();

        Q3.enqueue(3);
        Q5.enqueue(5);
        Q7.enqueue(7);
        // actually I think one queue can solve this problem
        nNumber--;
        int val = 1;
        for(; nNumber > 0; nNumber--)
        {
            while (Q3.peek() <= val)
            {
                Q3.dequeue();
            }

            while (Q5.peek() <= val)
            {
                Q5.dequeue();
            }

            while (Q7.peek() <= val)
            {
                Q7.dequeue();
            }

            val = Math.min(Q3.peek(), Math.min(Q5.peek(), Q7.peek()));

            if (val == Q3.peek())
            {
                Q3.dequeue();
            }

            else if (val == Q5.peek())
            {
                Q5.dequeue();
            }

            else if (val == Q7.peek())
            {
                Q7.dequeue();
            }

            Q3.enqueue(3*val);
            Q5.enqueue(5*val);
            Q7.enqueue(7*val);
        }

        return val;


    }
    public static void main(String[] args) 
    {
        int nNumber = Integer.parseInt(args[0]);
        // System.out.println(getk(nNumber));

        for (int nIndex = 0; nIndex < nNumber; nIndex++)
        {
            System.out.println(getk(nIndex+1));            
        }
    }
}