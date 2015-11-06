import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
// import edu.princeton.cs.algs4.Edge;
// import edu.princeton.cs.algs4.EdgeWeightedGraph;
import java.util.Iterator;

public class prim
{
     
    public static long Prims(EdgeWeightedGraph graph, boolean [] arr, int source, MinPQ<Edge> mPQ, Queue<Edge> queue)
    {
        //iterable to get all the relevant nodes and edges
        long treeWeight = 0;

        Iterator itemp = graph.adj(source).iterator();
        //element is an edge, get all the node 
        while (itemp.hasNext())
        {
            mPQ.insert((Edge) itemp.next()); 
        }   

        arr[source] = true;

        while (!mPQ.isEmpty())
        {
            Edge eTemp = mPQ.delMin();

            int v = eTemp.either();
            int w = eTemp.other(v);

            if (arr[v] == false || arr[w] == false)
            {
                treeWeight += (int) eTemp.weight();
                queue.enqueue(eTemp);

            }
            //either and other are the vertexes
            

            if (arr[v] == false)
            {
                Iterator itemp1 = graph.adj(v).iterator();
                //element is an edge, get all the node 
                while (itemp1.hasNext())
                {
                    mPQ.insert((Edge) itemp1.next()); 
                }

                arr[v] = true;
            }

            if (arr[w] == false)
            {
                Iterator itemp1 = graph.adj(w).iterator();
                //element is an edge, get all the node 
                while (itemp1.hasNext())
                {
                    mPQ.insert((Edge) itemp1.next()); 
                }

                arr[w] = true;
            }


        }

        return treeWeight;
    }

    public static void main(String[] args) 
    {
        String filename = args[0];
        In in = new In(filename);

        int nVertex = in.readInt();
        int nEdge = in.readInt();
        EdgeWeightedGraph graph = new EdgeWeightedGraph(nVertex);
        boolean [] bgraph = new boolean[nVertex];

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            bgraph[nIndex] = false;
        }


        for (int nIndex = 0; nIndex < nEdge; nIndex++) 
        {
            //the vertex is from 0 to V - 1 not 1 to V in the file
            int v = in.readInt() - 1;
            int w = in.readInt() - 1;
            int weight = in.readInt();
            Edge e = new Edge(v, w, weight);
            graph.addEdge(e);
        }

        // set the queue for future usage
        MinPQ<Edge> pq = new MinPQ<Edge>();
        Queue<Edge> eQueue = new Queue<Edge>();

        Stopwatch timeslot = new Stopwatch();

        
        long totalWeight = Prims(graph, bgraph, 0, pq, eQueue);
        double eclips = timeslot.elapsedTime();

        System.out.println("Time for the library algorithm is " + eclips);
        System.out.println("The total tree weight is " + totalWeight);
        System.out.println("The tree size is " + eQueue.size());
        

    }
}