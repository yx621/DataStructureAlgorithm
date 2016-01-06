public class FindNextNode
{
    public static Node findNode(Node x)
    {
        if (x == null)
            return null;

        if (x.right != null)
        {
            Node temp = x.right;

            while (temp != null)
            {
                temp = temp.left;
            }

            return temp;
        }

        else if (x.parent.key > x.key)
        {
            return x.parent;
        }

        Node temp2 = x.parent;

        while (temp2 != null)
        {
            if (temp2.key > x.key)
                return temp2;
            temp2 = temp2.parent;
        }

        return null;
        // it's not a hard algorithm but need the relevant support of certain data structure...
        // data structure and algorihtm are never apart.
    }

    public static void main(String[] args) 
    {
        
    }
}