public class createTree
{   
    
    public static BST<Integer, Integer> creatArray(int [] arr)
    {
        int length = arr.length;
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        creatArray(arr, 0, length - 1, bst);

        return bst;
    }

    public static void creatArray(int [] arr, int low, int high, BST<Integer, Integer> bst)
    {
        if (low == high)
        {
            bst.put(arr[low], arr[low]);
            return;
        }

        int n = (high - low);

        bst.put(arr[low + n/2], arr[low + n/2]);
        
        if (n/2 >= 1)
        {
            creatArray(arr, low, low + n/2 - 1, bst);    
        }

        creatArray(arr, low + n/2 + 1, high, bst);

    }


    public static void main(String[] args) 
    {
        int length = Integer.parseInt(args[0]);

        if (length < 0)
        {
            System.out.println("Illegal arrya length");
            return;
        }

        int [] array = new int[length];

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            array[nIndex] = nIndex;
        }

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            System.out.print(array[nIndex] +  " ");
        }

        System.out.println("\n*********************");

        BST<Integer, Integer> bst = creatArray(array);

        System.out.println(bst.keys());
        System.out.println(bst.levelOrder());


    }
}