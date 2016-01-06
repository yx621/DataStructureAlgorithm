import java.util.Arrays;
import java.util.ArrayList;

public class Tower
{

    private static class People implements Comparable<People>
    {
        private int weight;
        private int height;

        public People()
        {
            // weight
        }

        public People(int w, int h)
        {
            weight = w;
            height = h;
        }

        public int compareTo(People that)
        {
            if (this.weight > that.weight)
                return 1;

            else if (this.weight < that.weight)
                return -1;

            else if (this.height > that.height)
                return 1;
            else if (this.height < that.height)
                return -1;

            return 0;
        }

        public int getWeight()
        {
            return weight;
        }

        public int getHeight()
        {
            return height;
        }

        public String toString()
        {
            return "(" + weight + ", " + height + ")";
        }

        public boolean isBefore(People that)
        {
            return (this.getWeight() < that.getWeight() && this.getHeight() < that.getHeight());
        }
        // public boolean 
        // write the isBefore method (the book doesn't always guarantee right solution)
    }

    public static ArrayList<People> maximumSequence(ArrayList<People> seq1, ArrayList<People> seq2)
    {
        return seq1.size() > seq2.size() ? seq1 : seq2;

    }

    public static void getSolution(int times, ArrayList<People>[] solution, People [] items)
    {
        ArrayList<People> item = new ArrayList<People>();
        // System.out.println("Item initial size is " + item.size());
        if (times == 0)
        {
            // item = new ArrayList<People>();
            // items stands for the maximum contains this index
            item.add(items[0]);
            solution[0] = item;
            return;
        }

        for (int nIndex = times - 1; nIndex >= 0; nIndex--)
        {
            People pTemp = solution[nIndex].get(solution[nIndex].size() - 1);
            // System.out.println("internal node " + pTemp);
            if (pTemp.isBefore(items[times]))
            {
                if (item.size() < solution[nIndex].size() + 1)
                {
                    // System.out.println("The 0th solution before the adding " + solution[0]);
                    // item = solution[nIndex];
                    for (People one : solution[nIndex])
                    {
                        item.add(one);
                    }

                    item.add(items[times]);
                    // System.out.println("The 0th solution after the adding " + solution[0]);
                }
            }
        }

        if (item.size() == 0)
        {
            item.add(items[times]);
        }

        solution[times] = item;

    }

    public static ArrayList<People> maxSeq;

    public static void main(String[] args) 
    {
        ArrayList<People> maxSeq = new ArrayList<People>();
        ArrayList<People> [] solutionArray = (ArrayList<People> []) new ArrayList[5];
        People [] peoples = (People [])new People[5];
        peoples[0] = new People(60, 70);
        peoples[1] = new People(70, 90);
        peoples[2] = new People(65, 100);
        peoples[3] = new People(80, 100);
        peoples[4] = new People(75, 95);
        

        for (int nIndex = 0; nIndex < 5; nIndex++)
            System.out.println(peoples[nIndex] + " ");

        System.out.println("****************");
        System.out.println("****************");
        System.out.println("****************");

        Arrays.sort(peoples);
        
        for (int nIndex = 0; nIndex < 5; nIndex++)
            System.out.println(peoples[nIndex] + " ");

        System.out.println("****************");
        System.out.println("****************");
        System.out.println("****************");


        for (int nIndex = 0; nIndex < 5; nIndex++)
        {
            getSolution(nIndex, solutionArray, peoples);
        }

        // maxSeq = solutionArray[0];
        // System.out.println("****************");
        // System.out.println("****************");
        // System.out.println("****************");

        for (int nIndex = 0; nIndex < 5; nIndex++)
        {   
            System.out.println(solutionArray[nIndex]);            
            if (solutionArray[nIndex].size() > maxSeq.size())
                maxSeq = solutionArray[nIndex];
        }

        System.out.println("****************");
        System.out.println("****************");
        System.out.println("****************");

        System.out.println(maxSeq);
    }
}