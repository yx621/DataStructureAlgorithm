public class Queen8
{
    public static boolean check(int row, int [] column)
    {
        for (int nIndex = 0; nIndex < row; nIndex++)
        {
            int diff = Math.abs(column[row] - column[nIndex]);

            if (diff == 0 || diff == row - nIndex)
                return false;
        }

        return true;
    }

    static int ways = 0;
    // actually we can also have the number of combinations output
    public static void placeQueen(int row, int [] column)
    {
        // static int ways = 0;
        if (row == 8)
        {
            // print the board
            // return
            ways++;
            // for (int nIndex = 0; nIndex < 8; nIndex++)
            // {
            //     for (int mIndex = 0; mIndex < column[nIndex]; mIndex++)
            //         System.out.print("* ");
            //     System.out.print("Q ");


            //     for (int mIndex = column[nIndex] + 1; mIndex < 8; mIndex++)
            //         System.out.print("* ");

            //     System.out.print("\n");

            // }
            // System.out.println("It should have been stopped");            
            System.out.println("The number of solutions are " + ways);
            return;
        }

        for (int nIndex = 0; nIndex < 8; nIndex++)
        {
            column[row] = nIndex;

            if (check(row, column))
            {
                placeQueen(row + 1, column);
            }
        }
    }
    public static void main(String[] args) 
    {
        int [] column4Row = new int[8];

        for (int nIndex = 0; nIndex < 8; nIndex++)
            column4Row[nIndex] = 0;

        placeQueen(0, column4Row);

    }
}