public class rotation
{

    public static boolean rotEuqal(String str1, String str2)
    {
        int nlength1 = str1.length();
        int nlength2 = str2.length();

        if (nlength2 != nlength1)
            return false;

        if (str1.contains(str2))
            return true;

        char [] cChar = new char[nlength2];

        for (int nIndex = 0; nIndex < nlength2; nIndex++)
        {
            cChar[nIndex] = str2.charAt(nIndex);
        }

        for (int nIndex = 1; nIndex < nlength2 - 1; nIndex++)
        {
            String sec1 = new String();
            String sec2 = new String();

            if (nlength2 > nIndex + 1)
            {
                 sec1 = String.copyValueOf(cChar, nIndex, nlength2 - nIndex);    
            }

            else
            {
                sec1 += cChar[nIndex];
            }
            
            if (nIndex > 1)
            {
                sec2 = String.copyValueOf(cChar, 0, nIndex - 1);
            }

            else 
            {
                sec2 += cChar[nIndex-1];
            }
            
            sec1 = sec1.concat(sec2);

            if (str1.contains(sec1))
                return true;


        }

        return false;
    }

    /*
     there is a much simpler method for this functionality, 
     attach the first string to itself and then check contains the second one or not
    */

     public static boolean check(String str1, String str2)
     {
        int nlength1 = str1.length();
        int nlength2 = str2.length();

        if (nlength2 != nlength1)
            return false;

        str1 += str1;

        return str1.contains(str2);
     }

    public static void main(String[] args) 
    {
        String str1 = "waterbottlea";
        String str2 = "terbottlewaa";

        System.out.println("\"" + str1 + "\"" + "is a rotation of " + "\"" + str2 + "\"? " + rotEuqal(str1, str2));
        System.out.println("\"" + str1 + "\"" + "is a rotation of " + "\"" + str2 + "\"? " + check(str1, str2));

    }
}