import java.awt.Color;
import edu.princeton.cs.algs4.Picture;

public class SeamCarver 
{   
    private int nRow;
    private int nColumn;
    // we should keep the order colomn and row
    private double [][] dEnergy;
    // private Picture pPicture;
    private Picture currentPic;
    private boolean bTranspose;
    // private Color [][] cOrigin;
    // never touch it
    // step by step 
    // create a seam carver object based on the given picture
    private int calEnergy(Color c1, Color c2)
    {
        int sum = 0;
        // R G B component of the picture
        int r1 = c1.getRed();
        int r2 = c2.getRed();
        int g1 = c1.getGreen();
        int g2 = c2.getGreen();
        int b1 = c1.getBlue();
        int b2 = c2.getBlue();
        int dr = r1 - r2;
        int dg = g1 - g2;
        int db = b1 - b2;
        sum = dr*dr + dg*dg + db*db;
        return sum;
    }

    private double[][] calEnerMat(Picture picture)
    {
        // int nTempWidth = picture.width();
        // int nTempHeight = picture.height();
        int row = currentPic.height();
        int column = currentPic.width();
        double [][] dTempEner = new double[row][column];

        for (int nIndex = 0; nIndex < row; nIndex++)
            for (int mIndex = 0; mIndex < column; mIndex++)
            {
                if (nIndex == 0 || mIndex == 0 || nIndex == row - 1 || mIndex == column - 1)
                {
                    dTempEner[nIndex][mIndex] = 1000.0;
                }
                else
                {
                    int sum = 0;
                    Color color1 = currentPic.get(mIndex, nIndex - 1);
                    Color color2 = currentPic.get(mIndex, nIndex + 1);
                    sum = calEnergy(color1, color2);

                    Color color3 = currentPic.get(mIndex - 1, nIndex);
                    Color color4 = currentPic.get(mIndex + 1, nIndex);
                    sum += calEnergy(color3, color4);

                    dTempEner[nIndex][mIndex] = Math.sqrt((double) sum);
                }
            }
        return dTempEner;
    }

    public SeamCarver(Picture picture)
    {
        // don't try to change the current picture
        // pPicture = picture;
        currentPic = new Picture(picture);
        nRow = currentPic.height();
        nColumn = currentPic.width();
        dEnergy = new double[nRow][nColumn];
        dEnergy = calEnerMat(picture);
        bTranspose = false;
    }
    // current picture
    public Picture picture()
    {
        Picture pTemp = new Picture(currentPic);
        return pTemp;
        // return currentPic;
        // have current picture and don't delete it
        // this will be updated after appling the relevant algorithm
    }

    // width of current picture
    public int width()
    {
        return currentPic.width();
    }

    // height of current picture
    public int height()
    {
        return currentPic.height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y)
    {
        if (x < 0 || x >= nColumn || y < 0 || y >= nRow)
            throw new java.lang.IndexOutOfBoundsException("Energy argument is out of bound");
        return dEnergy[y][x];
        // perhaps it's stupid to store the pixel data in width and heigh
    }

    // sequence of indices for horizontal seam
    // we should have a private method for it.
    public int[] findHorizontalSeam()
    {
        int row = currentPic.height();
        int column = currentPic.width();

        // double [][] dTempArray = new double[row][column];
        double [][] dRotate = new double[column][row];

        // dTempArray = calEnerMat(currentPic);
        // need to rotate...

        for (int nIndex = 0; nIndex < row; nIndex++)
        {
            for (int mIndex = 0; mIndex < column; mIndex++)
            {
                dRotate[mIndex][nIndex] = dEnergy[nIndex][mIndex];
            }
        }
        return findVerticalSeam(dRotate);
        // return null;
    }

    // sequence of indices for vertical seam
    private int[] findVerticalSeam(double[][] dEner)
    {
        int row = dEner.length;
        int column = dEner[0].length;

        // System.out.println("\n***********Array size is " + row + ", " + column);
        double [][] dTotalPath = new double[row][column];
        int [][] edgeTo = new int[row][column];

        for (int nIndex = 0; nIndex < row; nIndex++)
            for (int mIndex = 0; mIndex < column; mIndex++)
            {
                if (nIndex == 0)
                {
                    dTotalPath[nIndex][mIndex] = dEner[nIndex][mIndex];
                }
                else
                {
                    dTotalPath[nIndex][mIndex] = Double.MAX_VALUE;
                }
                edgeTo[nIndex][mIndex] = mIndex;
            }
        
        // get the minimum weight of each node from the beginning, the last clumn stores 
        // all the relevant information
        for (int nIndex = 0; nIndex < row - 1; nIndex++)        
            for (int mIndex = 0; mIndex < column; mIndex++)
            {
                if (dTotalPath[nIndex+1][mIndex] > dTotalPath[nIndex][mIndex] + dEner[nIndex+1][mIndex])
                {
                    dTotalPath[nIndex+1][mIndex] = dTotalPath[nIndex][mIndex] + dEner[nIndex+1][mIndex];
                    edgeTo[nIndex+1][mIndex] = mIndex;
                }

                if (mIndex >= 1 && dTotalPath[nIndex+1][mIndex-1] > dTotalPath[nIndex][mIndex] + dEner[nIndex+1][mIndex-1])
                {
                    dTotalPath[nIndex+1][mIndex-1] = dTotalPath[nIndex][mIndex] + dEner[nIndex+1][mIndex-1];
                    edgeTo[nIndex+1][mIndex-1] = mIndex;
                }

                if (mIndex < column-1 && dTotalPath[nIndex+1][mIndex+1] > dTotalPath[nIndex][mIndex] + dEner[nIndex+1][mIndex+1])
                {
                    dTotalPath[nIndex+1][mIndex+1] = dTotalPath[nIndex][mIndex] + dEner[nIndex+1][mIndex+1];
                    edgeTo[nIndex+1][mIndex+1] = mIndex;
                }
            }

            int [] nArray = new int[row];
            double dMin = Double.MAX_VALUE;

            // get the end node of the algorithm and its index and value
            for (int nIndex = 0; nIndex < column; nIndex++)
            {
                double dTemp = dTotalPath[row-1][nIndex];
                if (dMin > dTemp)
                {
                    dMin = dTemp;
                    nArray[row-1] = nIndex;
                }
            }

            for (int nIndex = row - 2; nIndex >= 0; nIndex--)
            {
                nArray[nIndex] = edgeTo[nIndex+1][nArray[nIndex+1]];
            }

            return nArray;
    }

