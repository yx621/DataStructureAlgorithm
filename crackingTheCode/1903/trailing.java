public class trailing
{
    public static int zeros(int n)
    {
        int constant = 5;

        int sum = 0;
        // this is not a good algorithm since 25 is just counted for one time
        while (n/constant >= 1)
        {
            sum = sum + n/constant;
            constant = constant*5;
        }
        
        return sum;

    }
    public static void main(String[] args) 
    {
        int nNumber = Integer.parseInt(args[0]);
        int sum = zeros(nNumber);
        System.out.println("The " + nNumber + "th factorial has " + sum + " trailing zeros");
    }
}