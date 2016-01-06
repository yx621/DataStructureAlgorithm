import java.util.ArrayList;

public class ValueSum
{
    public static void main(String[] args) 
    {
        BST<Integer> bst = new BST<Integer>();

        int value = Integer.parseInt(args[0]);
        bst.put(3 ,3);
        bst.put(1 ,1);
        bst.put(5 ,5);
        bst.put(0 ,0);
        bst.put(2 ,2);
        bst.put(4 ,4);
        bst.put(6 ,6);

        System.out.println(bst.keys());
        System.out.println(bst.levelOrder());
        System.out.println("***********");

        // bst.sum2Value(value);

        ArrayList<Integer> buffer = new ArrayList<Integer>();

        bst.findSum(value, buffer);

    }
}