    public int[] findVerticalSeam()
    {
        int row = currentPic.height();
        int column = currentPic.width();

        // double [][] dTempArray = new double[row][column];
        // dTempArray = calEnerMat(currentPic);
        // dEnergy = calEnerMat(currentPic);
        // it's heavy calculation...
        // return findVerticalSeam(dTempArray);
        return findVerticalSeam(dEnergy);
        // return null;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam)
    {
        // perhaps we shouldn't keep the current picture element
        // forget abotu performance now
        if (seam == null)
            throw new java.lang.NullPointerException("Seam argument is null");
        if (currentPic == null)
            throw new java.lang.NullPointerException("Seam argument is null");

        int length = seam.length;
        int column = currentPic.width();
        int row = currentPic.height();

        if (length != column)
            throw new java.lang.IllegalArgumentException("The dimension of the picture and the seam is not the same");

        if (seam[0] < 0 || seam[0] >= row)
            throw new java.lang.IllegalArgumentException("The seam input is not legal");

        for (int nIndex = 1; nIndex < length; nIndex++)
        {
            if (Math.abs(seam[nIndex-1] - seam[nIndex]) > 1 || seam[nIndex] < 0 || seam[nIndex] >= row)
                throw new java.lang.IllegalArgumentException("The seam input is not legal");
        }

        Picture pTemp = rotate(currentPic);

        pTemp = removeVerticalSeam(pTemp, seam);

        currentPic = rotate(pTemp);
        dEnergy = calEnerMat(currentPic);
    }

    private Picture rotate(Picture picture)
    {
        int row = picture.height();
        int column = picture.width();

        Picture pTemp = new Picture(row, column);

        for (int nIndex = 0; nIndex < row; nIndex++)
            for (int mIndex = 0; mIndex < column; mIndex++)
            {   
                Color cTemp = picture.get(mIndex, nIndex);
                pTemp.set(nIndex, mIndex, cTemp);
            }
        
        return pTemp;
    }

    private Picture removeVerticalSeam(Picture picture, int[] seam)
    {   
        // optimize it takes time...
        // we can just remove one line
        if (seam == null || picture == null)
            throw new java.lang.NullPointerException("input argument is null");

        int length1 = seam.length;
        int row = picture.height();
        int column = picture.width();

        if (row != length1)
            throw new java.lang.IllegalArgumentException("The dimension of the picture and the seam is not the same");

        Picture pTemp = new Picture(column - 1, row);
        // int nIndex2 = 0;
        int mIndex2 = 0;

        for (int nIndex = 0; nIndex < row; nIndex++)
        {
            mIndex2 = 0;
            for (int mIndex = 0; mIndex < column; mIndex++)
            {
                if (mIndex == seam[nIndex]) 
                    continue;
                else
                {
                    Color cTemp = picture.get(mIndex, nIndex);
                    pTemp.set(mIndex2++, nIndex, cTemp);
                }
            }
        }
        // dEnergy = calEnerMat(pTemp);
        // I thnk we need to do something regarding to the energy matrix
        return pTemp;
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam)
    {
        if (seam == null)
            throw new java.lang.NullPointerException("Seam argument is null");
        int width = currentPic.width();
        if (width <= 1)
            throw new java.lang.IllegalArgumentException("The widht of the picture is less or equal to 1");
        
        int height = currentPic.height();
        int length1 = seam.length;

        if (height != length1)
            throw new java.lang.IllegalArgumentException("The dimension of seam is not coherent with picture");

        if (seam[length1-1] < 0 || seam[length1-1] >= width)
            throw new java.lang.IllegalArgumentException("The input seam format is wrong");

        for (int nIndex = 0; nIndex < length1 - 1; nIndex++)
        {
            if (Math.abs(seam[nIndex] - seam[nIndex+1]) > 1 || seam[nIndex] < 0 || seam[nIndex] >= currentPic.width())
                throw new java.lang.IllegalArgumentException("The input seam format is wrong");
        }

        currentPic = new Picture(removeVerticalSeam(currentPic, seam));
        dEnergy = calEnerMat(currentPic);
    }

    public static void main(String[] args) 
    {
        
    }
}