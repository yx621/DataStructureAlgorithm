public class Outcast 
{
    private WordNet wn;
    // constructor takes a WordNet object
    public Outcast(WordNet wordnet)         
    {
        if (wordnet == null)
            throw new java.lang.NullPointerException("Null pointer for wordnet");

        wn = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns)   
    {
        int length = nouns.length;

        int [] nDist = new int[length];

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            nDist[nIndex] = 0;
        }

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            for (String str : nouns)
            {
                nDist[nIndex] += wn.distance(nouns[nIndex], str);
            }
        }

        int mIndex = 0;

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            if (nDist[mIndex] < nDist[nIndex])
                mIndex = nIndex;
        }

        return nouns[mIndex];
    }

      // see test client below
    public static void main(String[] args)
    {
        /*
        WordNet wordnet = new WordNet(args[0], args[1]);
        
        Outcast outcast = new Outcast(wordnet);
        
        for (int t = 2; t < args.length; t++) 
        {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
        */
    }
}
