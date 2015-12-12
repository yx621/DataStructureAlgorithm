import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;

public class greedy
{
    
    public static void main(String[] args) 
    {
        String filename = args[0];
        In in = new In(filename);
                
        int N = in.readInt();
        
        weightlength [] WL = new weightlength[N];
        
        //construct the array with relevant elements
        for (int nIndex = 0; nIndex < N; nIndex++) 
        {
            int x = in.readInt();
            int y = in.readInt();
            WL[nIndex] = new weightlength(x, y);
        }
        

        // for (int nIndex = 0; nIndex < N; nIndex++)
        // {
        //     System.out.println(WL[nIndex]);
        // }
        
        // System.out.println("****************");
        // System.out.println("****************");
        // System.out.println("****************");
        // System.out.println("****************");
        // System.out.println("****************");

        //sort the array, merge sort? quick sort?
        Arrays.sort(WL);

        // for (int nIndex = 0; nIndex < N; nIndex++)
        // {
        //     System.out.println(WL[nIndex]);
        // }
        
        long sum = 0;
        long totlelength = 0;

        for (int nIndex = 0; nIndex < N; nIndex++)
        {
            totlelength += WL[nIndex].getLength();
            sum += WL[nIndex].getWeight()*totlelength;
        }

        System.out.println("The required output is " + sum);



    }
}