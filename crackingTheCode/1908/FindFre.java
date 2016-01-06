import java.util.Hashtable;

public class FindFre
{
    public static Hashtable<String, Integer> setDict(String [] strArr)
    {
        if (strArr.length == 0)
            return null;
        
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        
        for (String word : strArr)
        {
            word = word.toLowerCase();
            if (word != "")
            {
                if (table.containsKey(word) == false)
                    table.put(word, 0);
                table.put(word, table.get(word) + 1);
                
            }
        }
        return table;
    }
    
    public static int getFre(Hashtable<String, Integer> table, String str)
    {
        if (table == null || str == null)
            return -1;
        
        str = str.toLowerCase();
        
        if (table.containsKey(str))
            return table.get(str);
        
        return 0;
    }
    
    
    public static void main(String [] args)
    {
        String inStr = args[0];
        //String str = new String[];
        //String [] str = {"I", "am", "a", "student", "in", "The", "Technion"};
        String [] str = {"I", "am", "a", "student", "in", "The", "Technion", "Haifa", "I", "am", "a", "student", "in", "University", "Haifa", "Haifa"};
        Hashtable table = setDict(str);
        
        System.out.println("The frequency for word " + inStr + " is " + getFre(table, inStr));
    }
}