import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DijkstraSP;
 
import java.util.Iterator;
 
public class SourceDij
{
    /*
    * references
    * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
    * http://algs4.cs.princeton.edu/24pq/MinPQ.java.html
    * -- a useful one http://algs4.cs.princeton.edu/43mst/EdgeWeightedGraph.java.html
    * http://algs4.cs.princeton.edu/42digraph/
    * http://algs4.cs.princeton.edu/44sp/DijkstraSP.java.html
    * http://algs4.cs.princeton.edu/40graphs/
    * https://class.coursera.org/algo-008/forum/thread?thread_id=415
    * https://class.coursera.org/algo-008/forum/thread?thread_id=481
    * https://class.coursera.org/algo-008/forum/list?forum_id=21
    */
 
    // the element in the heap is just a number, so that we can insert one vertex/node to the PQ more than once
    public static class Vertex implements Comparable<Vertex>
    {
        private int nNumber;
        private int nWeight2Source;
 
        public Vertex(int nNode)
        {
            nNumber = nNode;
            nWeight2Source = Integer.MAX_VALUE;
            //nWeight2Source = 1000000;
        }
 
        public Vertex(int nNode, int nWeight)
        {
            nNumber = nNode;
            nWeight2Source = nWeight;
        }
 
        public void setWeight(int nWeight)
        {
            nWeight2Source = nWeight;
        }
 
        public int getWeight()
        {
            return nWeight2Source;
        }
 
        public int getVertex()
        {
            return nNumber;
        }
 
        public int compareTo(Vertex that)
        {
 
            //return this.nWeight2Source - that.nWeight2Source;
            if (this.getWeight() > that.getWeight())
                return 1;
            if (this.getWeight() < that.getWeight())
                return -1;
            return 0;
            //need to insert this element to PQ
        }
 
        public String toString()
        {
            return nNumber + ", " + nWeight2Source;
        }
 
    }
 
    public static void Dijkstra(EdgeWeightedDigraph graph, boolean [] arr, Vertex [] vArr, int source, MinPQ<Vertex> mPQ, int [] nPrevious)
    {
        //iterable to get all the relevant nodes and edges
        vArr[source].setWeight(0);
        nPrevious[source] = source;
 
        mPQ.insert(vArr[source]);
 
        while (!mPQ.isEmpty())
        {
             
            Vertex vTemp = mPQ.delMin();
             
            int nTemp = vTemp.getVertex();
 
            if (arr[nTemp] == false)
            {
                arr[nTemp] = true;
                 
                Iterator itemp = graph.adj(nTemp).iterator();
                //element is an edge, get all the node 
                while (itemp.hasNext())
                {
                    //Edge eTemp = (Edge) itemp.next();
                    DirectedEdge eTemp = (DirectedEdge) itemp.next();
                     
                    int node = eTemp.to();
                    if (arr[node] == false)
                    {
                        int weight = (int) eTemp.weight() + vArr[nTemp].getWeight();
                        //new distance = neighbor distance + node
                        if (weight < vArr[node].getWeight())
                        {
                            Vertex vTemp0 = new Vertex(node, weight);
                            vArr[node].setWeight(weight);
                            nPrevious[node] = nTemp;
                            //mPQ.insert(vArr[node]);
                            mPQ.insert(vTemp0);
                        }
                    }
                }   
            }
        }
         
    }
 
    public static void main(String[] args) 
    {
        String filename = args[0];
 
        In in1 = new In(filename);
         
        int nVertex = Integer.parseInt(args[1]);
        //define the number of vertexs
         
        //EdgeWeightedGraph graph = new EdgeWeightedGraph(nVertex);
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(nVertex);
        boolean [] bgraph = new boolean[nVertex];
 
        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            bgraph[nIndex] = false;
        }
 
 
 
        // set the queue for future usage
        MinPQ<Vertex> pq = new MinPQ<Vertex>();
        // set the array to keep the path information
        int [] previous = new int[nVertex];
 
        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            previous[nIndex] = -1;
            //initialze to -1 to indicate there is not relevant path
        }
 
 
        int jIndex = 0;
        Vertex [] cVertex = new Vertex[nVertex];
 
        while (in1.hasNextLine())
        {
            //data format is 1 2,30 ...
            // change the , to space and drop the first one
            String [] integersInString = in1.readLine().split(" ");
 
            int [] a = new int[integersInString.length];
 
            a[0] = Integer.parseInt(integersInString[0]) - 1;
            //establish all the vertex node
            cVertex[jIndex] = new Vertex(a[0]);
 
            for (int nIndex = 1; nIndex < integersInString.length; nIndex += 2)
            {
                a[nIndex] = Integer.parseInt(integersInString[nIndex]) - 1;
                a[nIndex + 1] = Integer.parseInt(integersInString[nIndex + 1]);
 
                //DirectedEdge
                //Edge e = new Edge(a[0], a[nIndex], (double) a[nIndex + 1]);
                DirectedEdge e = new DirectedEdge(a[0], a[nIndex], (double) a[nIndex + 1]);
                graph.addEdge(e);
            }
 
            if (in1.hasNextLine())
                jIndex++;
        }
 
        Stopwatch timeslot = new Stopwatch();
         
        Dijkstra(graph, bgraph, cVertex, 0, pq, previous);
         
        double eclips = timeslot.elapsedTime();
        System.out.println("Time for Yongxin's algorithm is " + eclips);
 
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("*****************");
         
        System.out.println(cVertex[6].getWeight());
        System.out.println(cVertex[36].getWeight());
        System.out.println(cVertex[58].getWeight());
        System.out.println(cVertex[81].getWeight());
        System.out.println(cVertex[98].getWeight());
        System.out.println(cVertex[114].getWeight());
        System.out.println(cVertex[132].getWeight());
        System.out.println(cVertex[164].getWeight());
        System.out.println(cVertex[187].getWeight());
        System.out.println(cVertex[196].getWeight());
 
    }
}