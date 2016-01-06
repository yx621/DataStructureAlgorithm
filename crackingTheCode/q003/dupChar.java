public class dupChar
{
    public static void checkDup(String str)
    {
        boolean [] bChar = new boolean[256];

        for (int nIndex = 0; nIndex < 256; nIndex++)
        {
            bChar[nIndex] = false;
        }

        String str2 = new String();

        int length = str.length();

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            int value = str.charAt(nIndex);
            if (bChar[value] == false)
            {
                str2 += str.charAt(nIndex);
            }

            bChar[value] = true;
        }

        System.out.println("The non-duplicable string is " + str2);
 
    }

    public static void removeDuplicates(char[] str) 
    {
        if (str == null) return;
        
        int len = str.length;
        if (len < 2) return;

        int tail = 1;

        for (int i = 1; i < len; ++i) 
        {
            int j;
            for (j = 0; j < tail; ++j) 
            {
                if (str[i] == str[j]) break;
            }
            
            if (j == tail) 
            {
                str[tail] = str[i];
                ++tail;
            }
        }
        
        str[tail] = 0;
    }

    public static void delDup(char [] cChar)
    {
        int length = cChar.length;

        if (length == 0)
            return;

        if (length == 1)
            return;

        int tail = 1;
        // int mIndex = 0;
        for (int nIndex = 1; nIndex < length; nIndex++)
        {
            for (int mIndex = 0; mIndex < nIndex; mIndex++)
            {
                if (cChar[nIndex] == cChar[mIndex])
                {
                    for (int oIndex = nIndex; oIndex < length - 1; oIndex++)
                        cChar[oIndex] = cChar[oIndex + 1];
                    
                    length = length - 1;
                    nIndex = nIndex - 1;
                    tail = tail - 1;
                    break;
                }

            }

            
            tail += 1;

        }

        cChar[tail] = 0;

    }

    public static void yongDel(char [] cChar)
    {
        int length = cChar.length;

        if (length == 0 || length == 1)
            return;

        int tail = 1;

        //when find a new element -- change [tail] to the new element and update tail++

        for (int nIndex = 1; nIndex < length; nIndex++)
        {
            int mIndex = 0;
            
            for (mIndex = 0; mIndex < tail; mIndex++)
            {
                if (cChar[mIndex] == cChar[nIndex])
                    break;
            }

            if (mIndex == tail)
            {
                cChar[tail] = cChar[nIndex];
                tail++;
            }
        }

        cChar[tail] = 0;

    }

    public static void main(String[] args) 
    {   
        String str = args[0];
        int length = str.length();
        char [] cstr = new char[length];

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            cstr[nIndex] = str.charAt(nIndex);
        }


        // checkDup(str);

        // removeDuplicates(cstr);
        // delDup(cstr);

        yongDel(cstr);
        System.out.println(cstr);
    }
}