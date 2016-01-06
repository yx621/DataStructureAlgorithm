public class NumberParse
{
    
    public static String num2String(int nNumber)
    {
        String str = new String();
        
        int length = 1;
        int factor = 10;
        
        while (factor < nNumber)
        {
            length++;
            factor = factor*10;
            
        }
        
        String [] wordArr1 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String [] wordArr11 = {"", "Elven ", "Twelve ", "Thirteen ", "Forteen " , "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Ninteen "};
        String [] wordArr10 = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String [] wordArr100 = {"", "Hundred ", "Thousand "};
        
        int nTemp = 0;
        
        if (nNumber == 0)
        {
            str = "Zero";
            return str;
        }
        
        if (length > 3 && length%2 == 0)
        {
            length++;
        }
        
        //need a temp factor
        int nTempFactor = 1;
        
        for (int nIndex = 0; nIndex < length - 2; nIndex++)
        {
            nTempFactor = nTempFactor*10;
            //10^(length - 2)
        }
        
        do
        {
            if (length > 3)
            {
                nTemp = nNumber/nTempFactor;
            
                if (nTemp/10 == 1 && nTemp%10 != 0)
                {
                    str += wordArr11[nTemp%10];
                }
                else
                {
                    str += wordArr10[nTemp/10];
                    str += wordArr1[nTemp%10];
                }
                
                if (nTemp != 0)
                {
                    str += wordArr100[length%3];
                }
                
                nNumber = nNumber%nTempFactor;
                nTempFactor = nTempFactor/100;
                length = length - 2;
            }
            
            else
            {
                
                str += wordArr1[nNumber/100];
                if (nNumber/100 >= 1)
                {
                    str += wordArr100[1];
                }
                
                nNumber = nNumber%100;
                
                if (nNumber == 0)
                {
                    return str;
                }
                
                if (nNumber/10 == 1 && nNumber%10 != 0)
                {
                    if (str.isEmpty() == false)
                    {
                        str += "and ";
                    }
                    str += wordArr11[nNumber%10];
                    return str;
                }
                
                else
                {
                    if (str.isEmpty() == false)
                    {
                        str += "and ";
                    }
                    
                    str += wordArr10[nNumber/10];
                    str += wordArr1[nNumber%10];
                }
                
                length = 0;
                
            }
        }while(length > 0);
        
        return str;
        
        
    }
    public static void main(String [] args)
    {
        int number = Integer.parseInt(args[0]);
        
        System.out.println(num2String(number));
    }
}