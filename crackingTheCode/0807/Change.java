public class Change
{
    public static int makeChange(int n, int demo)
    {
        int next_demo = 0;

        switch(demo)
        {
            case 25:
                next_demo = 10;
                break;
            case 10:
                next_demo = 5;
                break;
            case 5:
                next_demo = 1;
                break;
            case 1:
                next_demo = 1;
                return 1;
        }

        int ways = 0;
        for (int nIndex = 0; nIndex*demo <= n; nIndex++)
        {
            ways = ways + makeChange(n - nIndex*demo, next_demo);
        }

        return ways;
    }


    public static void main(String[] args) 
    {   
        int cores = Integer.parseInt(args[0]);
        int ways = makeChange(cores, 25);

        System.out.println("We hava " + ways + " ways to represent money " + cores);
    }
}