import java.util.Random;

public class MatrixSum
{

    public static int[][] getSum(int [][] matrix)
    {
        int [][] sumMat = new int[matrix.length][matrix[0].length];

        int length1 = matrix.length;
        
        int length2 = matrix[0].length;

        for (int nIndex = 0; nIndex < length1; nIndex++)
        {
            for (int mIndex = 0; mIndex < length2; mIndex++)
            {
                if (nIndex == 0 && mIndex == 0)
                {
                    sumMat[nIndex][mIndex] = matrix[nIndex][mIndex];
                }

                else if (nIndex == 0)
                {
                    sumMat[nIndex][mIndex] = sumMat[nIndex][mIndex - 1] + matrix[nIndex][mIndex];
                }

                else if (mIndex == 0)
                {
                    sumMat[nIndex][mIndex] = sumMat[nIndex - 1][mIndex] + matrix[nIndex][mIndex];
                }

                else
                {
                    sumMat[nIndex][mIndex] = sumMat[nIndex - 1][mIndex] + sumMat[nIndex][mIndex - 1] - sumMat[nIndex - 1][mIndex - 1] + matrix[nIndex][mIndex] ;
                }
            }
        }

        return sumMat;

    }

    public static int computeSum(int [][] sumMat, int i1, int i2, int j1, int j2)
    {
        if (i1 == 0 && j1 == 0)
            return sumMat[i2][j2];

        else if (i1 == 0)
            return sumMat[i2][j2] - sumMat[i2][j1-1];

        else if (j1 == 0)
            return sumMat[i2][j2] - sumMat[i1-1][j2];

        else 
            return sumMat[i2][j2] - sumMat[i1 - 1][j2] - sumMat[i2][j1 - 1] + sumMat[i1-1][j1-1];
    }

    public static int getMax(int [][] matrix)
    {
        int [][] sumMat = new int[matrix.length][matrix[0].length];

        int length1 = matrix.length;
        int length2 = matrix[0].length;

        sumMat = getSum(matrix);

        int max = Integer.MIN_VALUE;

        for (int row1 = 0; row1 < length1; row1++)
            for (int row2 = row1; row2 < length1; row2++)
                for (int col1 = 0; col1 < length2; col1++)
                    for (int col2 = col1; col2 < length2; col2++)
                    {
                        max = Math.max(max, computeSum(sumMat, row1, row2, col1, col2));
                    }
        
        return max;
    }

    public static void main(String[] args) 
    {
        int length1 = Integer.parseInt(args[0]);
        int length2 = Integer.parseInt(args[1]);

        int [][] nMatrix = new int[length1][length2];
        
        Random rnd = new Random();

        for (int nIndex = 0; nIndex < length1; nIndex++)
            for (int mIndex = 0; mIndex < length2; mIndex++)
                nMatrix[nIndex][mIndex] = rnd.nextInt(11) - 5;

        System.out.println();
        for (int nIndex = 0; nIndex < length1; nIndex++)
        {
            for (int mIndex = 0; mIndex < length2; mIndex++)
            {
                System.out.print(nMatrix[mIndex][nIndex] + " ");
            }

            System.out.println();
        }

        System.out.println("The max sum of a submatrix is " + getMax(nMatrix));
            


    }
}