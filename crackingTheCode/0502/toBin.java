public class toBin
{
    public static void tobinary(String str)
    {
        int number = 0;
        int length = str.length();

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            char cTemp = str.charAt(nIndex);

            if (cTemp >= '0' && cTemp <= '9')
            {
                number = number*10 + (Integer)(cTemp - '0');

            }

            else
            {
                System.out.println("ERROR");
                return;
            }
        }

        System.out.println(Integer.toBinaryString(number));

    }

    public static void db2Str(String str)
    {
        if (str.contains(".") == false)
        {
            System.out.println(Integer.toBinaryString(Integer.parseInt(str)));
            return;
        }

        int nNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));

        System.out.println(str.indexOf('.') + " " + str.length());

        if (str.indexOf('.') == str.length() - 1)
        {
            System.out.println(Integer.toBinaryString(nNumber));
            return;
        }

        double dNumber = Double.parseDouble(str.substring(str.indexOf('.'), str.length()));

        System.out.println(nNumber + " " + dNumber);

        String strDouble = new String();

        if (Math.abs(dNumber) > 0.00010)
        {
            strDouble += '.';
        }
        
        while (Math.abs(dNumber) > 0.00001 && strDouble.length() < 10)
        {
            if (dNumber*2 >= 1)
            {
                dNumber = 2*dNumber - 1;
                strDouble += '1';
            }

            else if (dNumber*2 < 1)
            {
                dNumber = dNumber*2;
                strDouble += '0';
            }
        }

        System.out.println(Integer.toBinaryString(nNumber) + strDouble);
    }

    public static void main(String[] args) 
    {
        String str = args[0];
        // tobinary(str);
        db2Str(str);

    }
}