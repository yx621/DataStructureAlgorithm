public class HammingClustering
{
    public static void main(String[] args) 
    {
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(filename);
        int nVertex = in.readInt();
        int nlength = in.readInt();

        System.out.println(nVertex + " " + nlength);

        int [] code = new int[nVertex];

        UnionFound uf = new UnionFound(nVertex);

        Stopwatch watch1 = new Stopwatch();

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            int sum = 0;

            for (int mIndex = 0; mIndex < nlength; mIndex++)
            {
                sum = 2*sum + in.readInt();
            }

            code[nIndex] = sum;
        }

        double time1 = watch1.elapsedTime();

        System.out.println("The read time is " + time1);

        // for (int nIndex = 0; nIndex < nVertex; nIndex++)
        // {
        //     System.out.println(code[nIndex]);
        // }
        Stopwatch watch2 = new Stopwatch();

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            for (int mIndex = nIndex + 1; mIndex < nVertex; mIndex++)
            {
                int distance = Integer.bitCount(code[nIndex]^code[mIndex]);
                if (distance < k)
                {
                    uf.union(nIndex, mIndex);
                }
            }
        }

        // for (int nIndex = 0; nIndex < nVertex; nIndex++)
        // {
        //     for (int mIndex = nIndex + 1; mIndex < nVertex; mIndex++)
        //     {   
        //         if(!uf.connected(nIndex, mIndex))
        //         {
        //             int distance = Integer.bitCount(code[nIndex]^code[mIndex]);
        //             if (distance < k)
        //             {
        //                 uf.union(nIndex, mIndex);
        //             }    
        //         }
                
        //     }
        // }

        double time2 = watch2.elapsedTime();
        System.out.println("The algorithm time is " + time2);
        System.out.println("The largest clustering for spacing " + k + " is at least " + uf.count());
    }
}