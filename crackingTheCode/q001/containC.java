public class containC
{
    public static void parse(String str, char c)
    {
        int length = str.length();

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            if (str.charAt(nIndex) == c)
            {
                System.out.println("String: " + str + " contains character " + c);
                return;
            }
        }

        System.out.println("String: " + str + " doesn't contain character " + c);
    }

    public static void unique(String str)
    {
        boolean [] bChar = new boolean[256];

        // for (int nIndex = 0; nIndex < 256; nIndex++)
            // bChar[nIndex] = false;
        
        int length = str.length();

        System.out.println(length);
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            // char c = str.charAt(nIndex);
            int value = str.charAt(nIndex);

            if (bChar[value] == true)
            {   
                System.out.println(str + " is not a unique string");
                // return false;
                return;
            }
            
            bChar[value] = true;
        } 
        
        System.out.println(str + " is a unique string");
    }


    public static void main(String[] args) 
    {
        String str = args[0];

        // char c = args[1].charAt(0);

        // parse(str, c);

        unique(str);
    }
}