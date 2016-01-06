public class nextInt
{
    public static void next(int nNumber)
    {
        int bit1 = Integer.bitCount(nNumber);
        int next;
        int previous;

        System.out.println("The input binary is " + Integer.toBinaryString(nNumber));

        if (bit1 == 0)
        {
            System.out.println("input data is 0");
            return;
        }

        if (bit1 == 1)
        {
            System.out.println("The next largest is " + Integer.toBinaryString(2*nNumber));
            System.out.println("The next smallest is " + Integer.toBinaryString(nNumber/2));
            return;
        } 

        int nTemp = nNumber;
        int count = 0;

        while (nTemp > 0)
        {
            nTemp = nTemp/2;
            count++;
        }

        int nLarge = 1;
        nLarge = nLarge<<count;

        int nSmall = nLarge>>2;
        // System.out.println("binary represnetation of nLarge is " + Integer.toBinaryString(nLarge));
        int ntlarge = 0;
        int ntsmall = 0;
        for (int nIndex = 0; nIndex < bit1 - 1; nIndex++)
        {
            ntlarge = 2*ntlarge + 1;
        }
        if(count >= bit1 + 1)
        {
            ntsmall = ntlarge<<(count - bit1 - 1);    
        }

        else
        {
            System.out.println("The input number is not correct");
            return;
        }
        
        nLarge = nLarge + ntlarge;
        nSmall = nSmall + ntsmall;
        System.out.println("binary represnetation of next largest is " + Integer.toBinaryString(nLarge));
        System.out.println("binary represnetation of next smallest is " + Integer.toBinaryString(nSmall));

    }



    public static void main(String[] args) 
    {
        String str = args[0];
        int nNumber = Integer.parseInt(str);

        next(nNumber);
    }
}