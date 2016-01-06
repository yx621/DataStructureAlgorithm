public class Rotate
{
    public static void sort(int [] a, int n, int low, int high)
    {
        if (low > high)
        {
            System.out.println("no content in the array");
            return;
        }

        int value1 = a[low];
        int value2 = a[high];
        int middle = (low + high)/2;
        int value3 = a[middle];

        if (value3 == n)
        {
            System.out.println("The wanted index is " + middle);
            return;
        }
        // search for right 
        if ((n - value3)*(n - value2) < 0)
        {
            low = middle + 1;
            sort(a, n, low, high);
        }

        else
        {
            high = middle - 1;
            sort(a, n, low, high);
        }

    }

    public static int sort2(int [] a, int n)
    {
        int low = 0;
        int high = a.length - 1;
        while (low <= high)
        {
            int value1 = a[low];
            int value2 = a[high];
            int middle = (low + high)/2;
            int value3 = a[middle];

            if (value3 == n)
            {
                // System.out.println("The wanted index is " + middle);
                return middle;
            }
            
            if ((n - value3)*(n - value2) < 0)
            {
                low = middle + 1;
            }

            else
            {
                high = middle - 1;
            }
        }

        return -1;
        

    }
    public static void main(String[] args) 
    {
        int [] array = new int[12];
        array[0] = 15;
        array[1] = 16;
        array[2] = 19;
        array[3] = 20;
        array[4] = 25;
        array[5] = 1;
        array[6] = 3;
        array[7] = 4;
        array[8] = 5;
        array[9] = 7;
        array[10] = 10;
        array[11] = 14;

        sort(array, 5, 0, array.length - 1);
        System.out.println("The index for number 5 is " + sort2(array, 5));

    }

}
