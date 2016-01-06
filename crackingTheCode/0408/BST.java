import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import java.util.LinkedList;
import java.util.ArrayList;

public class BST<Key extends Comparable<Key>> {
    public Node root;             // root of BST

    // private class Node {
    public class Node {
        private Key key;           // sorted by key
        private int val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        private boolean bVisit;
        private int accSum;

        public Node(Key key, int val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;

            bVisit = false;
            accSum = 0;
        }

        public void setVisit()
        {
            bVisit = true;
        }

        public void resetVisit()
        {
            bVisit = false;
        }

        public void setAcc(int acc)
        {
            accSum = acc;
        }

        public int getAcc()
        {
            return accSum;
        }

        public String toString()
        {
            return "" + val + "";
        }
    }

    public BST() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public boolean contains(Key key) {
        return get(key) != 0;
    }

    public int get(Key key) {
        return get(root, key);
    }

    private int get(Node x, Key key) {
        if (x == null) 
        {
            System.out.println("cannot get this value");
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    private Node find(Key key)
    {
        Node current = root;


        while (current != null)
        {
            int cmp = key.compareTo(current.key);
            if (cmp == 0)
                return current;

            if (cmp > 0)
                current = current.right;
            else
                current = current.left;

        }

        return current;
    }

    public void put(Key key, int val) {
        // if (val == null) {
        //     delete(key);
        //     return;
        // }
        root = put(root, key, val);
        assert check();
    }

    private Node put(Node x, Key key, int val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    } 

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

    public Key floor(Key key) {
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 

    public Key ceiling(Key key) {
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    } 

    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

    public int rank(Key key) {
        return rank(key, root);
    } 

    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }

    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    private boolean check() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }


    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.N != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    } 

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }

    public LinkedList<Key> [] createList()
    {   
        if (root == null)
            return null;
        Node current = root;
        int high = height(root);

        // LinkedList<Node> list = new LinkedList<Node>[high + 1];
        LinkedList<Key> [] list = (LinkedList<Key> []) new LinkedList[high + 1];

        for (int nIndex = 0; nIndex <= high; nIndex++)
            list[nIndex] = new LinkedList<Key>();

        Queue<Node> queues = new Queue<Node>();
        Queue<Node> queue2 = new Queue<Node>();

        queues.enqueue(current);
        // System.out.println("The height of the root is " + height(current));
        for (int nIndex = 0; nIndex <= high; nIndex++)
        {   

            // System.out.println()
            while (queues.isEmpty() == false)
            {
                Node nTemp = queues.dequeue();
                    
                if (nTemp.left != null)
                {
                    queue2.enqueue(nTemp.left);
                }

                if (nTemp.right != null)
                {
                    queue2.enqueue(nTemp.right);
                }
                
                list[nIndex].add(nTemp.key);
            }

            while (queue2.isEmpty() == false)
            {
                queues.enqueue(queue2.dequeue());
            }

        }

        return list;
    }

    public boolean isSubTree(BST<Key> tree2)
    {
        if (tree2 == null)
            return true;

        int size2 = tree2.size();
        if (this.size() < size2)
        {
            System.out.println("secontion 1 error ");
            return false;
        }

        
        
        Node start = tree2.root;
        // we have contains and find function

        if (contains(start.key) == false)
        {
            System.out.println("secontion 2 error ");
            return false;
        }

        

        Node current = find(start.key);

        int size1 = size(current);

        if (size1 < size2)
        {
            System.out.println("secontion 3 error ");
            return false;
        }


        Queue<Node> queue1 = new Queue<Node>();
        Queue<Node> queue2 = new Queue<Node>();

        queue1.enqueue(current);
        // big tree 
        queue2.enqueue(start);
        //subtree

        while(queue2.isEmpty() == false)
        {
            Node node1 = queue1.dequeue();
            Key key1 = node1.key;

            Node node2 = queue2.dequeue();
            Key key2 = node2.key;

            if (key1.compareTo(key2) != 0)
            {
                System.out.println("secontion 4 error ");
                return false;
            }

            if (node2.left != null)
            {
                if (node1.left == null)
                {
                    System.out.println("secontion 4a error ");
                    return false;
                }

                queue1.enqueue(node1.left);
                queue2.enqueue(node2.left);
            }

            if (node2.right != null)
            {
                if (node1.right == null)
                {
                    System.out.println("secontion 4b error ");
                    return false;
                }
                queue2.enqueue(node2.right);
                queue1.enqueue(node1.right);
            }

        }

        return true;

    }
    
    public void dfs(Stack<Node> stacks, Node node, int value)
    {
        if (stacks.isEmpty())
            return;

        if (node.left != null && node.left.bVisit == false)
        {
            node.left.setAcc(node.getAcc() + node.left.val);

            stacks.push(node.left);

            if (stacks.peek().getAcc() == value)
            {
                System.out.println(stacks);
            }

            dfs(stacks, node.left, value);
        }

        else if (node.right != null && node.right.bVisit == false)
        {
            node.right.setAcc(node.getAcc() + node.right.val);

            stacks.push(node.right);
            
            if (stacks.peek().getAcc() == value)
            {
                System.out.println(stacks);
            }

            dfs(stacks, node.right, value);
        }

        else
        {
            Node nTemp = stacks.pop();
            nTemp.setVisit();
            if (stacks.isEmpty() == false)
            {
                dfs(stacks, stacks.peek(), value);
            }
            
        }
    }

    public void sum2Value(int value)
    {

        Node current = root;

        if (current == null)
        {
            System.out.println("Empty tree!!!");
            return;
        }

        Queue<Node> queues = new Queue<Node>();

        queues.enqueue(current);

        while (queues.isEmpty() == false)
        {
            Node nTemp = queues.dequeue();
            // current working node
            if (nTemp.left != null)
            {
                queues.enqueue(nTemp.left);
            }

            if (nTemp.right != null)
            {
                queues.enqueue(nTemp.right);
            }
            // need to reset all the node before the processing stage

            Stack<Node> stacks = new Stack<Node>();
            // nTemp = queues.peek();

            stacks.push(nTemp);
            Node nTemp2 = stacks.peek();
            
            nTemp2.setAcc(nTemp2.val);

            if (nTemp2.getAcc() == value)
            {
                System.out.println(stacks);
            }

            dfs(stacks, nTemp2, value);

            if (queues.isEmpty() == false)
            {
                Node nTemp3 = queues.peek();

                Queue<Node> resetqueue = new Queue<Node>();

                resetqueue.enqueue(nTemp3);

                while (resetqueue.isEmpty() == false)
                {
                    nTemp3 = resetqueue.dequeue();
                    nTemp3.resetVisit();
                    nTemp3.setAcc(0);

                    if (nTemp3.left != null)
                    {
                        resetqueue.enqueue(nTemp3.left);
                    }

                    if (nTemp3.right != null)
                    {
                        resetqueue.enqueue(nTemp3.right);
                    }
                }
            }
        }

    }

    public void findSum(int sum, ArrayList<Integer> buffer)
    {
        // buffer.add(root.val);
        findSum(root, sum, buffer, 0);

    }

    public void findSum(Node head, int sum, ArrayList<Integer> buffer, int level)
    {
        if (head == null)
            return;

        int tmp = sum;

        buffer.add(head.val);

        for (int nIndex = level; nIndex > -1; nIndex--)
        {
            tmp -= buffer.get(nIndex);

            if (tmp == 0) 
                print(buffer, nIndex, level);
        }

        ArrayList<Integer> b1 = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> b2 = (ArrayList<Integer>) buffer.clone();

        if (head.left != null)
        {
            findSum(head.left, sum, b1, level + 1);
        }

        if (head.right != null)
        {
            findSum(head.right, sum, b2, level + 1);
        }


    }

    public void print(ArrayList<Integer> buffer, int nIndex, int level)
    {
        for (int mIndex = level; mIndex >= nIndex; mIndex--)
            System.out.print(buffer.get(mIndex) + " ");

        System.out.println("\n********");
    }




}
