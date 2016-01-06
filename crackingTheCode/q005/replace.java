public class replace
{
    public static String repchar(String str)
    {
        int nlength = str.length();

        String strresult = new String();

        for (int nIndex = 0; nIndex < nlength; nIndex++)
        {
            char cTemp = str.charAt(nIndex);
            if (cTemp == ' ')
                strresult += "%20";
            else
                strresult += cTemp;
        }

        return strresult;
    }
    public static void main(String[] args) 
    {
        // String str = args[0];
        String test = "abcd efg hijk lmn";
        System.out.println("\"" + test + "\"" + " after replacement is " + repchar(test));
    }
}