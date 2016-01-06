import java.util.ArrayList;


public class SubSet
{
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
    {
        ArrayList<ArrayList<Integer>> allsubsets;
        // index should be the size of the set
        if (set.size() == index)
        {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
            // add the empty set
        }

        else
        {
            allsubsets = getSubsets(set, index + 1);
            // don't understand it...
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> subset : allsubsets)
            {
                ArrayList<Integer> newsubsets = new ArrayList<Integer>();
                newsubsets.addAll(subset);
                newsubsets.add(item);
                moresubsets.add(newsubsets);
            }

            allsubsets.addAll(moresubsets);
        }

        return allsubsets;
    } 

    public static ArrayList<String> getSub(int nSize)
    {
        long setSize = 1;
        ArrayList<String> array = new ArrayList<String>();


        for (int nIndex = 0; nIndex < nSize; nIndex++)
        {
            setSize = 2*setSize;
        }

        String str = new String();

        for (long mIndex = 0; mIndex < setSize; mIndex++)
        {
            
            str = Long.toBinaryString(mIndex);

            if (str.length() < nSize)
            {
                String sTemp = new String();    

                for (int oIndex = 0; oIndex < nSize - str.length(); oIndex++)
                    sTemp += '0';

                str = sTemp + str;
            }
            array.add(str);
        }
        // make sure we can get the output to be the same. should be set, not just binary strings
        return array;

    }
    public static void main(String[] args) 
    {
        // ArrayList<Integer> array = new ArrayList<Integer>();

        // for (int nIndex = 0; nIndex < 4; nIndex++)
        // {
        //     array.add(nIndex);
        // }

        // System.out.println("The original array is " + array);

        // System.out.println("The corresponding subsets are " + getSubsets(array, 0));

        int nSize = Integer.parseInt(args[0]);
        
        ArrayList<String> array = getSub(nSize);

        for (int nIndex = 0; nIndex < array.size(); nIndex++)
        {
            System.out.print(array.get(nIndex) + " ");

            if ((nIndex + 1)%8 == 0)
                System.out.println();
        }

    }  
}