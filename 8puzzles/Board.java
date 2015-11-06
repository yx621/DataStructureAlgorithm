import java.util.Iterator;
import java.util.NoSuchElementException;

public class Board 
{
    private int [][] board;
    private int N;
    public Board(int[][] blocks)           // construct a board from an N-by-N array of blocks
    {
        N = blocks[0].length;
        
        if (N <= 0)
            return;
        
        //seems we don't have private data definition part here, data 0 represents the empty space
        board = new int[N][N];
        
        for (int iIndex = 0; iIndex < N; iIndex++)
        {
            for (int jIndex = 0; jIndex < N; jIndex++)
            {
                board[iIndex][jIndex] = blocks[iIndex][jIndex];
            }
        }
    }
                                          // (where blocks[i][j] = block in row i, column j)
    public int dimension()                // board dimension N
    {
        return N; 
        //where is N? 
        //return board[0].length;
    }
    public int hamming()                   // number of blocks out of place
    {   
        //
        int nHamming = 0;
        
        for (int iIndex = 0; iIndex < N; iIndex++)
        {
            for (int jIndex = 0; jIndex < N; jIndex++)
            {
                if (board[iIndex][jIndex] != 0 && board[iIndex][jIndex] != iIndex*N + jIndex + 1)
                    nHamming++;
            }
        }
        
        return nHamming;
    }
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    {
        //return some thing
        int nManhattan = 0;
        
        for (int iIndex = 0; iIndex < N; iIndex++)
        {
            for (int jIndex = 0; jIndex < N; jIndex++)
            {
                //if (board[iIndex][jIndex] != 0 || board[iIndex][jIndex] != iIndex*N + jIndex + 1)
                //{
                //    nManhattan += Math.abs(board[iIndex][jIndex] - iIndex*N - jIndex - 1)%N + Math.abs(board[iIndex][jIndex] - iIndex*N - jIndex - 1)/N;
                //}
                int nTemp = board[iIndex][jIndex];
                
                if(nTemp != 0)
                {
                    //nManhattan += N - iIndex - 1 + N - jIndex - 1 - 1;
                    nManhattan += Math.abs(iIndex - (nTemp - 1)/N) + Math.abs(jIndex - (nTemp - 1)%N);
                }
            }
        }
        
        return nManhattan;
        
    }
    public boolean isGoal()                // is this board the goal board?
    {
        //some comparison
        for (int iIndex = 0; iIndex < N - 1; iIndex++)
        {
            for (int jIndex = 0; jIndex < N; jIndex++)
            {
                if (board[iIndex][jIndex] != iIndex*N + jIndex + 1)
                    return false;
            }
        }
        
        for (int jIndex = 0; jIndex < N - 1; jIndex++)
        {
            if (board[N - 1][jIndex] != (N-1)*N + jIndex + 1)
                return false;
        }
        
        if (board[N - 1][N - 1] != 0)
            return false;
        
        return true;
    }
    
    private void exch(int [][] a, int ix, int iy, int jx, int jy)
    {
        int t = a[ix][iy];
        a[ix][iy] = a[jx][jy];
        a[jx][jy] = t;
    }
    
    public Board twin()                    // a board that is obtained by exchanging two adjacent blocks in the same row
    {   
        Board twinBoard = new Board(this.board);
        //use the constructor efficiently
        for (int iIndex = 0; iIndex < N; iIndex++)
        {
            for (int jIndex = 0; jIndex < N - 1; jIndex++)
            {
                if (twinBoard.board[iIndex][jIndex] != 0 && twinBoard.board[iIndex][jIndex+1] != 0)
                {
                    exch(twinBoard.board, iIndex, jIndex, iIndex, jIndex+1);
                    return twinBoard;
                }
            }
        }
        
        return null;
    }
    
    
    public boolean equals(Object y)        // does this board equal y?
    {
        //return ?
        
        if (this == y)
            return true;
        
        if (y == null)
            return false;
        
        if(this.getClass() != y.getClass())
            return false;
        
        Board that = (Board) y;
        
        if (that.board[0].length != N)
            return false;
        
        for (int iIndex = 0; iIndex < N; iIndex++)
        {
            for (int jIndex = 0; jIndex < N; jIndex++)
            {
                if (this.board[iIndex][jIndex] != that.board[iIndex][jIndex])
                    return false;
            }
        }
        
        return true;
    }
    public Iterable<Board> neighbors()     // all neighbouring boards
    {
        //what do return
        int iIndex = 0; 
        int jIndex = 0;
        boolean bFlag = false;
        
        for (iIndex = 0; iIndex < N; iIndex++)
        {
            for (jIndex = 0; jIndex < N; jIndex++)
            {
                if (board[iIndex][jIndex] == 0)
                {
                    bFlag = true;
                    break;
                }
            }
            
            if (bFlag)
                break;
        }
        
        Stack sboard = new Stack<Board>();
        //need to keep the original board and push new board into it. so let's make a temp board;
        
        Board tBoard1 = new Board(this.board);
        Board tBoard2 = new Board(this.board);
        Board tBoard3 = new Board(this.board);
        Board tBoard4 = new Board(this.board);
        
        if (jIndex > 0)
        {
            exch(tBoard1.board, iIndex, jIndex, iIndex, jIndex - 1);
            sboard.push(tBoard1);
        }
        
        if (jIndex < N - 1)
        {
            exch(tBoard2.board, iIndex, jIndex, iIndex, jIndex + 1);
            sboard.push(tBoard2);
        }
        
        if (iIndex > 0)
        {
            exch(tBoard3.board, iIndex, jIndex, iIndex - 1, jIndex);
            sboard.push(tBoard3);
        }
        
        if (iIndex < N - 1)
        {
            exch(tBoard4.board, iIndex, jIndex, iIndex + 1, jIndex);
            sboard.push(tBoard4);
        }
        
        return sboard;
        //return  sboard.iterator();
        //all the possible 4 neighbours are in the stack now
        
    }
    
    public String toString()               // string representation of this board (in the output format specified below)
    {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                s.append(String.format("%2d ", board[i][j]));
            }
            
            s.append("\n");
        }
        
        return s.toString();
    }
    
    public static void main(String[] args) // unit tests (not graded)
    {
        //the test for the board is successful 
        for (String filename : args) 
        {
            
            // read in the board specified in the file name
            In in = new In(filename);
            int N = in.readInt();
            int[][] tiles = new int[N][N];
            for (int i = 0; i < N; i++) 
            {
                for (int j = 0; j < N; j++) 
                {
                    tiles[i][j] = in.readInt();
                }
            }

            // solve the slider puzzle
            Board initial = new Board(tiles);
            //Solver solver = new Solver(initial);
            //System.out.println(filename + ": " + solver.moves());
            System.out.println("The dimension of the board is " + initial.dimension());
            
            System.out.println(initial.toString());
            System.out.println("Is it the goal board? " + initial.isGoal());
            
            Board twin = initial.twin();
            
            System.out.println("The twiun board is\n"  + twin);
            System.out.println("Is it the goal board? " + twin.isGoal());
            
            System.out.println("all the neighbors " + twin.neighbors());
            
        }
    }
}