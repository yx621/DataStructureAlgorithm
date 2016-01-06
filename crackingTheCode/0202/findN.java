public class findN
{


    public static int find(Node head, int nIndex)
    {
        Node current = head;

        int count = 0;

        while (current != null)
        {
            count++;
            current = current.next;
        }

        current = head;

        if (nIndex < 0 || nIndex >= count)
        {
            // System.out.println("Out of bound");
            throw new IndexOutOfBoundsException("\n***************************\nInput index is out of bound\n***************************");
        }

        for (int mIndex = 0; mIndex < count - nIndex - 1; mIndex++)
        {
            current = current.next;
        }

        return current.data;
    }

    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        Node head = new Node(0);
        head.append2Tail(1);
        head.append2Tail(2);
        head.append2Tail(3);
        head.append2Tail(4);
        head.append2Tail(5);
        head.append2Tail(6);
        head.append2Tail(7);
        head.append2Tail(8);
        head.append2Tail(9);
        head.append2Tail(10);

        System.out.println(find(head,N));
    }
}