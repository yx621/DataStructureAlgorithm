public class EnglishPrase
{
    public static String parse(int nNumber)
    {
        int factor = 100000;
        //the maximum number is 999, 999
        
        String str = new String();
        
        if (nNumber >= 1000000 || nNumber < 0)
        {
            System.out.println("Illegal input number");
            return str = "not valid";
        }
        
        if (nNumber == 0)
        {
            return str = "Zero";
        }
        
        for (int nIndex = 6; nIndex > 0; nIndex--)
        {
            int nTemp = nNumber/factor;
            nNumber = nNumber%factor;
            factor = factor/10;
            if (nTemp != 0)
            {
                switch(nTemp)
                {
                    case 1: 
                        str += "One";
                        break;
                    case 2:
                        str += "Two";
                        break;
                    case 3:
                        str += "Three";
                        break;
                    case 4:
                        str += "Four";
                        break;
                    case 5:
                        str += "Five";
                        break;
                    case 6:
                        str += "Six";
                        break;
                    case 7:
                        str += "Seven";
                        break;
                    case 8:
                        str += "Eight";
                        break;
                    case 9:
                        str += "Nine";
                        break;
                    case 0:
                        str += "Zero"; 
                        break;
                    default:
                        str += "Zero";
                        break;
                }
                
                switch(nIndex)
                {
                    case 6:
                        str += " Hundred Thousand ";
                        break;
                    case 5:
                        str += "ty ";
                        break;
                    case 4: 
                        str += " Thousand ";
                        break;
                    case 3:
                        str += " Hundred ";
                        break;
                    case 2:
                        str += "ty ";
                        break;
                    case 1: 
                        break;
                    default:
                        break;
                }
                
            }
            
            
        }
        
        return str;
        
    }
    public static void main(String [] args)
    {
        int number = Integer.parseInt(args[0]);
        System.out.println(parse(number));
    }
}