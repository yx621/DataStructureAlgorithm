import java.util.Arrays;
public class anagram
{
    public static boolean check(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2)
            return false;

        for (int nIndex = 0; nIndex < len1; nIndex++)
        {
            if (str1.charAt(nIndex) != str2.charAt(len1 - 1 - nIndex))
                return false;
        } 

        return true;
    }
    
    public static boolean anacheck(String str1, String str2)
    {
        int length1 = str1.length();
        int length2 = str2.length();

        if (length2 != length1)
            return false;

        char [] cChar1 = new char[length1];
        char [] cChar2 = new char[length2];

        for (int nIndex = 0; nIndex < length2; nIndex++)
        {
            cChar1[nIndex] = str1.charAt(nIndex);
            cChar2[nIndex] = str2.charAt(nIndex);
        }


        Arrays.sort(cChar1);
        Arrays.sort(cChar2);

        for (int nIndex = 0; nIndex < length2; nIndex++)
        {
            if (cChar2[nIndex] != cChar1[nIndex])
                return false;
        }

        return true;

        // sort is easy to use but needs more time O(NlogN)
        // we can just sweep the 2 strings one time and then it's done. time complexity is just O(N)

    }

    public static boolean checkana(String str1, String str2)
    {
        int nlength1 = str1.length();
        int nlength2 = str2.length();

        if (nlength2 != nlength1)
            return false;

        int [] nChar = new int[256];

        for (int nIndex = 0; nIndex < 256; nIndex++)
        {
            nChar[nIndex] = 0;
        }

        for (int nIndex = 0; nIndex < nlength2; nIndex++)
        {
            char cTemp = str1.charAt(nIndex);
            nChar[cTemp]++;
        }

        for (int nIndex = 0; nIndex < nlength2; nIndex++)
        {
            char cTemp = str2.charAt(nIndex);

            if (nChar[cTemp] <=0)
                return false;

            nChar[cTemp]--;
        }

        return true;
    }


    public static void main(String[] args) 
    {
        String str1 = args[0];
        String str2 = args[1];
        boolean bResult = checkana(str2, str1);
        System.out.println("\"" + str2 + "\"" + " is the anagram of " + "\"" + str1 + "\"? " + bResult);
    }
}