public class Fib
{
    public static long fib(int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (n < 0)
        {
            System.out.println("invalid input number");
            return -1;
        }

        return (fib(n-1) + fib(n -2));
    }

    public static long fib2(int n)
    {
        long [] fibn = new long[n + 1];

        fibn[0] = 0;
        fibn[1] = 1;

        for (int nIndex = 2; nIndex <= n; nIndex++)
        {
            fibn[nIndex] = fibn[nIndex - 1] + fibn[nIndex - 2];
        }
        // even not need for the array

        return fibn[n];
    }

    public static long fib3(int n)
    {
        long a = 0; 
        long b = 1;
        long c = 0;
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        if (n < 0)
            return -1;

        for (int nIndex = 2; nIndex <= n; nIndex++)
        {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
        
    }

    public static void main(String[] args) 
    {
        int nNumber = Integer.parseInt(args[0]);
        Stopwatch watch1 = new Stopwatch();
        System.out.println("fib2(" + nNumber + ") = " + fib2(nNumber));
        double time1 = watch1.elapsedTime();
        System.out.println("Recursion takes time " + time1);

        Stopwatch watch2 = new Stopwatch();
        System.out.println("fib3(" + nNumber + ") = " + fib3(nNumber));
        double time2 = watch2.elapsedTime();
        System.out.println("Iteration takes time " + time2);
    }
}