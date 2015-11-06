import java.util.LinkedList;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Stopwatch;
public class hash1
{
    public static void main(String[] args) 
    {
        long N0 = 10000;

        String filename = args[0];
        In in1 = new In(filename);
        LinkedList inputdata = new LinkedList<Long>();

        long [] array = new long[1000000];

        SeparateChainingHashST hashdata = new SeparateChainingHashST<Long, Long>(2000083);
        LinearProbingHashST    hashdata2 = new LinearProbingHashST<Long, Long>(3000000);
        //i want the list around 10
        int iii = 0;
        while (in1.hasNextLine())
        {
            //data format is 1 2,30 ...
            // change the , to space and drop the first one
            long Ntemp = in1.readLong();
            array[iii++] = Ntemp;
            inputdata.add(Ntemp);
            hashdata.put(Ntemp, Ntemp);
            hashdata2.put(Ntemp, Ntemp);

        }

        int Nsize = inputdata.size();
        int Nsize2 = array.length;
        System.out.println("\ninput data size is: " + Nsize);
        System.out.println("\ninput array size is: " + Nsize2);
        System.out.println("chain hash size: " + hashdata.size());
        System.out.println("array hash size: " + hashdata2.size() + "\n");

        int sum = 0;

        
        for (int nIndex = 0; nIndex < Nsize2; nIndex++)
        {
            // if (nIndex < 10)
            // {
            //     System.out.println(hashdata.get(array[nIndex]));
            //     System.out.println(hashdata.contains(array[nIndex]));
            // }

            hashdata.contains(array[nIndex]);
        }

        Stopwatch watch = new Stopwatch();
        for (long nIndex = -N0; nIndex <= N0; nIndex++)
        {
    
            if (nIndex%1000 == 0)
                System.out.println("currently the sum is " + sum + " the loop number is " + nIndex);

            for (int mIndex = 0; mIndex < Nsize; mIndex++)
            {
                
                if (hashdata.contains(nIndex - array[mIndex]))
                //key and value are different
                //if (hashdata.get((nIndex - array[mIndex])) == nIndex - array[mIndex])
                {
                    sum++;
                    break;
                }

            }
        }

        System.out.println("elapse time is " + watch.elapsedTime());
        System.out.println("sum number is = " + sum);



    }
}