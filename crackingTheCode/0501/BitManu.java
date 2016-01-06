public class BitManu
{
    public static int intervalSum(int N, int M, int mIndex, int nIndex)
    {
        if (nIndex < mIndex)
        {
            System.out.println("Invalid nIndex mIndex pair, don't process the data");

            return N;
        }

        int constant = 0;

        for (int iii = 0; iii < nIndex - mIndex + 1; iii++)
        {
            constant *= 2;
            constant++;
        }

        M = M & constant;
        System.out.println("The constant numebr in the function is " + Integer.toBinaryString(constant));
        // constant = Integer.rotateLeft(constant, mIndex);
        constant = constant << mIndex;
        constant = ~constant;
        // M = Integer.rotateLeft(M, mIndex);
        M = M << mIndex;
        System.out.println("N before XORing with constant is " + Integer.toBinaryString(N));
        N = N & constant;
        System.out.println("N after XORing with constant is " + Integer.toBinaryString(N));
        System.out.println("The numebr M after processing is " + Integer.toBinaryString(M));
        N = N|M;

        return N;
    }


    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int nIndex = Integer.parseInt(args[2]);
        int mIndex = Integer.parseInt(args[3]);

        System.out.println("The 4 numebrs are (" + N + " " + M + " " + nIndex  + " " + mIndex + ")");
        System.out.println("The binary repestation of the 2 numebrs are:");

        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(M));
        System.out.println("take the index of M from " + mIndex + " to " + nIndex);

        System.out.println("The binary number after the method is " + Integer.toBinaryString(intervalSum(N, M, nIndex, mIndex)));

    }
}