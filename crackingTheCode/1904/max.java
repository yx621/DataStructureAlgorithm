public class max
{
    public static int getmax(int a, int b)
    {
        int c = a - b;
        int k = (c>>31) & 0X01;

        int max = a - k*c;

        return max;
    }
    public static void main(String [] args)
    {
        int nNumber1 = Integer.parseInt(args[0]);
        int nNumber2 = Integer.parseInt(args[1]);

        System.out.println("The inputs are " + nNumber1 + " " + nNumber2);

        System.out.println("The maximum number is " + getmax(nNumber2, nNumber1));
    }
}