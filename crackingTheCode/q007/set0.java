import java.util.LinkedList;
import java.util.Random;

public class set0
{
    public static class coordinate
    {
        private int horizontal;
        private int vertical;

        public coordinate()
        {
            horizontal = 0;
            vertical = 0;
        }

        public coordinate(int x, int y)
        {
            horizontal = x;
            vertical = y;
        }

        public int getX()
        {
            return horizontal;
        }

        public int getY()
        {
            return vertical;
        }
    }

    public static void setMat(int [][] mat)
    {
        int nlength1 = mat.length;
        int nlength2 = mat[0].length;

        LinkedList<coordinate> link = new LinkedList<coordinate>();

        for (int nIndex = 0; nIndex < nlength1; nIndex++)
            for (int mIndex = 0; mIndex < nlength2; mIndex++)
            {
                if (mat[nIndex][mIndex] == 0)
                {
                    coordinate cTemp = new coordinate(nIndex, mIndex);
                    link.add(cTemp);
                }
            }
        
        int nlength0 = link.size();

        for (int nIndex = 0; nIndex < nlength0; nIndex++)
        {
            int nHor = link.get(nIndex).getX();
            int nVer = link.get(nIndex).getY();

            //set the horizontal line to be 0s
            for (int mIndex = 0; mIndex < nlength2; mIndex++)
                mat[nHor][mIndex] = 0;

            //set the vertion line to be 0s
            for (int mIndex = 0; mIndex < nlength1; mIndex++)
                mat[mIndex][nVer] = 0;
        }

        for (int nIndex = 0; nIndex < nlength1; nIndex++)
        {
            for (int mIndex = 0; mIndex < nlength2; mIndex++)
            {
                System.out.print(mat[nIndex][mIndex] + " ");
            }

            System.out.print("\n");

        }


    }

    public static void main(String[] args) 
    {
        int nHori = Integer.parseInt(args[0]);
        int nVert = Integer.parseInt(args[1]);

        int [][] mat = new int [nHori][nVert];

        Random rnd = new Random();

        for (int nIndex = 0; nIndex < nHori; nIndex++)   
            for (int mIndex = 0; mIndex < nVert; mIndex++)
            {
                int nTemp = rnd.nextInt(5);
                mat[nIndex][mIndex] = nTemp;

            }

        for (int nIndex = 0; nIndex < nHori; nIndex++)
        {
            for (int mIndex = 0; mIndex < nVert; mIndex++)
            {
                System.out.print(mat[nIndex][mIndex] + " ");
            }

            System.out.print("\n");
        }

        System.out.print("\n");

        setMat(mat);
    }
}