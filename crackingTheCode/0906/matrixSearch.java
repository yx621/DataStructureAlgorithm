public class matrixSearch
{
    // we can use a simple but not logorithm algorithm to deal with this problem
    public static boolean matSearch(int [][] mat, int element)
    {
        int row = mat.length - 1;
        int col = mat[0].length - 1;
        System.out.println("The dimension of this matrix is " + row + ", " + col);

        int currentRow = 0;
        int currentCol = col;

        while (currentRow <= row && currentCol >= 0)
        {
            if (mat[currentRow][currentCol] == element)
            {
                System.out.println("The index for number " + element + " is (" + currentRow + ", " + currentCol + ")");
                return true;
            }

            else if (mat[currentRow][currentCol] < element)
            {
                currentRow++;
            }

            else
            {
                currentCol--;
            }
        }
    
        System.out.println("No element " + element + " in the matrix");
        return false;
    } 

    public static void main(String[] args) 
    {
        int M = 3;
        int N = 5;
        int element = Integer.parseInt(args[0]);

        int [][] matrix = new int[M][N];
        for (int nIndex = 0; nIndex < M; nIndex++)
        {
            for (int mIndex = 0; mIndex < N; mIndex++)
                matrix[nIndex][mIndex] = 11*nIndex + 10*mIndex;
        }

        for (int nIndex = 0; nIndex < M; nIndex++)
        {
            for (int mIndex = 0; mIndex < N; mIndex++)
            {
                System.out.print(matrix[nIndex][mIndex] + " ");
            }

            System.out.println();
        }

        System.out.println("Find element " + element + " in matrix " + matSearch(matrix, element));
    }
}