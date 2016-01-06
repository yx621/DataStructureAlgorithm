import java.util.ArrayList;

public class Path
{

    public static boolean getpath(int x, int y, ArrayList<Point> current_path, int [][] grid)
    {
        Point p = new Point(x, y);

        current_path.add(p);
        System.out.println("path internally" + current_path);
        if (x == 0 && y == 0)
        {
            return true;
            // we have arrived at the destination
        }

        boolean bSucc = false;

        if (x >= 1 && grid[x - 1][y] == 0)
        {
            bSucc = getpath(x - 1, y, current_path, grid);
        }

        if (bSucc == false && y >= 1 && grid[x][y-1] == 0)
        {
            bSucc = getpath(x, y-1, current_path, grid);
        }

        if (!bSucc)
        {
            current_path.remove(p);
        }

        // System.out.println("path internally" + current_path);
        return bSucc;
    }

    public static void main(String[] args) 
    {
        ArrayList<Point> current_path = new ArrayList<Point>();
        
        int nSize = Integer.parseInt(args[0]);

        int [][] grid = new int[nSize][nSize];

        for (int nIndex = 0; nIndex < nSize; nIndex++)
            for (int mIndex = 0; mIndex < nSize; mIndex++)
                grid[nIndex][mIndex] = 0;
            // 0 means it's available;
        // grid[0][nSize-1] = 1;
        System.out.println(getpath(nSize - 1, nSize - 1, current_path, grid));

        System.out.println(current_path);


        
    }
}