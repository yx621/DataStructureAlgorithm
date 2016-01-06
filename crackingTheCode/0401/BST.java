import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value>
{

    private Node root;

    private class Node
    {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;
        // node number in the subtree

        public Node(Key key, Value value, int N)
        {
            this.key = key;
            this.value = value;
            this.N = N;
        }

    }


    public BST()
    {
        // empty one, do nothing
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public int size()
    {
        return size(root);
    }

    public int size(Node x)
    {
        if (x == null)
            return 0;

        return x.N;
    }


    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    public Value get(Key key)
    {
        return get(root, key);
    }

    public Value get(Node x, Key key)
    {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0)
            return x.value;

        if (cmp < 0)
            return get(x.left, key);

        else
            return get(x.right, key);
    }

    public void put(Key key, Value value)
    {
        if (value == null)
        {
            delete(key);
            return;
        }

        root = put(root, key, value);


    }

    private Node put(Node x, Key key, Value value)
    {
        if (x == null) 
            return new Node(key, value, 1);

        int cmp = key.compareTo(x.key);

        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;

        x.N = size(x.left) + size(x.right) + 1;

        return x;

    }

    public void deleteMin()
    {

        if (isEmpty())
            throw new NoSuchElementException("Tree underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x)
    {
        if (x == null)
            return null;

        if (x.left == null)
            return x.right;

        else
        {
            x.left = deleteMin(x.left);
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key)
    {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key)
    {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);

        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);

        else
        {
            if (x.left == null)
                return x = x.right;

            else if (x.right == null)
                return x = x.left;
            Node t = x;
            x = min(t.right);
            
            x.right = deleteMin(t.right);
            x.left = t.left;

        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;

    }

    public Key min()
    {
        if (isEmpty())
            throw new NoSuchElementException("call min() with empty tree");
        
        return min(root).key;
    }

    public Node min(Node x)
    {
        if (x == null)
        return null;

        if (x.left == null)
            return  x;
        return min(x.left);
    }


    public int height() 
    {
        return height(root);
    }

    private int height(Node x) 
    {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    // public boolean isBalance()
    // {
        

    //     Queue<Node> queues = new Queue<Node>();

    //     if (root == null)
    //         return true;

    //     Node current = root;

    //     queues.enqueue(current);

    //     while (queues.isEmpty() == false)
    //     {
    //         Node nTemp = queues.dequeue();
    //         if (Math.abs(height(nTemp.left) - height(nTemp.right)) > 1)
    //             return false;

    //         if (nTemp.left != null)
    //             queues.enqueue(nTemp.left);

    //         if (nTemp.right != null)
    //             queues.enqueue(nTemp.right);
    //     }

    //     return true;
        
    // }

    public int maxDepth(Node x)
    {
        if (x == null)
            return 0;

        return 1 + Math.max(maxDepth(x.left), maxDepth(x.right));

    }

    public int minDepth(Node x)
    {
        if (x == null)
            return 0;

        return 1 + Math.min(minDepth(x.left), minDepth(x.right));
    }

    public boolean isBalance()
    {
        return (maxDepth(root) - minDepth(root) <= 1);
    }

    




}