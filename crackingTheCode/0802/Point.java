public final class Point { 
    private final int x;    // x-coordinate
    private final int y;    // y-coordinate
   
    // random point
    public Point() {
        x = 0;
        y = 0;
    }

    // point initialized from parameters
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // accessor methods
    public int x() { return x; }
    public int y() { return y; }
    public double r() { return Math.sqrt(x*x + y*y); }
    public double theta() { return Math.atan2(y, x); }

    // Euclidean distance between this point and that point
    public double distanceTo(Point that) {
        int dx = this.x - that.x;
        int dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    // return a string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    } 

}
