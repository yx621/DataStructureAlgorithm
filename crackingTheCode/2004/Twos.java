public class Twos
{
    public static int count(int nNumber)
    {
        int sum = 0;
        int factor = 1;
        while(nNumber/factor > 0)
        {
            sum += nNumber/(10*factor)*factor;
            int nTemp = nNumber%(factor*10);
            if(nTemp >= 3*factor)
            {
                sum += factor;
            }
            
            else if (nTemp >= 2*factor)
            {
                sum += nTemp - 2*factor + 1;
            }
            
            factor = factor*10;
        }
        
        return sum;
    }
    
    public static void main(String [] args)
    {
        int nNumber = Integer.parseInt(args[0]);
        System.out.println("The number of 2s between 0 and " + nNumber + " is " + count(nNumber));
    }
}