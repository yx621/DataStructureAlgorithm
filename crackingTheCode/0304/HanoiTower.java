// import edu.princeton.cs.algs4.Stack;
import java.util.*;

public class HanoiTower
{
    public static int N;
    // N is number of elements in the hanoi Tower

    public static Stack<Integer> [] stacks = (Stack<Integer> [])new Stack[3];

    public static void init(int nElement)
    {
        N = nElement;
        for (int nIndex = 0; nIndex < 3; nIndex++)
        {
            stacks[nIndex] = new Stack<Integer>();
        }


        for (int nIndex = 0; nIndex < nElement; nIndex++)
            stacks[0].push(nElement - nIndex);

    }

    // from -- help -- to 
    public static void move(int nElement, int nF, int nH, int nD)
    {
        if (nElement > 0)
        {
            move(nElement - 1, nF, nD, nH);
            stacks[nD].push(stacks[nF].pop());
            display();
            move(nElement - 1, nH, nF, nD);
        }
    }   
    // desplay function from 
    // http://www.sanfoundry.com/java-program-implement-solve-tower-of-hanoi-using-stacks/

    public static void display()
     {
         System.out.println("  A  |  B  |  C");
         System.out.println("---------------");
         for(int i = N - 1; i >= 0; i--)
         {
             String d1 = " ", d2 = " ", d3 = " ";
             try
             {
                 d1 = String.valueOf(stacks[0].get(i));
                 // get(i) method is not regular stack operation, which is inherented from Vector.
             }
             catch (Exception e){
             }    
             try
             {
                 d2 = String.valueOf(stacks[1].get(i));
             }
             catch(Exception e){
             }
             try
             {
                 d3 = String.valueOf(stacks[2].get(i));
             }
             catch (Exception e){
             }
             System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
         }
         System.out.println("\n");         
     }

     public static void main(String[] args) 
     {

        int nElement = Integer.parseInt(args[0]);   
        init(nElement);
        display();
        move(nElement, 0, 1, 2);


         
     }



}