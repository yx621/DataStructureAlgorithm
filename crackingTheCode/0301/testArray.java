public class testArray
{
    public static void main(String[] args) 
    {        
        Array3Stack<Integer> array = new Array3Stack<Integer>();

        for (int nIndex = 0; nIndex < 15; nIndex++)
        {
            array.push(0, nIndex + 1)    ;
        }

        for (int nIndex = 0; nIndex < 15; nIndex++)
        {
            array.push(1, nIndex + 11)    ;
        }

        for (int nIndex = 0; nIndex < 15; nIndex++)
        {
            array.push(2, nIndex + 21)    ;
        }

        for (int nIndex = 0; nIndex < 15; nIndex++)
        {
            System.out.print(array.pop(0) + " ");
        }
        System.out.println("\n**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        
        for (int nIndex = 0; nIndex < 15; nIndex++)
        {
            System.out.print(array.pop(1) + " ");
        }

        System.out.println("\n**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        
        for (int nIndex = 0; nIndex < 15; nIndex++)
        {
            System.out.print(array.pop(2) + " ");
        }


    }
}