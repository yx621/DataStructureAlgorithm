import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DijkstraSP;
public class median
{
    public static void main(String[] args) 
    {
        String filename = args[0];
        In in1 = new In(filename);

        MaxPQ smallhalf = new MaxPQ<Integer>();
        MinPQ bighalf = new MinPQ<Integer>();

        int sum = 0;
        int mid = 0;

        while (in1.hasNextLine())
        {
            //data format is 1 2,30 ...
            // change the , to space and drop the first one
            int Ntemp = in1.readInt();
            
            
            if (smallhalf.size() == 0 || bighalf.size() == 0)
            {
                if (smallhalf.size() == 0)
                {
                    mid = Ntemp;
                    sum += mid;
                    smallhalf.insert(Ntemp);    
                }

                else
                {
                    if (Ntemp > (Integer) smallhalf.max())
                    {   
                        bighalf.insert(Ntemp);
                        mid = (Integer) smallhalf.max();
                        sum += mid;
                    }

                    else
                    {
                        mid = Ntemp;
                        bighalf.insert(smallhalf.max());
                        smallhalf.delMax();
                        smallhalf.insert(Ntemp);
                        sum += mid;
                    }
                }
                
            }

            else if (smallhalf.size() == bighalf.size())
            {
                if (Ntemp > (Integer) bighalf.min())
                {
                    bighalf.insert(Ntemp);
                    mid = (Integer) bighalf.min();
                    sum += mid;
                }

                else if (Ntemp < (Integer) smallhalf.max())
                {
                    smallhalf.insert(Ntemp);
                    mid = (Integer) smallhalf.max();
                    sum += mid;
                }

                else
                {
                    smallhalf.insert(Ntemp);
                    mid = (Integer) smallhalf.max();
                    sum += mid;   
                }
            }

            else if (smallhalf.size() > (Integer) bighalf.size())
            {
                if (Ntemp > (Integer) bighalf.min() || Ntemp > (Integer) smallhalf.max())
                {
                    bighalf.insert(Ntemp);
                    mid = (Integer) smallhalf.max();
                    sum += mid;
                }

                else
                {
                    bighalf.insert(smallhalf.max());
                    smallhalf.delMax();
                    smallhalf.insert(Ntemp);
                    mid = (Integer) smallhalf.max();
                    sum += mid;
                }
            }

            else if (bighalf.size() > (Integer) smallhalf.size())
            {
                if (Ntemp <  (Integer) smallhalf.max() || Ntemp < (Integer) bighalf.min())
                {
                    smallhalf.insert(Ntemp);
                    mid = (Integer) smallhalf.max();
                    sum += mid;
                }

                else
                {
                    smallhalf.insert(bighalf.min());
                    bighalf.delMin();
                    bighalf.insert(Ntemp);
                    mid = (Integer) smallhalf.max();
                    sum += mid;
                }
            }

        }

        System.out.println("The median sum for the input data is " + sum);
        System.out.println("The required output data is " + sum%10000);



    }
}