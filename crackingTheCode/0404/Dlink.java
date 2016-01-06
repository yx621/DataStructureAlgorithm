import java.util.LinkedList;

public class Dlink
{
    public static void main(String[] args) 
    {
        int length = Integer.parseInt(args[0]);

        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        for (int nIndex = 0; nIndex < length; nIndex++)
            bst.put(nIndex, nIndex);

        System.out.println("Tree height is " + bst.height());
        System.out.println("Tree is " + bst.keys());
        System.out.println("Tree level order is " + bst.levelOrder());
        int height = bst.height() + 1;

        LinkedList<Integer> [] list = (LinkedList<Integer> []) new LinkedList[height];

        for (int nIndex = 0; nIndex < height; nIndex++)
        {
            list[nIndex] = new LinkedList<Integer>();
        }

        list = bst.createList();

        for (int nIndex = 0; nIndex < height; nIndex++)
        {
            System.out.println(list[nIndex]);
        }

        System.out.println("*********************");

        BST<Integer, Integer> bst2 = new BST<Integer, Integer>();

        bst2.put(3, 3);
        bst2.put(1, 1);
        bst2.put(5, 5);
        bst2.put(0, 0);
        bst2.put(2, 2);
        bst2.put(4, 4);
        bst2.put(6, 6);
        bst2.put(7, 7);
        bst2.put(-1, -1);

        System.out.println("The height of the unbalance tree is "  + bst2.height());

        LinkedList<Integer> [] list2 = (LinkedList<Integer> []) new LinkedList[bst2.height() + 1];

        list2 = bst2.createList();

        for (int nIndex = 0; nIndex <= bst2.height(); nIndex++)
        {
            System.out.println(list2[nIndex]);
        }





    }
}