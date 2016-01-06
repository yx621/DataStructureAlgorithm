public class Sub
{
    public static void main(String[] args) 
    {
        BST<Integer, Integer> tree1 = new BST<Integer, Integer>();

        BST<Integer, Integer> tree2 = new BST<Integer, Integer>();

        tree1.put(3, 3);
        tree1.put(1, 1);
        tree1.put(5, 5);
        tree1.put(0, 0);
        tree1.put(2, 2);
        tree1.put(4, 4);
        // tree1.put(6, 6);
        // tree1.put(2, 2);
        // tree1.put(1, 1);
        // tree1.put(3, 3);

        System.out.println(tree1.levelOrder());

        tree2.put(5, 5);        
        // tree2.put(4, 4);        
        tree2.put(6, 6);        
        
        // tree2.put(1, 1);
        // tree2.put(2, 2);
        // tree2.put(3, 3);

        System.out.println(tree2.levelOrder());

        System.out.println("Tree1 contains tree2? " + tree1.isSubTree(tree2));


    }
}