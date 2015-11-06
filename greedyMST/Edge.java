public class Edge implements Comparable<Edge> 
{
    private final int v;
    private final int w;
    private final int weight;

    public Edge(int v, int w, int weight) 
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int weight() 
    {
        return weight;
    }

    public int either() 
    {
        return v;
    }

    public int other(int vertex) 
    {
        if      (vertex == v) return w;
        return v;
    }
    
    public int compareTo(Edge that) 
    {
        return this.weight() - that.weight();
    }

    public String toString() {
        return "(" + v + ", " + w + ", " + weight + ")" ;
    }

}