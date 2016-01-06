public class Addlist
{
    
    public static Node add(Node head1, Node head2)
    {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node current1 = head1;
        Node current2 = head2;
        Node nResult = new Node(0);
        int sum = 0;
        int carry = 0;

        while (current1 != null || current2 != null)
        {

            if (current1 == null)
            {
                sum = current2.data + carry;
                carry = 0;
                if (sum >= 10)
                {
                    sum = sum%10;
                    carry = 1;
                }

                nResult.append2Tail(sum);
                current2 = current2.next;
            }

            else if (current2 == null)
            {
                sum = current1.data + carry;
                carry = 0;
                if (sum >= 10)
                {
                    sum = sum%10;
                    carry = 1;
                }

                nResult.append2Tail(sum);
                current1 = current1.next;
            }

            else
            {
                sum = current1.data + current2.data + carry;
                carry = 0;
                if (sum >= 10)
                {
                    sum = sum%10;
                    carry = 1;
                }

                nResult.append2Tail(sum);
                current1 = current1.next;
                current2 = current2.next;
            }
            

        }

        if (carry == 1)
            nResult.append2Tail(carry);

        return nResult.next;
    }

    public static void main(String[] args) 
    {
        int nData1 = Integer.parseInt(args[0]);
        int nData2 = Integer.parseInt(args[1]);

        if (nData2 < 0 || nData1 < 0)
        {
            System.out.println("wrong input data");
            return;
        }

        Node data1 = new Node(0);
        Node data2 = new Node(0);

        while (nData1 > 0)
        {
            int remain = nData1%10;
            data1.append2Tail(remain);
            nData1 = nData1/10;
        }
        data1 = data1.next;
        // System.out.println("The relevant string to data1 is " + data1.toString(data1));
        while (nData2 > 0)
        {
            int remain = nData2%10;
            data2.append2Tail(remain);
            nData2 = nData2/10;
        }
        data2 = data2.next;
        System.out.println(data1);
        System.out.println(data1.next);
        Node current = data1;
        System.out.println(current == data1);
        System.out.println(current == data1.next);
        System.out.println(current.next == data1.next);
        // Node nResult = add(data1, data2);
        // System.out.println(data1.toString(data1) + " + " + data2.toString(data2) + " = " + nResult.toString(nResult));
    }
}