import java.util.ArrayList;

public class PermString
{
    public static ArrayList<String> perm(String str)
    {   
        ArrayList<String> arrStr = new ArrayList<String>();
        int length = str.length();
        if (length <= 1)
        {
            arrStr.add(str);
            return arrStr;
        }

        char c0 = str.charAt(0);

        String substr = str.substring(1, length);
        ArrayList<String> subArray = perm(substr);

        for (String subst : subArray)
        {
            int sublenghth = subst.length();
            String sTemp = new String();
            sTemp = c0 + subst;
            
            if (arrStr.contains(sTemp) == false)
                arrStr.add(sTemp);

            for (int nIndex = 1; nIndex <= sublenghth - 1; nIndex++)
            {
                String piece1 = new String();
                String piece2 = new String();
                piece1 = subst.substring(0, nIndex);
                piece2 = subst.substring(nIndex, sublenghth);
                sTemp = piece1 + c0 + piece2;
                if (arrStr.contains(sTemp) == false)
                    arrStr.add(sTemp);
            }

            sTemp = subst + c0;

            if (arrStr.contains(sTemp) == false)
                arrStr.add(sTemp);
        }

        return arrStr;

    }

    public static void main(String[] args) 
    {
        String str = args[0];

        System.out.println(perm(str));
    }
}