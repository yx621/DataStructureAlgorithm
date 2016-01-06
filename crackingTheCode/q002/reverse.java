public class reverse
{
    
    public static String rev(String str)
    {
        int length = str.length();
        String strResult = new String();

        System.out.println("The input string is " + str + " with length " + length);
        for (int nIndex = 0; nIndex < length; nIndex++) 
        {
            strResult += str.charAt(length - 1 - nIndex);
        }

        System.out.println("The reversed string is " + strResult + " with length " + strResult.length());
        return strResult;
    }

    public static void main(String[] args) 
    {
        String str = args[0];
        
        rev(str);

        
    }
}