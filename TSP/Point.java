/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;
//import java.util.Comparator;

public class Point implements Comparable<Point> 
{
    private double inf = Double.POSITIVE_INFINITY;
    private double ninf = Double.NEGATIVE_INFINITY;
    
    // private final int x;                              // x coordinate
    private final double x;
    private final double y;
    
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>()
    {
        @Override
        public int compare(Point p0, Point p1)
        {
            double s0 = slopeTo(p0);
            double s1 = slopeTo(p1);
            return Double.compare(s0, s1);
        }
    };
    
    // create the point (x, y)
    public Point(double x, double y) 
    {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    
    // plot this point to standard drawing
    public void draw() 
    {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }
    
    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) 
    {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    
    // slope between this point and that point
    public double slopeTo(Point that) 
    {
        if (this.x == that.x)
        {
            if (this.y == that.y)
                return ninf;
            else
                return inf;
        }
        
        else if (this.y == that.y)
            return 0.0;
        else
            return (double) (this.y - that.y)/(this.x - that.x);
        /* YOUR CODE HERE */
    }
    
    public int compareTo(Point that) 
    {
        if (this.y > that.y)
            return 1;
        else if (this.y < that.y)
            return -1;
        else if (this.x > that.x)
            return 1;
        else if (this.x < that.x)
            return -1;
        else
            return 0;
    }
    
    // return string representation of this point
    public String toString() 
    {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    
    public double distance (Point that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;

        double distancesquare = dx*dx + dy*dy;

        return Math.sqrt(distancesquare);

    }
    // unit test
    public static void main(String[] args) 
    {
        /* YOUR CODE HERE */
    }
}