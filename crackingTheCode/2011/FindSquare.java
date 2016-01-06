import java.util.Random;

public class FindSquare
{
    public static boolean check(int [][] matrix, int i, int j, int k)
    {
        int length = matrix.length;
        int length2 = matrix[0].length;

        if (length != length2)
        {
            System.out.println("The matrix is not square");
            return false;
        }

        // Here we have no loop, just indexs to calculate the returned value

        for (int nIndex = k; nIndex < k + i; nIndex ++)
        {
            if (matrix[j][nIndex] == 0 || matrix[j + i - 1][nIndex] == 0)
                return false;
        }

        for (int nIndex = j; nIndex < j + i; nIndex++)
        {
            if (matrix[nIndex][k] == 0 || matrix[nIndex][k + i - 1] == 0)
                return false;
        }

        return true;
    }
    
    public static void main(String[] args) 
    {
        int nSize = Integer.parseInt(args[0]);

        if (nSize <= 1)
        {
            System.out.println("Illegal input size ");
            return;
        }

        int [][] square = new int[nSize][nSize];

        Random rnd = new Random();

        for (int nIndex = 0; nIndex < nSize; nIndex++)
        {
            for (int mIndex = 0; mIndex < nSize; mIndex++)
            {
                int nTemp = rnd.nextInt(2);

                square[nIndex][mIndex] = nTemp;
            }
        }

        System.out.println();
        for (int nIndex = 0; nIndex < nSize; nIndex++)
        {
            for (int mIndex = 0; mIndex < nSize; mIndex++)
            {
                System.out.print(square[nIndex][mIndex] + " ");
            }
            System.out.println();
        }

        for (int nIndex = 0; nIndex < nSize - 1; nIndex++)
        {
            for (int j = 0; j <= nIndex; j++)
                for (int k = 0; k <= nIndex; k++)
                {
                    // the matrix length/width is 
                    if (check(square, nSize - nIndex, j, k))
                    {
                        int nBoarder = nSize - nIndex;
                        System.out.println("\nThe maximum square with 1s as boarder has size " + nBoarder);
                        return;
                    }
                }
        }

    }
}