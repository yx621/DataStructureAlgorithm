public class delNode
{
    public static void del(Node head, Node deling)
    {
        Node current = head;

        if (head == null || deling == null)
            return;
        if (current.data == deling.data)
        {   

            System.out.println("head.next.data is " + head.next.data);
            head = head.next; 
            System.out.println("head.data is " + head.data);
            System.out.println("Enter the first comparison");
            return;
        }

        

        while (current.next != null)
        {
            if (current.next.data == deling.data)
            {
                current.next = current.next.next;
                System.out.println("Enter the second comparison");
                return;
            }

            current = current.next;
        }



    }


    public static void main(String[] args) 
    {
        Node head = new Node(0);
        int nTest = Integer.parseInt(args[0]);

        for (int nIndex = 0; nIndex < 10; nIndex++)
        {
            head.append2Tail(nIndex+1);
        }

        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("\n**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        Node test = new Node(nTest);

        del(head, test);

        current = head;

        while (current != null)
        {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("\n**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        


    }
}