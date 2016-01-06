public class circular
{
    
    public static void loopStart(Node head)
    {
        if (head == null)
        {
            System.out.println("Empty Node/Lhink");
            return;
        }

        if (head.next == null)
        {
            System.out.println("No loop in the linked list since head next is null");
            return;   
        }

        Node fastPointer = head;
        Node slowPointer = head;

        fastPointer = head.next.next;
        slowPointer = head.next;

        while (slowPointer != fastPointer)
        {
            if (slowPointer == null || fastPointer == null)
            {
                System.out.println("No loop in the linked list since internal pointers are null");
                return;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            fastPointer = fastPointer.next;
        }

        slowPointer = head;

        while (slowPointer != fastPointer)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        System.out.println("The meet point is " + slowPointer + ", " + slowPointer.data);

        return;
    }


    public static void main(String[] args) 
    {
        Node head = new Node(0);

        int nData = Integer.parseInt(args[0]);

        for (int nIndex = 0; nIndex < 5; nIndex++)
        {
            head.append2Tail(nIndex + 1);
        }

        Node current = head;

        while (current.next != null)
        {
            current = current.next;
        }

        Node current2 = head;

        for (int nIndex = 0; nIndex < nData; nIndex++)
        {
            current2 = current2.next;
        }

        current.next = current2;
        current = head;
        loopStart(head);

    }
}