import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import java.util.HashMap;

public class WordNet 
{
   private Digraph wordGraph;
   private HashMap<String, Bag<Integer>> wordIDs;
   private HashMap<Integer, String> idWords;
   private int nAncestor;
   
   public WordNet(String synsets, String hypernyms)
   {
      if (synsets == null || hypernyms == null)
      {
         throw new java.lang.NullPointerException("The constructor has null input string");
      }
      nAncestor = -1;
      In in1 = new In(synsets);
      In in2 = new In(hypernyms);
      wordIDs = new HashMap<String, Bag<Integer>>();
      idWords = new HashMap<Integer, String>();
      while (in1.hasNextLine())
      {
         String sTemp = in1.readLine();

         String [] saTemp = sTemp.split(",");
         // 2 hash maps -- one for <String and IDs
         // one for <IDs and string>
         int nID = Integer.parseInt(saTemp[0]);

         String [] saTemp2 = saTemp[1].split(" ");
         
         for (String str : saTemp2)
         {
            if (wordIDs.containsKey(str))
            {
               wordIDs.get(str).add(nID);
            }

            else
            {
               Bag<Integer> bag = new Bag<Integer>();
               bag.add(nID);
               wordIDs.put(str, bag);
            }
         }
         
         idWords.put(nID, saTemp[1]);

      }

      // System.out.println(wordIDs.keySet());

      int nVertices = idWords.size();

      wordGraph = new Digraph(nVertices);
      // construct the digraph

      while (in2.hasNextLine())
      {
         String sTemp = in2.readLine();
         String [] saTemp = sTemp.split(",");
         int nLength = saTemp.length;
         int [] naTemp = new int[nLength];

         for (int nIndex = 0; nIndex < nLength; nIndex++)
         {
            naTemp[nIndex] = Integer.parseInt(saTemp[nIndex]);
         }

         int nSource = naTemp[0];
         if (nSource >= nVertices || nSource < 0)
         {
            throw new IndexOutOfBoundsException("vertex " + nSource + " is not between 0 and " + nVertices);
         }

         for (int nIndex = 1; nIndex < nLength; nIndex++)
         {
            int nDest = naTemp[nIndex];

            if (nDest >= nVertices || nSource < 0)
            {
               throw new IndexOutOfBoundsException("vertex " + nDest + " is not between 0 and " + nVertices);
            }
            wordGraph.addEdge(nSource, nDest);
         }

      }

      if (hasCycle(wordGraph))
         throw new java.lang.IllegalArgumentException("The graph has cycle");
      if (!isRooted(wordGraph))
         throw new java.lang.IllegalArgumentException("The graph is not rooted");


   }

   private boolean hasCycle(Digraph graph)
   {
      if (graph == null)
         throw new java.lang.NullPointerException("The graph for hasCycle check is null");
      DirectedCycle graphCycle = new DirectedCycle(graph);
      return graphCycle.hasCycle();
   }

   private boolean isRooted(Digraph graph)
   {
      if (graph == null)
         throw new java.lang.NullPointerException("The graph for root check is empty");

      int nVertices = graph.V();
      boolean [] bVisited = new boolean[nVertices];
      for (int nIndex = 0; nIndex < nVertices; nIndex++)
      {
         bVisited[nIndex] = false;
      }
      
      int root = -1;

      Stack<Integer> nStacks = new Stack<Integer>();

      for (int nIndex = 0; nIndex < nVertices; nIndex++)
      {
         if (!bVisited[nIndex])
         {
            nStacks.push(nIndex);
            bVisited[nIndex] = true;

            while (!nStacks.isEmpty())
            {
               int currentNode = nStacks.pop();

               if (!(graph.adj(currentNode).iterator().hasNext()))
               {
                  if (root == -1)
                     root = currentNode;
                  else if (currentNode != root)
                     return false;
               }
               else
               {
                  for (int node : graph.adj(currentNode))
                  {
                     // System.out.println("We have the node " + currentNode + " and its adjacent " + node);
                     if (!bVisited[node])
                     {
                        nStacks.push(node);
                        bVisited[node] = true;
                     }
                  }   
               }
               
            }
         }
      }

      return true;
   }

   // returns all WordNet nouns
   public Iterable<String> nouns()
   {
      return wordIDs.keySet();
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word)
   {
      if (word == null)
      {
         throw new java.lang.NullPointerException("The word is null");
      }

      return wordIDs.containsKey(word);

   }

   private int calLength(Queue<Integer> queue1, Queue<Integer> queue2, int [] weight1, int [] weight2, boolean [] bVisited1, boolean [] bVisited2)
   {
      int nDist = Integer.MAX_VALUE/2;

      while(!queue1.isEmpty())
      {
         int currentNode = queue1.dequeue();
         for (int node : wordGraph.adj(currentNode))
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
                  nAncestor = node;
                  nDist = weight1[node] + weight2[node];
               }
            }
         }
      }

      while(!queue2.isEmpty())
      {
         int currentNode = queue2.dequeue();

         for (int node : wordGraph.adj(currentNode))
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
                  nAncestor = node;
                  nDist = weight2[node] + weight1[node];
               }
            }
         }
      }

      return nDist;

   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB)
   {
      if (!isNoun(nounA) || !isNoun(nounB))
         throw new java.lang.IllegalArgumentException("One of nouns in distance function is not in the synset");

      Bag<Integer> bag1 = wordIDs.get(nounA);

      Bag<Integer> bag2 = wordIDs.get(nounB);

      // System.out.println("bag1 is " + bag1.iterator());
      // System.out.println("bag2 is " + bag2.iterator());

      Queue<Integer> nQueue1 = new Queue<Integer>();
      Queue<Integer> nQueue2 = new Queue<Integer>();
      int nVertices = wordGraph.V();

      int [] weight1 = new int[nVertices];
      int [] weight2 = new int[nVertices];
      boolean [] bVisited1 = new boolean[nVertices];
      boolean [] bVisited2 = new boolean[nVertices];

      for (int nIndex = 0; nIndex < nVertices; nIndex++)
      {
         weight1[nIndex] = Integer.MAX_VALUE/2;
         weight2[nIndex] = Integer.MAX_VALUE/2;
         bVisited1[nIndex] = false;
         bVisited2[nIndex] = false;
      }
      
      // System.out.println("bag1");
      for (int node : bag1)
      {  
         // System.out.print(node + " ");
         nQueue1.enqueue(node);
         weight1[node] = 0;
         bVisited1[node] = true;
      }
      
      // System.out.println("bag2");

      for (int node : bag2)
      {
         // System.out.print(node + " ");
         nQueue2.enqueue(node);
         weight2[node] = 0;
         if (bVisited1[node])
         {
            nAncestor = node;
            return 0;
         }

         bVisited2[node] = true;
      }
      
      int nDistance = calLength(nQueue1, nQueue2, weight1, weight2, bVisited1, bVisited2);
      return nDistance;

   }

   public String sap(String nounA, String nounB)
   {
        if (nounA == null || nounB == null)
            throw new java.lang.NullPointerException("The inputs string for sap function have null");
         
        distance(nounA, nounB);

        int commonAncestor = nAncestor;

        return idWords.get(commonAncestor);

   }

   // do unit testing of this class
   public static void main(String[] args)
   {
      // String str1 = args[0];
      // String str2 = args[1];
      // WordNet wn = new WordNet(str1, str2);
      // System.out.println("Distance between caisson and Stanislavsky is " + wn.distance("Stanislavsky", "caisson"));
   }
}