public class Game
{
    private final int white = 1;
    private final int black = 2;

    private int [][] board;

    public void start()
    {
        // start the game
    }

    private int won()
    {
        if (!canGo(white) && !canGo(black))
        {
            int count = 0;

            for (int nIndex = 0; nIndex < 8; nIndex++)
            {
                for (int mIndex = 0; mIndex < 8; mIndex++)
                {
                    if (board[nIndex][mIndex] == white)
                        count++;
                    if (board[nIndex][mIndex] == black)
                        count--;
                }


            }

            if (count > 0)
                return white;
            if (count < 0)
                return black;
            return 3;
        }

        return 0;
        // the game is not finished yet
    } 


    private boolean canGo(int color)
    {
        /*
          if 1. none of his pieces are present
             2. none of his moves result in gaining new pieces
             3. board if filled up
             return false

             return true;
        */
    }

    private boolean isValid(int color, int x, int y)
    {
        // if the move is valid for the specific player
    }

    public void getMove(int color)
    {
        // throw exception if input is not valid or the coordinate don't make a valid move
        // throw new exception();
    }


    private void add(int x, int y, int color)
    {
        // add the component in the board, and change some component color is necessary
    }


    /*
      The actual game runs continuously until one wins
    */

    private void play()
    {
        printBoard();

        while (won() == 0)
        {
            boolean valid = false;
            while (!valid)
            {
                try
                {
                    getMove(black);
                    valid = true;
                }

                catch (exception e)
                {
                    System.out.println("Invalid coordinate");
                }
            }

            valid = false;

            printBoard();
            while(!valid)
            {
                try{
                    getMove(white);
                    valid = true;
                } catch (exception e){
                    System.out.println("Invalid coordinate");
                }
            }
            printBoard();
        }

        if (won() != 3)
        {
            System.out.println(won() == 1 ? "white" : "black" + "win");
        }
        else
        {
            System.out.println("It's a draw");
        }
    }
}
