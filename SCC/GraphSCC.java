import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.Graph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

//http://algs4.cs.princeton.edu/42digraph/Digraph.java.html
//https://sites.google.com/site/indy256/algo/scc_tarjan
//http://algs4.cs.princeton.edu/42digraph/TarjanSCC.java.html
//https://en.wikipedia.org/wiki/Kosaraju%27s_algorithm
//https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm
//https://sites.google.com/site/indy256/algo/strongly_connected_components
//https://sites.google.com/site/indy256/algo/scc_tarjan
public class GraphSCC
{
    
    private static int t = -1;

    private static void DFS(Digraph G, int v, boolean [] arr, int [] order)
    {
        //nothing there
        //label v as discovered
        //for all edges from v to w in G.adjacentEdges(v) do 
        // if w is not labeled as discovered then DFS(G, w)
        arr[v] = true;

        Iterator vertexs = G.adj(v).iterator();

        while (vertexs.hasNext())
        {
            //System.out.println(vertexs.next());

            int v0 = (Integer) vertexs.next();

            if (!arr[v0])
                DFS(G, v0, arr, order);
        }
        
        t++;
        
        order[t] = v;

    }

    private static int DFS_norecursion(Digraph G, int v, boolean [] arr)
    {
        Stack vStack = new Stack<Integer>();
        
        int count = 0;

        vStack.push(v);
        //count++;

        while (!vStack.isEmpty())
        {
            v = (Integer) vStack.pop();
            if (arr[v] == false)
            {
                arr[v] = true;

                count++;

                Iterator vertexs = G.adj(v).iterator();

                while (vertexs.hasNext())
                {
                    //System.out.println(vertexs.next());

                    int v0 = (Integer) vertexs.next();

                    //if (!arr[v0])
                    vStack.push(v0);
                    //count++;
                }
            }
        }

        //count++;

        return count;
    }


	public static void main(String[] args) 
	{
		//it's easy to construct a digraph using the standard library
		//
        final int M = 5;
        String filename = args[0];

        In in1 = new In(filename);

        int nVertex = Integer.parseInt(args[1]);

        int nEdge  = Integer.parseInt(args[2]);

        Digraph graph = new Digraph(nVertex);
        Digraph rgraph = new Digraph(nVertex);
        boolean [] bGraph = new boolean[nVertex];
        boolean [] brGraph = new boolean[nVertex] ;
        MinPQ<Integer> pq = new MinPQ<Integer>();

        int [] nOrder = new int[nVertex];
        
        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            bGraph[nIndex] = false;
            brGraph[nIndex] = false;
            //initial it to some unhappen value in reality
            nOrder[nIndex] = -1;
        }
        
        
        for (int nIndex = 0; nIndex < nEdge; nIndex++)
        {
            int v = in1.readInt() - 1;
            int w = in1.readInt() - 1;
            
            graph.addEdge(v, w);
            rgraph.addEdge(w, v);
        }

        //System.out.println(graph);


        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            if (brGraph[nIndex] == false)
                DFS(rgraph, nIndex, brGraph, nOrder);
            //seeme this work
        }

        

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            int nTemp = nOrder[nVertex - 1 - nIndex];
            int count = 0;
            if (!bGraph[nTemp])
            {
                count = DFS_norecursion(graph, nTemp, bGraph);
                pq.insert(count);
                if (pq.size() > M)
                    pq.delMin();
            }
        }

        Iterator number = pq.iterator();
        //number = 
        //System.out.println(number);
        while (number.hasNext())
        {
            System.out.print(number.next() + " ");
        }

	}
}
