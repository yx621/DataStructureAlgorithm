// import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Queue;

public class Balance
{

    public static void main(String[] args) 
    {
        System.out.println("Hello world");
        BST<Integer, Integer> bst1 = new BST<Integer, Integer>();
        BST<Integer, Integer> bst2 = new BST<Integer, Integer>();

        bst1.put(4, 4);
        bst1.put(1, 1);
        bst1.put(6, 6);
        bst1.put(0, 0);
        bst1.put(2, 2);
        bst1.put(7, 7);
        bst1.put(5, 5);

        System.out.println("Tree 1 is Balance? " + bst1.isBalance());

        bst1.put(8, 8);
        bst1.put(3, 3);
        bst1.put(9, 9);        

        System.out.println("Tree 1 is Balance? " + bst1.isBalance());


        for (int nIndex = 0; nIndex < 3; nIndex++)
        {
            bst2.put(nIndex, nIndex);
        }

        System.out.println("Tree 2 is Balance? " + bst2.isBalance());
    }
}