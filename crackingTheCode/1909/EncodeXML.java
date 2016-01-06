import java.util.Arrays;
import java.util.Random;
public class EncodeXML
{
    public static void findPairs(int [] arr, int sum)
    {
        System.out.println("The initial array is ");
        for (int nIndex = 0; nIndex < arr.length; nIndex++)
        {
            System.out.print(arr[nIndex] + " ");
        }
        
        Arrays.sort(arr);
        
        System.out.println("\nThe sorted array is ");
        for (int nIndex = 0; nIndex < arr.length; nIndex++)
        {
            System.out.print(arr[nIndex] + " ");
        }
        System.out.println();
        int length = arr.length;
        int begin = 0;
        int end = length - 1;
        
        while(begin < end)
        {
            int s = arr[begin] + arr[end];
            
            if (s == sum)
            {
                System.out.println("(" + arr[begin] + ", " + arr[end] + ")");
                begin++;
                end--;
            }
            
            else if (s < sum)
            {
                begin++;
                
            }
            
            else if (s > sum)
            {
                end --;
            }
        }
    
    }
    
    public static void main(String [] args)
    {
        int sum = Integer.parseInt(args[0]);
        
        int [] arr = new int[20];
        Random rnd = new Random();
        
        for (int nIndex = 0; nIndex < 20; nIndex++)
        {
            arr[nIndex] = rnd.nextInt(100);
        }
        
        findPairs(arr, sum);
        
        
        
        
    }
}