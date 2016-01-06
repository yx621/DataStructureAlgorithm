public class rotate90
{
    public static void rot(int [][] mat)
    {
        int nlength1 = mat.length;
        int nlength2 = mat[0].length;

        //System.out.println(nlength1 + ", " + nlength2);

        if (nlength1 != nlength2)
        {
            System.out.println("Matrix is not square, refuse to work on it");

            return;
        }

        int [][] ans = new int[nlength2][nlength1];
        for (int nIndex = 0; nIndex < nlength1; nIndex++)
            for (int mIndex = 0; mIndex < nlength2; mIndex++)
            {
                ans[mIndex][nlength1 - 1 - nIndex] = mat[nIndex][mIndex];
            }

        for (int nIndex = 0; nIndex < nlength2; nIndex++)
        {

            for (int mIndex = 0; mIndex < nlength1; mIndex++)
            {
                System.out.print(ans[nIndex][mIndex] +  " ");
            }

            System.out.print("\n");
        }
            
    }
    
    public static void main(String[] args) 
    {
        int dimension = Integer.parseInt(args[0]);

        int [][] mat = new int[dimension][dimension];
        for (int nIndex = 0; nIndex < dimension; nIndex++)
            for (int mIndex = 0; mIndex < dimension; mIndex++)
                mat[nIndex][mIndex] = (nIndex) * dimension + (mIndex);
        

        for (int nIndex = 0; nIndex < dimension; nIndex++)
        {

            for (int mIndex = 0; mIndex < dimension; mIndex++)
            {
                System.out.print(mat[nIndex][mIndex] +  " ");
            }

            System.out.print("\n");
        }

        System.out.print("\n");

        rot(mat);
    }
}