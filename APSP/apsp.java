import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import java.util.Iterator;

public class apsp
{   

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

        public Vertex(Vertex that)
        {
            this.nNumber = that.getVertex();
            this.nWeight2Source = that.getWeight();
            //copy the vertex to the current one
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

    public static void Dijkstra(EdgeWeightedDigraph graph, Vertex [] vArr, int source)
    {
        int nVertex = graph.V();
        boolean [] arr = new boolean[nVertex];
        MinPQ<Vertex> mPQ = new MinPQ<Vertex>();
        
        //Vertex [] vArr = new Vertex[nVertex];

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            arr[nIndex] = false;
            vArr[nIndex] = new Vertex(nIndex);
        }

        vArr[source].setWeight(0);
        
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
                            //nPrevious[node] = nTemp;
                            //mPQ.insert(vArr[node]);
                            mPQ.insert(vTemp0);
                            //we can reconstruct the array for the previous node here... 
                        }
                    }
                }   
            }
        }
    }
    
    public static boolean BellmanFord(EdgeWeightedDigraph graph, int [][]A, int source)
    {
        int nVertex = graph.V();
        
        Queue<DirectedEdge> ePQ = new Queue<DirectedEdge>();

        A[0][source] = 0;
        A[1][source] = 0;
        Vertex [] B = new Vertex[nVertex];


        Iterator itemp = graph.adj(source).iterator();
        
        while (itemp.hasNext())
        {
            //Edge eTemp = (Edge) itemp.next();
            DirectedEdge eTemp = (DirectedEdge) itemp.next();
            
            ePQ.enqueue(eTemp);
            //queue includes the elements from the first iteration
        }

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            if (nIndex != source)
            {
                A[0][nIndex] = Integer.MAX_VALUE;
                A[1][nIndex] = Integer.MAX_VALUE;
            }
        }

        for(int nIndex = 0; nIndex <= nVertex; nIndex++)
        {
            //need to breadth first search the edges (graph)
            for (int mIndex = 0; mIndex < nVertex; mIndex++)
            {
                A[0][mIndex] = A[1][mIndex];
            }

            int nQueue = ePQ.size();

            // if (nQueue > 60000)
            // {
            //     System.out.println("Strange result happened to the enqueue process " + nQueue);
            // }

            for (int mIndex = 0; mIndex < nQueue && ePQ.isEmpty() == false; mIndex++)
            {
                DirectedEdge eTemp = ePQ.dequeue();

                int v = eTemp.from();
                int w = eTemp.to();

                //find the 2 vertexs
                if (A[1][w] > A[0][v] + (int) eTemp.weight())
                {
                    A[1][w] = A[0][v] + (int) eTemp.weight();
                    //here A stand for the length from source to w

                    itemp = graph.adj(w).iterator();
                    
                    B[w] = new Vertex(v, A[1][w]);
                    //find the previous node and set the weight to the target
                    while (itemp.hasNext())
                    {
                        //Edge eTemp = (Edge) itemp.next();
                        DirectedEdge eTemp2 = (DirectedEdge) itemp.next();
                        
                        ePQ.enqueue(eTemp2);
                        //only enqueue the components that change the results
                        //queue includes the elements from the first iteration

                    }
                }
            }
        }

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            if (A[0][nIndex] != A[1][nIndex])
            {
                return true;
            }
        }

        return false;

    }

    public static void Johnson(EdgeWeightedDigraph graph)
    {
        int nVertex = graph.V(); 
        EdgeWeightedDigraph secondGraph = new EdgeWeightedDigraph(nVertex + 1);

        for (int v = 0; v < nVertex; v++) 
        {
            // reverse so that adjacency list is in same order as original
            Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();
            for (DirectedEdge e : graph.adj(v)) 
            {
                reverse.push(e);
            }

            for (DirectedEdge e : reverse) 
            {
                secondGraph.addEdge(e);
            }
        }

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            DirectedEdge eTemp = new DirectedEdge(nVertex, nIndex, 0);
            secondGraph.addEdge(eTemp);
        }

        int [][] ans = new int[2][nVertex + 1];

        boolean flag = BellmanFord(secondGraph, ans, nVertex);

        if (flag == true)
        {
            System.out.println("negative cycled loop in the graph ");
            return;
        }

        EdgeWeightedDigraph workgraph = new EdgeWeightedDigraph(nVertex);

        for (int nIndex = 0; nIndex < nVertex; nIndex++) 
        {
            // reverse so that adjacency list is in same order as original
            Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();
            for (DirectedEdge e : graph.adj(nIndex)) 
            {
                reverse.push(e);
            }

            for (DirectedEdge e : reverse) 
            {
                int v = e.from();
                int w = e.to();

                int weight0 = (int) e.weight() + ans[1][v] - ans[1][w];

                workgraph.addEdge(new DirectedEdge(v, w, weight0));
            }
        }

        //has constructed the graph

        Vertex [] vArr = new Vertex[nVertex];

        int min = Integer.MAX_VALUE;

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            for (int mIndex = 0; mIndex < nVertex; mIndex++)
            {
                vArr[mIndex] = new Vertex(mIndex);    
            }

            Dijkstra(workgraph, vArr, nIndex);

            for(int mIndex = 0; mIndex < nVertex; mIndex++)
            {
                if (min > vArr[mIndex].getWeight() - ans[1][nIndex] + ans[1][mIndex])
                    min = vArr[mIndex].getWeight() - ans[1][nIndex] + ans[1][mIndex];
            }

        }

        System.out.println("The JohnSon algorithm gives result " + min);


    }

    public static void main(String[] args) 
    {
        String filename = args[0];

        In in1 = new In(filename);
        
        int nVertex = in1.readInt();
        int nEdge = in1.readInt();
        //define the number of vertexs
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(nVertex);
        Vertex [] vArr = new Vertex[nVertex];

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            vArr[nIndex] = new Vertex(nIndex);
        }

        for (int nIndex = 0; nIndex < nEdge; nIndex++)
        {
            int v = in1.readInt() - 1;
            int w = in1.readInt() - 1;
            int weight = in1.readInt();
            graph.addEdge(new DirectedEdge(v, w, weight));
        }

        
        Stopwatch watch1 = new Stopwatch();
        Dijkstra(graph, vArr, 0);
        double eclips = watch1.elapsedTime();

        System.out.println("Time for Yongxin's Dijkstra algorithm is " + eclips);

        // int [][] ans = new int[2][nVertex];

        // Stopwatch watch2 = new Stopwatch();
        // int min = 0;
        // for (int nIndex = 0; nIndex < nVertex; nIndex++)
        // {
        //     boolean flag = BellmanFord(graph, ans, nIndex);

        //     if (flag == true)
        //     {
        //         System.out.println("There is negative weight cycle");
        //         return;
        //     }

        //     // min = ans[1][0];
        //     for (int mIndex = 1; mIndex < nVertex; mIndex++)
        //     {
        //         if (ans[1][mIndex] < min)
        //             min = ans[1][mIndex];
        //     }
        // }

        // eclips = watch2.elapsedTime();

        // System.out.println("1000 BF algorithm takes time " + eclips);
        // System.out.println("The minimum source to destination weight is " + min);
        
        Stopwatch watch3 = new Stopwatch();
        Johnson(graph);
        eclips = watch3.elapsedTime();
        System.out.println("Johnson algorithm takes time " + eclips);

    }   
}