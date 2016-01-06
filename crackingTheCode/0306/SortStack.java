import java.util.ArrayList;
import java.util.Stack;


public class SortStack
{
    public static ArrayList sort(Stack<Integer> stacks)
    {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();

        while (stacks.isEmpty() == false)
        {   
            
            if (arraylist.isEmpty())
            {
                arraylist.add(stacks.pop());
            }

            else
            {
                boolean flag = false;
                for (int nIndex = 0; nIndex < arraylist.size(); nIndex++)
                {

                    if (stacks.peek() <= arraylist.get(nIndex))
                    {
                        arraylist.add(nIndex, stacks.pop());
                        flag = true;
                        break;
                    }
                }

                if (flag == false)
                {
                    arraylist.add(stacks.pop());
                }

            }
        }

        return arraylist;
    }

    public static void sort1(Stack<Integer> stacks)
    {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();

        while (stacks.isEmpty() == false)
        {   
            
            if (arraylist.isEmpty())
            {
                arraylist.add(stacks.pop());
            }

            else
            {
                boolean flag = false;
                for (int nIndex = 0; nIndex < arraylist.size(); nIndex++)
                {

                    if (stacks.peek() <= arraylist.get(nIndex))
                    {
                        arraylist.add(nIndex, stacks.pop());
                        flag = true;
                        break;
                    }
                }

                if (flag == false)
                {
                    arraylist.add(stacks.pop());
                }

            }
        }

        // return arraylist;   

        for (int nIndex = 0; nIndex < arraylist.size(); nIndex++)
        {
            stacks.push(arraylist.get(nIndex));
        }

        // return stacks;
    }

    public static Stack sort2(Stack<Integer> stacks)
    {
        Stack<Integer> rstack = new Stack<Integer>();

        while (stacks.isEmpty()== false)
        {
            int nTemp = stacks.pop();

            while (rstack.isEmpty() == false && rstack.peek() > nTemp)
            {
                stacks.push(rstack.pop());
            }

            rstack.push(nTemp);
        }

        return rstack;
    }

    /*
      it's the shortest verison
      Need to be clear at the interview site. Which function can be useful, which is not
      Perhaps you cannot use arraylist and if just stack is available what can you do?
    */

    public static void main(String[] args) 
    {
        Stack<Integer> stacks = new Stack<Integer>();

        for (int nIndex = 0; nIndex < 5; nIndex++)
        {
            stacks.push(15 - nIndex);
        }

        for (int nIndex = 0; nIndex < 5; nIndex++)
        {
            stacks.push(nIndex);
        }

        System.out.println(stacks);
        // ArrayList<Integer> arrlist = new ArrayList<Integer>();
        // arrlist = sort(stacks);

        // System.out.println(arrlist);
        // sort1(stacks);
        System.out.println(sort2(stacks));
    }
}