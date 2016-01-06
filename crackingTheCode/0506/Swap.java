public class Swap
{
    public static void sawpOE(int nNumber)
    {

        System.out.println("The original number in binary is " + Integer.toBinaryString(nNumber));

        int nIndex = 0;

        int n1 = 0;
        int n2 = 0;
        int sum = 0;
        while (nIndex < 32 && nNumber != 0)
        {
            n1 = nNumber%2;
            nNumber = nNumber/2;
            n2 = nNumber%2;
            nNumber = nNumber/2;

            // sum = 2*sum + n2;
            // sum = 2*sum + n1;
            int temp0 = n2<<(nIndex);
            sum = sum + temp0;
            // System.out.println("n2, index and sum is " + n2 + " " + nIndex + " " + sum);
            int temp = n1<<(nIndex+1);
            // sum = sum + n1<<(nIndex+1);
            sum += temp;
            // System.out.println("n1, index and sum is " + n1 + " " + (nIndex + 1) + " "+ sum);

            // System.out.println("n1<<(nIndex+1) = " + temp);
            nIndex = nIndex + 2;
            // System.out.println("The nIndex and nNumber inside the loop is " + nIndex + " " + nNumber + " sum " + sum);
        }
        
        System.out.println("The swapped  number in binary is " + Integer.toBinaryString(sum));
    }

    public static void main(String[] args) 
    {
        int nNumber = Integer.parseInt(args[0]);
        sawpOE(nNumber);
    }
}