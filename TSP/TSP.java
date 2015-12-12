import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Edge;
public class TSP
{
    public static void main(String[] args) 
    {
        // StdDraw.setXscale(0, 32768);
        // StdDraw.setYscale(0, 32768);
        // StdDraw.show(0);
        // StdDraw.setPenRadius(0.005);  // make the points a bit larger
        
        String filename = args[0];
        
        In in = new In(filename);
        
        int nVertex = in.readInt();
        
        System.out.println("The vertex number is " + nVertex);
        
        Point [] points = new Point[nVertex];
        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            double x = in.readDouble();
            double y = in.readDouble();

            points[nIndex] = new Point(x, y);

            // points[nIndex].draw();
        }
        
        // StdDraw.show(0);

        double min = Double.MAX_VALUE;

        // System.out.println("The double maximum is " + min);
        
        boolean [] bArr = new boolean[nVertex];
        Stopwatch watch1 = new Stopwatch();

        for (int nIndex = 0; nIndex < nVertex; nIndex++)
        {
            double sum = 0.0;
            
            for (int mIndex = 0; mIndex < nVertex; mIndex++)
                bArr[mIndex] = false;
            
            MinPQ pq = new MinPQ<Edge>();

            for (int mIndex = 0; mIndex < nVertex; mIndex++)
            {
                if (mIndex != nIndex)
                {
                    Edge eTemp = new Edge(nIndex, mIndex, points[nIndex].distance(points[mIndex]));
                    // System.out.println("The distance here for nIndex " + nIndex + " is " + eTemp.weight());
                    pq.insert(eTemp);    
                }
                
            }

            while(pq.isEmpty() == false)
            {
                Edge eTemp = (Edge)pq.delMin();
                int v = eTemp.either();
                int w = eTemp.other(v);

                if (bArr[w] == false && bArr[v] == false)
                {
                    bArr[w] = true;
                    sum += eTemp.weight();
                    // System.out.println("What happened here " + sum);

                    for (int pIndex = 0; pIndex < nVertex; pIndex++)
                    {
                        if (bArr[pIndex] == false)
                        {
                            Edge eTemp2 = new Edge(w, pIndex, points[w].distance(points[pIndex]));
                            pq.insert(eTemp2);
                        }
                        
                    }
                }

                // if (w == nIndex && )


            }

            // System.out.println("sum after while loop is " + nIndex + ", " + sum);

            if (min > sum)
                min = sum;

        }

        double time0 = watch1.elapsedTime();

        System.out.println("The algorithm takes time " + time0);
        System.out.println("The nearest neighbor gives solution " + min);
    }
}