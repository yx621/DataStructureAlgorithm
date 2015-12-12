public class napsack
{
    public static class item
    {
        private int value;
        private int weight;

        public item()
        {
            value = 0;
            weight = 0;
        }

        public item(int nValue, int nWeight)
        {
            value = nValue;
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

    public static void main(String[] args) 
    {
        String filename = args[0];

        In in = new In(filename);

        int capacity = in.readInt();
        int nitem = in.readInt();

        item [] items = new item[nitem + 1];

        items[0] = new item(0, 1);

        for (int nIndex = 1; nIndex <= nitem; nIndex++)
        {
            int value = in.readInt();
            int weight = in.readInt();

            items[nIndex] = new item(value, weight);

        }
        
        //the recursion from 0 to capacity for weight factor
        long [][] A = new long[nitem + 1][capacity + 1];

        for (int mIndex = 0; mIndex <= capacity; mIndex++)
        {
            A[0][mIndex] = 0;
        }
        

        for (int nIndex = 1; nIndex <= nitem; nIndex++)
            for (int mIndex = 0; mIndex <= capacity; mIndex++)
            {
                if (mIndex >= items[nIndex].getWeight())
                {
                    A[nIndex][mIndex] = Math.max(A[nIndex - 1][mIndex], A[nIndex - 1][mIndex - items[nIndex].getWeight()] + items[nIndex].getValue());    
                }

                else
                {
                    A[nIndex][mIndex] = A[nIndex - 1][mIndex];
                }
            }


        System.out.println("The desiered optimal solution is " + A[nitem][capacity]);




        //[value weight]
    }
}