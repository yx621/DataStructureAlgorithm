public class QuickCount
{

    public static long nCount = 0;

    public static int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[left];
        //int pivot = arr[right];
        nCount += right - left - 1;
    
        while (i <= j) 
        {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        
        return i;
    }

    public static int partitionleft(int arr[], int left, int right)
    {
        /*
        int i = left + 1;
        int j = right;
        int tmp;
        int pivot = arr[left];
        //int pivot = arr[right];
        nCount += right - left;
    
        while (i <= j) 
        {
            while (arr[i] < pivot && i <= right)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        
        
        tmp = pivot;
        arr[left] = arr[i - 1];
        arr[i - 1] = tmp;
        

        return i - 1;
        */

        int i = left + 1;
        int j = left + 1;
        int tmp;
        int pivot = arr[left];

        nCount += right - left;

        while (j <= right)
        {
            if (arr[j] > pivot)
                j++;

            else if (arr[j] < pivot)
            {
                //change ith and jth element
                if (i == j)
                {
                    i++;
                    j++;
                }

                else

                {
                    tmp = arr[i];
                    arr[i] = arr[j];

                    arr[j] = tmp;
                    i++;
                    j++;
                }
            }
        }

        tmp = pivot;
        arr[left] = arr[i - 1];
        arr[i - 1] = tmp;
        
        return i - 1;
    }

    public static int partitionright(int arr[], int left, int right)
    {
        /*
        int i = left + 1;
        int j = right;
        int pivot;
        nCount += right - left;
        int tmp;

        pivot = arr[right];
        
        tmp = arr[right];
        arr[right] = arr[left];
        arr[left] = tmp;

        
        while (i <= j) 
        {
            while (arr[i] < pivot && i <= right)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        */


        int i = left + 1;
        int j = left + 1;
        int tmp;
        int pivot = arr[right];

        nCount += right - left;


        tmp = arr[right];
        arr[right] = arr[left];
        arr[left] = tmp;


        while (j <= right)
        {
            if (arr[j] > pivot)
                j++;

            else if (arr[j] < pivot)
            {
                //change ith and jth element
                if (i == j)
                {
                    i++;
                    j++;
                }

                else

                {
                    tmp = arr[i];
                    arr[i] = arr[j];

                    arr[j] = tmp;
                    i++;
                    j++;
                }
            }
        }


        tmp = pivot;
        arr[left] = arr[i - 1];
        arr[i - 1] = tmp;
        

        return i - 1;
    }


    public static int partitionmiddle(int arr[], int left, int right)
    {
        /*
        int i = left + 1;
        int j = right;
        int pivot;
        nCount += right - left;
        int tmp;

        
        if ((arr[left] - arr[right]) * (arr[left] - arr[(left + right)/2]) < 0)
        {
            pivot = arr[left];
        } 

        else if ((arr[right] - arr[left]) * (arr[right] - arr[(left + right)/2]) < 0)
        {
            pivot = arr[right];
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

        else
        {
            pivot = arr[(left + right)/2];
            tmp = arr[left];
            arr[left] = arr[(left + right)/2];
            arr[(left + right)/2] = tmp;   
        }



        while (i <= j) 
        {
            while (arr[i] < pivot && i <= right)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        
        */

        int i = left + 1;
        int j = left + 1;
        int tmp;
        int pivot;

        nCount += right - left;



        if ((arr[left] - arr[right]) * (arr[left] - arr[(left + right)/2]) < 0)
        {
            pivot = arr[left];
        } 

        else if ((arr[right] - arr[left]) * (arr[right] - arr[(left + right)/2]) < 0)
        {
            pivot = arr[right];
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

        else
        {
            pivot = arr[(left + right)/2];
            tmp = arr[left];
            arr[left] = arr[(left + right)/2];
            arr[(left + right)/2] = tmp;   
        }



        while (j <= right)
        {
            if (arr[j] > pivot)
                j++;

            else if (arr[j] < pivot)
            {
                //change ith and jth element
                if (i == j)
                {
                    i++;
                    j++;
                }

                else

                {
                    tmp = arr[i];
                    arr[i] = arr[j];

                    arr[j] = tmp;
                    i++;
                    j++;
                }
            }
        }




        tmp = pivot;
        arr[left] = arr[i - 1];
        arr[i - 1] = tmp;
        

        return i - 1;
    }


    public static void quickSortleft(int arr[], int left, int right) 
    {
        //int index = partition(arr, left, right);
    
        int index = partitionleft(arr, left, right);

        if (left < index - 1)
            quickSortleft(arr, left, index - 1);

        if (index + 1 < right)
            quickSortleft(arr, index + 1, right);
        
    }

    public static void quickSortright(int arr[], int left, int right) 
    {
        //int index = partition(arr, left, right);
        

        int index = partitionright(arr, left, right);

        if (left < index - 1)
            quickSortright(arr, left, index - 1);

        if (index < right)
            quickSortright(arr, index + 1, right);
    }
    
    public static void quickSortmiddle(int arr[], int left, int right) 
    {
        //int index = partition(arr, left, right);
        

        int index = partitionmiddle(arr, left, right);

        if (left < index - 1)
            quickSortmiddle(arr, left, index - 1);

        if (index < right)
            quickSortmiddle(arr, index + 1, right);
        

    }

    public static void main(String[] args) 
    {
        String filename = args[0];

        In in = new In(filename);

        int N = in.readInt();

        int [] array = new int[N];

        for (int nIndex = 0; nIndex < N; nIndex++)
        {
            array[nIndex] = in.readInt();

        }

        QuickCount.nCount = 0;

        QuickCount.quickSortmiddle(array, 0, N - 1);

        System.out.println("The echange numebr for this algorithm is " + QuickCount.nCount);

        for (int nIndex = 0; nIndex < 10; nIndex++)
        {
            System.out.println(array[nIndex]);
        }

        

    }
}