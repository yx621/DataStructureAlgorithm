import java.util.Arrays;

public class bignapsack
{
    public static class item implements Comparable<item> 
    {
        private int value;
        private int weight;
        private int acValue;
        private int acWeight;
        //accumulated value and weight respectively

        public item()
        {
            value = 0;
            weight = 0;
            acValue = 0;
            acWeight = 0;
        }

        public item(int nValue, int nWeight)
        {
            value = nValue;
            weight = nWeight;
            acValue = 0;
            acWeight = 0;
        }

        public void setACvalue(int nacValue)
        {
            acValue = nacValue;
        }

        public void setACweight(int nacWeight)
        {
            acWeight = nacWeight;
        }

        public int getValue()
        {
            return value;
        }

        public int getWeight()
        {
            return weight;
        }

        public int getacValue()
        {
            return acValue;
        }

        public int getacWeight()
        {
            return acWeight;
        }

        public int compareTo(item that)
        {
            return this.weight - that.weight;
        }

        public String toString()
        {
            return "(" + value + " ," + weight + ")";
        }

    }

    public static class solution
    {
        private int value;
        private int weight;

        public solution()
        {
            value = 0;
            weight = 0;
        }

        public void setValue(int nValue)
        {
            value = nValue;
        }

        public void setWeight(int nWeight)
        {
            weight = nWeight;
        }

        public int getValue()
        {
            return value;
        }

        public int getWeight()
        {
            return weight;
        }
    }

    public static int solveSub(int n, int c, item [] items)
    {
        if (c < 0)
            return Integer.MIN_VALUE;

        if (n <= 0)
            return 0;

        return Math.max(solveSub(n - 1, c, items), solveSub(n - 1, c - items[n].getWeight(), items) + items[n].getValue());

    }
    public static void main(String[] args) 
    {
        String filename = args[0];

        In in = new In(filename);

        int capacity = in.readInt();
        int nitem = in.readInt();

        item [] items = new item[nitem];

        Stopwatch watch1 = new Stopwatch();
        for (int nIndex = 0; nIndex < nitem; nIndex++)
        {
            int value = in.readInt();
            int weight = in.readInt();

            items[nIndex] = new item(value, weight);
        }

        double time1 = watch1.elapsedTime();

        System.out.println("initialize the data takes " + time1 + " seconds");



        Stopwatch watch2 = new Stopwatch();

            // int nsol = solveSub(nitem - 1, capacity, items);

        for (int nIndex = 0; nIndex < nitem; nIndex++)
        {
            System.out.println(items[nIndex]);
        }

        Arrays.sort(items);

        System.out.println("************");
        System.out.println("************");
        System.out.println("************");
        
        for (int nIndex = 0; nIndex < nitem; nIndex++)
        {
            System.out.println(items[nIndex]);
        }

        double time2 = watch2.elapsedTime();

        System.out.println("algorithm takes that time " + time2);
        
        

        // System.out.println("The solution of this problem is " + nsol);
        // solution [] ans = new solution[capacity];

        // //initialize the answer 
        // for (int nIndex = 0; nIndex < capacity; nIndex++)
        // {
        //     ans[nIndex] = new solution();
        // }
        //initialze all to 0
        // int max = 0;
        // for (int mIndex = 0; mIndex < nitem; mIndex++)
        // {
        

        //     if (items[mIndex].getWeight() <= 1)
        //     {
        //         if (items[mIndex].getValue() > max)
        //         {
        //             max = items[mIndex].getValue();
        //             ans[0].setWeight(items[mIndex].getWeight());
        //             ans[0].setValue(max);
        //         }

        //         else if (items[mIndex].getValue() = max)
        //         {
        //             if (items[mIndex].getWeight() < ans[0].getWeight())
        //                 ans[0].setWeight(items[mIndex].getWeight());
        //         }
        //     }
        // }


        // for (int nIndex = 1; nIndex < capacity; nIndex++)
        // {
        //     max = ans[nIndex - 1].getValue();

        //     for (int mIndex = 0; mIndex < nitem; mIndex++)
        //     {
        //         if (items[mIndex].getWeight() + ans[nIndex].getWeight() <= nIndex + 1)
        //         {
        //             max = ans[nIndex - 1].getValue() + items[mIndex].getValue();
        //             ans[nIndex].setWeight(items[nIndex].getWeight() + ans[nIndex - 1].getWeight());
        //             ans[nIndex].setValue(max);
        //         }

        //         else
        //         {
        //             for(int pIndex = nIndex - 1; pIndex >= 0; pIndex++)
        //             {
        //                 if (items[mIndex].getWeight() + ans[pIndex].getWeight() <= nIndex + 1 && items[mIndex].getValue() + ans[pIndex].getValue() > ans[nIndex].getValue())
        //                 {
        //                     ans[nIndex].setWeight(ans[nIndex].getWeight() + items[mIndex].getWeight());
        //                     ans[nIndex].setValue(ans[nIndex].getValue() + items[mIndex].getValue());
        //                     break;
        //                 }
        //             }
                    
                    
                    
        //             ans[nIndex].setWeight(ans[nIndex - 1].getWeight());
        //             ans[nIndex].setValue(ans[nIndex - 1].getValue());
                    
                    

        //         }
        //     }
        // }

        // items[0].setACvalue(items[0].getValue());
        // items[0].setACweight(items[0].getWeight());

        // for (int nIndex = 1; nIndex < nitem; nIndex++)
        // {
        //     if (items[nIndex - 1].getacWeight() + items[nIndex].getWeight() <= capacity)
        //     {
        //         items[nIndex].setACweight(items[nIndex-1].getacWeight() + items[nIndex].getWeight());
        //         items[nIndex].setACvalue(items[nIndex-1].getacValue() + items[nIndex].getValue());
        //     }

        //     else
        //     {
        //         for (int mIndex = nIndex - 2; mIndex >= 0; mIndex--)
        //         {
        //             if (items[mIndex].getacWeight() + items[nIndex].getWeight() <= capacity && items[mIndex].getacValue() + items[nIndex].getValue() > items[nIndex - 1].getacValue())
        //             {
        //                 items[nIndex].setACweight(items[nIndex-1].getacWeight() + items[nIndex].getWeight());
        //                 items[nIndex].setACvalue(items[nIndex-1].getacValue() + items[nIndex].getValue());           
        //                 break;
        //             }
        //         }

        //         items[nIndex].setACweight(items[nIndex-1].getacWeight());
        //         items[nIndex].setACvalue(items[nIndex-1].getacValue());

        //     }


        // }

        // double time2 = watch2.elapsedTime();
        // System.out.println("The algorithm time is " + time2);
        // System.out.println("The weight for the knapsack is " + items[nitem - 1].getacWeight() + " and the value for the knapsack is " + items[nitem - 1].getacValue());

    }
}