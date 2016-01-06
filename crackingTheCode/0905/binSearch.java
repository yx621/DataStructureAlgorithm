public class binSearch
{
    public static int search(String [] arrStr, String element)
    {
        int low = 0;
        int high = arrStr.length - 1;
        
        int mid = 0;
        while(low <= high)
        {
            mid = (low + high)/2;

            if(arrStr[mid].compareTo(element) == 0)
                return mid;

            else if (arrStr[mid].compareTo("") == 0)
            {
                while (arrStr[mid].compareTo("") == 0 && mid < high)
                {
                    mid++;
                    if (arrStr[mid].compareTo("") != 0)
                        break;
                }
                
                
                // System.out.println("The middle value here is " + mid + " with the element " + arrStr[mid]);

                if (arrStr[mid].compareTo("") == 0)
                {
                    while(arrStr[mid].compareTo("") == 0 && mid > low)
                    {
                        mid--;
                        if (arrStr[mid].compareTo("") != 0)
                            break;
                    }

                    // System.out.println("The middle2 value here is " + mid + " with the element " + arrStr[mid]);

                    
                }
            }

            if (arrStr[mid].compareTo("") == 0)
                return -1;

            if (arrStr[mid].compareTo(element) == 0)
                return mid;

            else if (arrStr[mid].compareTo(element) > 0)
            {
                high = mid - 1;
            }

            else if (arrStr[mid].compareTo(element) < 0)
            {
                low = mid + 1;
            }

        } 

        return -1;
    }
    public static void main(String[] args) 
    {
        String [] str = new String[12];

        str[0] = "at";
        for (int nIndex = 1; nIndex <= 4; nIndex++)
        {
            str[nIndex] = "";
        }

        str[5] = "ball";
        str[6] = "car";
        str[7] = "";
        str[8] = "";
        str[9] = "dad";
        str[10] = "";
        str[11] = "";

        for (int nIndex = 0; nIndex < 12; nIndex++)
        {
            System.out.println(str[nIndex]);
        }
        // System.out.println(str.length);
        System.out.println("The index for ball is " + search(str, "ball"));
        System.out.println("The index for car is " + search(str, "car"));
        System.out.println("The index for ballcar is " + search(str, "ballcar"));
        System.out.println("The index for at is " + search(str, "at"));

    }
}