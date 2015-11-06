public class Edge implements Comparable<Edge> 
{
    private final int begin;
    private final int end;
    private final int weight;

    public Edge(int v, int w, int wei) 
    {
        begin = v;
        end = w;
        weight = wei;
    }
    
    public int weight() 
    {
        return weight;
    }

    public int begin() 
    {
        return begin;
    }

    public int end() 
    {
        return end;
    }
    
    public int compareTo(Edge that) 
    {
        return this.weight() - that.weight();
    }

    public String toString() {
        return "(" + begin + ", " + end + ", " + weight + ")" ;
    }

}