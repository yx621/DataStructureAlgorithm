import java.util.Random;

public class sat
{
    
    public static class item
    {
        private int x;
        private int y;

        public item()
        {
            x = 0;
            y = 0;
        }

        public item(int nx, int ny)
        {
            x = nx;
            y = ny;
        }


        public int getX()
        {
            return x;
        }

        public int getY()
        {
            return y;
        }

    }

    public static boolean evaluate(item i0, boolean A[])
    {
        boolean xtemp = false;
        boolean ytemp = false;

        if (i0.getX() < 0)
        {
            xtemp = !(A[-i0.getX()]);
        }

        else if (i0.getX() >= 0)
        {
            xtemp = (A[i0.getX()]);   
        }

        if (i0.getY() < 0)
        {
            ytemp = !(A[-i0.getY()]);   
        }

        else if (i0.getY() >= 0)
        {
            ytemp = (A[i0.getY()]);      
        }

        return (xtemp || ytemp);

    }


    public static boolean solve(item [] items)
    {
        int nlength = items.length;

        long innerLoop = nlength;

        if (innerLoop > 10000)
        {
            innerLoop = innerLoop/10;
        }
        // innerLoop = innerLoop*nlength;

        System.out.println("The items length is " + nlength);
        double oloop = Math.log(nlength)/(Math.log(2));
        //this is the outer loop

        

        int ouloop = (int) oloop;
        System.out.println("The out loop number is " + ouloop);
        System.out.println("The inner loop number is " + innerLoop);
        Random rnd = new Random();

        for (int oIndex = 0; oIndex <= ouloop; oIndex++)
        {
            boolean [] value = new boolean[nlength + 1];    

            for (int nIndex = 0; nIndex <= nlength; nIndex++)
            {
                int nTemp = rnd.nextInt(2);

                if (nTemp == 1)
                    value[nIndex] = true;

                else value[nIndex] = false;
            }
            
            

            for (long nIndex = 0; nIndex < innerLoop; nIndex++)
            {

                int nCount = 0;
                int mIndex = 0;

                for (nCount = 0; nCount < nlength; nCount++)
                {
                    if (evaluate(items[nCount], value) == false)
                        break;
                }

                if (nCount == nlength)
                {
                    System.out.println("The inner loop number is "  + oIndex + ", " + nIndex);
                    return true;
                }

                for (mIndex = nCount; mIndex < nlength; mIndex++)
                {
                    if (evaluate(items[mIndex], value) == false)
                    {
                        int nTemp2 = rnd.nextInt(2);

                        if (nTemp2 == 0)
                        {
                            value[Math.abs(items[mIndex].getX())] = !value[Math.abs(items[mIndex].getX())];
                        }

                        else
                        {
                            value[Math.abs(items[mIndex].getY())] = !value[Math.abs(items[mIndex].getY())];   
                        }
                        

                        // for (int iii = 0; iii <= nlength; iii ++)
                        // {
                        //     //System.out.println(items[iii]);
                        //     System.out.println(value[iii]);
                        // }

                        // System.out.println("***************");


                //        break;
                    }

                    


                
                
                    
                }
                

                if ((nIndex + 1) % 1000 == 0)
                {
                    System.out.println("The current innner loop number is " + oIndex + ", " + nIndex) ;
                }
                
                    
            }


        }

        System.out.println("Inner loop iterations " + innerLoop);
        return false;

    }

    
    


    public static void main(String[] args) 
    {
        String filename = args[0];

        In in = new In(filename);

        int nitem = in.readInt();

        item [] items = new item[nitem];
        //need to deal with the negative nunmbers

        for (int nIndex = 0; nIndex < nitem; nIndex++)
        {
            int x = in.readInt();
            int y = in.readInt();

            items[nIndex] = new item(x, y);
        }

        Stopwatch watch1 = new Stopwatch();

        boolean bResult = solve(items);

        double time1 = watch1.elapsedTime();
        System.out.println("The time duration for the algorithm with input length " + nitem + " is " + time1);
        System.out.println("The SAT is solvable? " + bResult);


    }
}