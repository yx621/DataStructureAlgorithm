public class FindMissing
{
    
    public static class BitSet
    {
        public int [] bitset;

        public BitSet(int size)
        {
            bitset = new int[size>>5];
            for (int nIndex = 0; nIndex < size>>5; nIndex++)
            {
                bitset[nIndex] = 0;
            }
        }

        public boolean get(int index)
        {
            int wordNumber = index>>5;
            int bitNumber  = (index & 0X1F);
            return (bitset[wordNumber] & (1<<bitNumber)) != 0;
        }

        public void set(int index)
        {
            int wordNumber = index>>5;
            int bitNumber  = index & 0X1F;
            bitset[wordNumber] |= (1<<bitNumber);
        }

    }

    public static void main(String[] args) 
    {
        String filename = args[0];

        In in = new In(filename);

        BitSet bs = new BitSet(32000);

        while (in.isEmpty() == false)
        {
            int n = in.readInt();
            
            if (bs.get(n))
            {
                System.out.println(n + " is duplicated ");
            }
            
            else
            {
                bs.set(n);    
            }
        }



    }
}