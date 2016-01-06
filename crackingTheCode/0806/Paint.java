public class Paint
{   

    public static void fill(int [][] tile, int nIndex, int mIndex, int color)
    {
        int length = tile.length;

        tile[nIndex][mIndex] = color;

        if (nIndex > 0)
        {
            if (tile[nIndex - 1][mIndex] != color)
            {
                tile[nIndex - 1][mIndex] = color;
                fill(tile, nIndex - 1, mIndex, color);
            }
        }

        if (nIndex < length - 1)
        {
            if (tile[nIndex + 1][mIndex] != color)
            {
                tile[nIndex + 1][mIndex] = color;
                fill(tile, nIndex + 1, mIndex, color);
            }
        }

        if (mIndex > 0)
        {
            if (tile[nIndex][mIndex-1] != color)
            {
                tile[nIndex][mIndex-1] = color;
                fill(tile, nIndex, mIndex - 1, color);
            }

        }

        if (mIndex < length -1)
        {
            if (tile[nIndex][mIndex+1] != color)
            {
                tile[nIndex][mIndex+1] = color;   
                fill(tile, nIndex, mIndex+1, color);
            }
        }

    }

    public static void main(String[] args) 
    {
        int nSize = Integer.parseInt(args[0]);

        int [][] pict = new int[nSize][nSize];
        for (int nIndex = 0; nIndex < nSize; nIndex++)
            for (int mIndex = 0; mIndex < nSize; mIndex++)
                pict[nIndex][mIndex] = 0;
        
        //using 0 and 1 represent the color now
        pict[0][0] = 1;
        pict[0][1] = 1;
        pict[0][2] = 1;
        pict[1][0] = 1;
        // pict[1][2] = 1;
        pict[2][0] = 1;
        pict[2][1] = 1;
        pict[2][2] = 1;
        
        for (int nIndex = 0; nIndex < nSize; nIndex++)
        {
            for (int mIndex = 0; mIndex < nSize; mIndex++)
                System.out.print(pict[nIndex][mIndex] + " ");
            System.out.print("\n");
        }
        System.out.print("\n");
        fill(pict, 1, 1, 1);

        for (int nIndex = 0; nIndex < nSize; nIndex++)
        {
            for (int mIndex = 0; mIndex < nSize; mIndex++)
                System.out.print(pict[nIndex][mIndex] + " ");
            System.out.print("\n");
        }

    }
}