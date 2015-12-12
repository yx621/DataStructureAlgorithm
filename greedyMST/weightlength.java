import java.util.Comparator;

// public class Point implements Comparable<Point> 
// {}
public class weightlength implements Comparable<weightlength> 
{
    private int weight;
    private int length;
    public weightlength()
    {
        weight = 0;
        length = 0;
    }

    public weightlength(int w, int l)
    {
        weight = w;
        length = l;
    }

    /*
    public int compareTo(weightlength that)
    {
        if ((this.weight - this.length) != (that.weight - that.length))
            return (that.weight - that.length) - (this.weight - this.length);
        return that.weight - this.weight;
        //0 or equals is included in this comparison
    }
    */

    public int compareTo(weightlength that)
    {
        return that.weight*this.length - this.weight*that.length;
        //0 or equals is included in this comparison
    }

    public int getWeight()
    {
        return weight;
    }

    public int getLength()
    {
        return length;
    }

    public String toString()
    {
        return "(" + weight + ", " + length + ")";
    }

}
