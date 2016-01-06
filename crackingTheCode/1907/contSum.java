import java.util.Random;

public class contSum
{
    public static int getSum(int [] arr)
    {
        int length = arr.length;
        
        int [] answer = new int[length];
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            answer[nIndex] = 0;
        }
        
        answer[0] = arr[0];
        int max = answer[0];
        for (int nIndex = 1; nIndex < length; nIndex++)
        {
            answer[nIndex] = Math.max(arr[nIndex], answer[nIndex-1] + arr[nIndex]);
            if (answer[nIndex] > max)
                max = answer[nIndex];
        }
        
        return max;
    }
    public static void main(String [] args)
    {
        Random rnd = new Random();
        int [] nArr = new int[10];
        for (int nIndex = 0; nIndex < 10; nIndex++)
        {
            nArr[nIndex] = rnd.nextInt(10) - 5;
            System.out.print(nArr[nIndex] + " " );
        }
        System.out.println("\nThe maximum continous sum is " + getSum(nArr));
        
        
        
    }
}