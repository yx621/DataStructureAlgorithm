public class wordDist
{
    public static int dis(String [] words, String word1, String word2)
    {
        int min = Integer.MAX_VALUE;
        int word1_pos = -min/2;
        int word2_pos = -min/2;
        
        int length = words.length;
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            String wordCurrent = words[nIndex];
            
            if (wordCurrent.compareTo(word1) == 0)
            {
                word1_pos = nIndex;
                if (min > word1_pos - word2_pos)
                {
                    min = word1_pos - word2_pos;
                }
            }
            
            else if (wordCurrent.compareTo(word2) == 0)
            {
                word2_pos = nIndex;
                if (min > word2_pos - word1_pos)
                {
                    min = word2_pos - word1_pos;
                }
            }
            nIndex++;
            //here there is no need to have nINdex 
            //but don't know exactly the running time to be O(1
            //using hash table? Or array list? I have no idea, how the hash table can store different Keys?
            //for the minimum difference, binary search can be used for one number and the second number using binary search
        }
        
    }
    
    
    public static void main(String [] args
    {
        
    }
}