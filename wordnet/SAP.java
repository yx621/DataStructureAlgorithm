import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

public class SAP 
{
   private Digraph graph;
   private int nVertices;
   private int commonAncestor;
   // constructor takes a digraph (not necessarily a DAG)
   public SAP(Digraph G)
   {
      graph = new Digraph(G);
      nVertices = G.V();
      commonAncestor = -1;
   }

   private int calLength(Queue<Integer> queue1, Queue<Integer> queue2, int [] weight1, int [] weight2, boolean [] bVisited1, boolean [] bVisited2)
   {
      int nDist = Integer.MAX_VALUE/2;

      while(!queue1.isEmpty())
      {
         int currentNode = queue1.dequeue();
         for (int node : graph.adj(currentNode))
         {
            if (!bVisited1[node])
            {
               weight1[node] = weight1[currentNode] + 1;
               bVisited1[node] = true;
               queue1.enqueue(node);
            }

            if (bVisited2[node] == true)
            {
               if (nDist > weight1[node] + weight2[node])
               {
                  commonAncestor = node;
                  nDist = weight1[node] + weight2[node];
               }
            }
         }
      }

      while(!queue2.isEmpty())
      {
         int currentNode = queue2.dequeue();

         for (int node : graph.adj(currentNode))
         {
            if (!bVisited2[node])
            {
               bVisited2[node] = true;
               weight2[node] = weight2[currentNode] + 1;
               queue2.enqueue(node);
            }

            if (bVisited1[node])
            {
               if (nDist > weight2[node] + weight1[node])
               {
                  commonAncestor = node;
                  nDist = weight2[node] + weight1[node];
               }
            }
         }
      }

      return nDist;

   }

   // length of shortest ancestral path between v and w; -1 if no such path
   public int length(int v, int w)
   {
      if (v >= nVertices || v < 0 || w < 0 || w >= nVertices)
         throw new java.lang.IndexOutOfBoundsException("Inputs to legnth function out of bound");
      Queue<Integer> nQueue1 = new Queue<Integer>();
      Queue<Integer> nQueue2 = new Queue<Integer>();
      
      // need to detect the direct path between v and w first...

      int [] weight1 = new int[nVertices];
      int [] weight2 = new int[nVertices];
      boolean [] bVisited1 = new boolean[nVertices];
      boolean [] bVisited2 = new boolean[nVertices];

      for (int nIndex = 0; nIndex < nVertices; nIndex++)
      {
         weight2[nIndex] = Integer.MAX_VALUE/2;
         weight1[nIndex] = Integer.MAX_VALUE/2;
         bVisited1[nIndex] = false;
         bVisited2[nIndex] = false;
      }
      
      nQueue1.enqueue(v);
      bVisited1[v] = true;
      weight1[v] = 0;

      nQueue2.enqueue(w);
      bVisited2[w] = true;
      weight2[w] = 0;

      if (v == w)
      {
         commonAncestor = v;
         return 0;
      }

      int nDistance = calLength(nQueue1, nQueue2, weight1, weight2, bVisited1, bVisited2);

      if (nDistance >= Integer.MAX_VALUE/2)
         return -1;

      return nDistance;
   }

   public int ancestor(int v, int w)
   {
      if (v >= nVertices || v < 0 || w < 0 || w >= nVertices)
         throw new java.lang.IndexOutOfBoundsException("Inputs to ancestor function out of bound");
      if (length(v, w) == -1)
         return -1;
      return commonAncestor;
   }

   // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
   public int length(Iterable<Integer> v, Iterable<Integer> w)
   {  

      if (v == null || w == null)
         throw new java.lang.NullPointerException("Null pointer in iterable length function");
      Queue<Integer> nQueue1 = new Queue<Integer>();
      Queue<Integer> nQueue2 = new Queue<Integer>();
      int [] weight1 = new int[nVertices];
      int [] weight2 = new int[nVertices];
      boolean [] bVisited1 = new boolean[nVertices];
      boolean [] bVisited2 = new boolean[nVertices];
      int vAncestor = -1;
      int wAncestor = -1;
      for (int nIndex = 0; nIndex < nVertices; nIndex++)
      {
         weight2[nIndex] = Integer.MAX_VALUE/2;
         weight1[nIndex] = Integer.MAX_VALUE/2;
         bVisited1[nIndex] = false;
         bVisited2[nIndex] = false;
      }

      for (int node : v)
      {
         if (node >= nVertices || node < 0)
            throw new java.lang.IndexOutOfBoundsException("Inputs to iterable length function out of bound");
         weight1[node] = 0;
         nQueue1.enqueue(node);
         bVisited1[node] = true;
      }

      for (int node : w)
      {
         if (node >= nVertices || node < 0)
            throw new java.lang.IndexOutOfBoundsException("Inputs to iterable length function out of bound");
         weight2[node] = 0;
         nQueue2.enqueue(node);
         bVisited2[node] = true;
         if (bVisited1[node])
         {
            commonAncestor = node;
            return 0;
         }
      }

      int nDistance = calLength(nQueue1, nQueue2, weight1, weight2, bVisited1, bVisited2);

      if (nDistance >= Integer.MAX_VALUE/2)
         return -1;

      return nDistance;
   }

   // a common ancestor that participates in shortest ancestral path; -1 if no such path
   public int ancestor(Iterable<Integer> v, Iterable<Integer> w)
   {
      if (v == null || w == null)
         throw new java.lang.NullPointerException("Null pointer in iterable ancestor");
      if (length(v, w) == -1)
         return -1;

      return commonAncestor;
      
   }

   // do unit testing of this class
   public static void main(String[] args)
   {
      
      // In in = new In(args[0]);
      // int nVertices = in.readInt();

      // Digraph G = new Digraph(nVertices);

      // int nEdges = in.readInt();

      // for (int nIndex = 0; nIndex < nEdges; nIndex++) 
      // {
      //    int v = in.readInt();
      //    int w = in.readInt();
      //    G.addEdge(v, w); 
      // }
      
      // SAP sap = new SAP(G);
      // while (!StdIn.isEmpty()) 
      // {
      //    int v = StdIn.readInt();
      //    int w = StdIn.readInt();
      //    int length   = sap.length(v, w);
      //    int ancestor = sap.ancestor(v, w);
      //    StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
      // }
      
      
   }
}