public class jigsaw
{
    public class Edge
    {
        enum Type {Inner, Outer, Flat}
        Piece parent;

        Type type;

        public boolean fitsWith(Edge edge)
        {
            // check the fitness with one edge
        }
    }

    public class Piece
    {
        Edge left, right, bottom, top;
        // Orientation solvedOrientation = ...; 90. 180 (seems rotate the piece...)
    }

    Piece [][] pieces;
    Piece [][] solution;

    Edge [] inners, outers, flats;
    // Solve it by working way inwards, start with corners. Here is list of inside edges

    Edge [] exposed_edges;

    public void sort()
    {
        /*
          Interate all edges, adding each to innners, outers as appropriate
          Look for corners and add those to solution
          each non-flat edge of the corner to exposed_edges
        */

    }

    public void solve()
    {
        /*
          For each edge1 in exposed edges
          Look for a match to edge1
          if (edge1.Type == Edge.Type.inner)
          {
              for (edge2 in outers)
              {
                  if (edge1.fitWith(edge2))
                  {
                      find a match
                      remove edge1 from exposed edges 
                      add edge2's piece to solution
                      check which edges of edge2 are exposed
                      add those to exposed edges
                  }
              }
          }
        */
    }

    /*
      group edges based on type
      keep track of inner perimater of puzzle as we work our way inward. 
      exposed edges is initialized to be courner's edges
    */

}