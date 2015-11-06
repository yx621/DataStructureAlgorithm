import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class graphCluster
{
    public static void main(String[] args) 
    {
        String filename = args[0];

        int k = Integer.parseInt(args[1]);
        //number of clustering
        In in = new In(filename);

        int nVertex = in.readInt();
        int nEdge   = in.readInt();
        
        boolean [] barr = new boolean[nVertex];

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            barr[nIndex] = false;
        }

        MinPQ pq = new MinPQ<Edge>();

        UnionFound uf = new UnionFound(nVertex);

        for (int nIndex = 0; nIndex < nEdge; nIndex++)
        {
            int begin = in.readInt() - 1;
            int end = in.readInt() - 1;
            int weight = in.readInt();

            Edge eTemp = new Edge(begin, end, weight);
            pq.insert(eTemp);
        }

        //System.out.println()
        int distance = 0;

        //all the edges are in the priority queue Nlog(N) time complexity and N size
        while(uf.count() > k && pq.isEmpty() == false)
        {
            Edge eTemp = (Edge) pq.delMin();

            int nBegin = eTemp.begin();
            int nEnd = eTemp.end();
            distance = eTemp.weight();

            uf.union(nBegin, nEnd);

        }

        while (pq.isEmpty() == false)
        {
            Edge eTemp = (Edge) pq.delMin();
            
            int nBegin = eTemp.begin();
            int nEnd = eTemp.end();
            distance = eTemp.weight();

            if (!uf.connected(nBegin, nEnd))
                break;
        }
        

        System.out.println("The distance is " + distance);

    
    }
}