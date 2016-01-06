public class ConvertInt
{
    public static void convert(int A, int B)
    {
        int result = A^B;

        System.out.println(Integer.bitCount(result));
    }

    public static void main(String[] args) 
    {
        int nNumber1 = Integer.parseInt(args[0]);
        int nNumber2 = Integer.parseInt(args[1]);

        convert(nNumber1, nNumber2);
    }
}