public class Node
{
    int data;
    Node next = null;

    public Node(int ndata)
    {
        data = ndata;
    }

    

    public void append2Tail(int ndata)
    {
        Node end = new Node(ndata);

        Node current = this;

        while (current.next != null)
            current = current.next;

        current.next = end;
    }

    
    public Node deleteNode(Node head, int ndata)
    {
        Node current =  head;

        if (current.data == ndata)
        {

            head = head.next;
            return head;
        }

        while (current.next != null)
        {
            if (current.next.data == ndata)
            {
                current.next = current.next.next;
                return head;
            }

            current = current.next;
            
        }

        return head;
    }

    public String toString(Node head)
    {
        if (head == null)
            return null;
        Node current = head;
        String str = new String("(");

        while (current.next != null)
        {
            str += current.data + " -> ";
            current = current.next;
        }

        str += current.data + ")";
        
        return str;

    }
    
}
