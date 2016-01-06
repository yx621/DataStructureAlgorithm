import java.util.ArrayList;

public class parenth
{
    public static ArrayList<String> getPar(int n)
    {

        ArrayList<String> arrStr = new ArrayList<String>();

        if (n == 1)
        {
            String sTemp = new String();
            sTemp = "()";
            arrStr.add(sTemp);
            return arrStr;
        }

        if (n < 1)
        {
            System.out.println("The input length is " + n + " invalid");
            return null;
        }

        ArrayList<String> arrPrev = getPar(n-1);

        for (String curStr : arrPrev)
        {
            String sTemp = new String();

            sTemp = "()" + curStr;
            if (arrStr.contains(sTemp) == false)
                arrStr.add(sTemp);

            sTemp = curStr + "()";

            if (arrStr.contains(sTemp) == false)
                arrStr.add(sTemp);

            sTemp = "(" + curStr + ")";
            if (arrStr.contains(sTemp) == false)    
                arrStr.add(sTemp);

        }

        return arrStr;

    }


    public static void main(String[] args) 
    {
        int nNumber = Integer.parseInt(args[0]);
        // System.out.println(getPar(nNumber));
        ArrayList<String> array = getPar(nNumber);
        int length = array.size();
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            System.out.println(array.get(nIndex));
        }

    }
}