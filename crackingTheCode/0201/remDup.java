import java.util.LinkedList;

public class remDup
{
    public static Node delDup(Node head)
    {
        Node current = head;

        if (head == null)
        {
            System.out.println("Input node is empty");
            return null;
        }

        Node head2 = new Node(head.data);

        //current = head;

        while (current != null)
        {
            Node temp = head2;

            while (temp.next != null)
            {
                if (temp.next.data == current.data)
                    break;
                temp = temp.next;

            }

            if (temp.next == null)
                temp.next = new Node(current.data);

            current = current.next;
        }

        return head2.next;

    }

    public static void delDup2(Node head)
    {
        if (head == null)
            return;

        if (head.next == null)
            return;

        Node previous = head;

        Node current = head.next;

        int count = 1;

        while (current != null)
        {
            Node temp = head;
            int nCount = 0;

            while (nCount < count)
            {

                if (current.data == temp.data)
                {
                    current = current.next;
                    previous.next = current;
                    break;
                }

                temp = temp.next;
                nCount++;
            }

            if (nCount == count)
            {
                previous = previous.next;
                current = current.next;
                count++;
            }

        }



    }

    public static void main(String[] args) 
    {
        Node head = new Node(1);

        head.append2Tail(0);
        head.append2Tail(0);
        head.append2Tail(1);

        head.append2Tail(2);
        head.append2Tail(2);
        head.append2Tail(3);
        head.append2Tail(3);
        head.append2Tail(4);
        head.append2Tail(4);
        head.append2Tail(4);
        head.append2Tail(4);
        head.append2Tail(4);
        head.append2Tail(4);
        head.append2Tail(4);
        head.append2Tail(3);
        head.append2Tail(2);
        head.append2Tail(1);
        head.append2Tail(0);
        head.append2Tail(1);

        Node current = head;
        
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("--------------");
        System.out.println(head.data);
        System.out.println("--------------");
        System.out.println("--------------");

        delDup2(head);
        current = head;
        System.out.println("**************");
        System.out.println("**************");
        System.out.println("**************");
        System.out.println("**************");
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }



    }
}