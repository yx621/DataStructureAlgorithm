public class CommandNode
{
    public static Node common(Node x, Node y)
    {
        // each node has its own parent node

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        Node temp1 = x;
        Node temp2 = y;

        while (temp1 != null)
        {
            stack1.push(temp1);
            temp1 = temp1.parent();

        }
        // after finish, the first element for stack1 is root

        while (temp2 != null)
        {
            stack2.push(temp2);
            temp2 = temp2.parent;
        }

        // after finish, the first element for stack2 is also root

        Node nCommon = root;

        while (stack1.isEmpty() == false && stack2.isEmpty() == false)
        {
            temp1 = stack1.pop();
            temp2 = stack2.pop();

            if (temp2 == temp1)
                nCommon = temp1;
        }

        return nCommon;
    }
    public static void main(String[] args) 
    {
        
    }
}