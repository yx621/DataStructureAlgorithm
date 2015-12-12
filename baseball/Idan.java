public class Idan
{
    public static void main(String[] args) 
    {
        int nInput = Integer.parseInt(args[0]);

        int nSqrt = (int) Math.sqrt(nInput);

        int A = 1;
        int B = nInput;
        System.out.println(nInput + " " + nSqrt);
        for (int nIndex = nSqrt; nIndex >= 1; nIndex--)
        {
            if (nInput%(nIndex*nIndex) == 0)
            {
                A = nIndex;
                B = nInput/nIndex/nIndex;
                System.out.println(A + " " + B);
                break;
            }
        }

        double dNumber = Double.parseDouble(args[1]);
        boolean bFlag = dNumber%1 != 0;
        System.out.println(dNumber%1);
        System.out.println(dNumber + " " + bFlag);
    }
}