import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Graph;
import java.util.ArrayList;
import java.util.Random;


public class GraphCut
{
    private static final int N = 200;
    /*
    * vertices -- array/list space O(n)
    * edges -- array/list space O(m)
    * each edge points to it's end point (vertex?) -- what is the interaction between edge and vertex (the 2 lists) space O(m)
    * each vertix points to edge incident (initial) space O(m)
    */

    /*
    * how to set the edges based on points
    */
    public class vertex
    {
        private ArrayList IndexArray = new ArrayList<Integer>();
    }

    public static class edge
    {
        private int begin;
        private int end;

        public edge(int nBegin, int nEnd)
        {
            begin = nBegin;
            end = nEnd;
        }

        public String toString()
        {
            return begin + ", " + end;
        }

        public int getBegin()
        {
            if (begin < end)
                return begin;

            return end;
        }

        public int getEnd()
        {
            if (begin > end)
                return begin;
            
            return end;   
        }
    }


    public static int root(int arr[], int nIndex)
    {
        while (nIndex != arr[nIndex]) nIndex = arr[nIndex];
        return nIndex;
    }

    public static void main(String[] args) 
    {

        String filename = args[0];

        In in1 = new In(filename);
        
        ArrayList [] array = new ArrayList[N];
        
        ArrayList edges = new ArrayList<edge>();
        
        for (int nIndex = 0; nIndex < N; nIndex++)
        {
            array[nIndex] = new ArrayList<Integer>();
        }

        
        int jIndex = 0;
        while (in1.hasNextLine()) 
        {
            String[] integersInString = in1.readLine().split(" ");
            
            int [] a = new int[integersInString.length];
            
            for (int i = 0; i < integersInString.length; i++) 
            {
                a[i] = Integer.parseInt(integersInString[i]) - 1;

                array[jIndex].add(a[i]);
            }
            jIndex++;
        }

        int [] arrayIndex = new int[N];

        for (int nIndex = 0; nIndex < N; nIndex++)
        {
            //arrayIndex[nIndex] = (Integer) array[nIndex].get(0) - 1;
            arrayIndex[nIndex] = (Integer) array[nIndex].get(0);
        }


        //System.out.println(array[0]);
        //System.out.println(array[1]);
        //System.out.println(array[0].size());
        //System.out.println(array[0].get(3));

        /*
        for (int nIndex = 0; nIndex < N; nIndex++)
        {
            System.out.print(arrayIndex[nIndex] + " ");

            if ((nIndex + 1) % 10 == 0)
                System.out.print("\n");                
        }

        */

        
        for (int nIndex = 0; nIndex < array.length; nIndex++)
        {
            for (int mIndex = 1; mIndex < array[nIndex].size(); mIndex++)
            {
                int nBegin = (Integer) array[nIndex].get(0);
                int nEnd   = (Integer) array[nIndex].get(mIndex);

                if (nBegin < nEnd)
                {
                    edge eTemp = new edge(nBegin, nEnd);  
                    edges.add(eTemp);
                }
                //edge eTemp = new edge((Integer) array[nIndex].get(0), (Integer) array[nIndex].get(mIndex));
                
            }
        }

        //System.out.println(edges.get(1) + "\n");

        Random rnd = new Random();

        for (int nIndex = 0; nIndex < N - 2; )
        {
            int nRandom = rnd.nextInt(edges.size());

            edge eTemp0 = (edge) edges.remove(nRandom);
            //edge eTemp0 = edges.remove(nRandom);

            int nBegin = eTemp0.getBegin();
            int nEnd = eTemp0.getEnd();
            nBegin = root(arrayIndex, nBegin);
            nEnd = root(arrayIndex, nEnd);


            if (nBegin == nEnd)
                continue;

            
            else
            {
                if (nBegin > nEnd)
                {
                    int nTemp = nBegin;
                    nBegin = nEnd;
                    nEnd = nTemp;
                }   

                //make sure nbegin is less than nend

                arrayIndex[nEnd] = arrayIndex[nBegin];

                array[nEnd].set(0, nBegin);
                //also update the vertex array/List

                nIndex++;

            }
            //play with the index directly


        }
        
        
        /*
        for (int nIndex = 0; nIndex < N; nIndex++)
        {
            //System.out.print(arrayIndex[nIndex] + " ");

            if ((nIndex + 1) % 10 == 0)
                System.out.print("\n");

        }
        */

        int sum = 0;
        //need to check all the remaining edges
        for (int nIndex = 0; nIndex < edges.size(); nIndex++)
        {
            /*
            if (root(arrayIndex, nIndex) != root(arrayIndex, 0))
                sum ++;
            */

            edge eTemp = (edge) edges.get(nIndex);

            int nBegin = eTemp.getBegin();
            int nEnd = eTemp.getEnd();

            if (root(arrayIndex, nBegin) != root(arrayIndex, nEnd))
                sum++;

        }

        System.out.println("\nThe cut number is " + sum);

        //read the data int and establish the vertex and node data structure

        //choose an edge randomly and merge 2 nodes:
        /*
        * if the end (larger) point is not the corresponding element in the vertex, continue (the edge has been used)
        * delete the node in the edge list
        * change the element in the vertex array
            -- for the larger element, delete it in the smaller element list
        */
    }
}