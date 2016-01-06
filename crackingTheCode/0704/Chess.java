public class Chess
{
    enum Suit{pawn, knight, bishop, tower, queue, king}

    public class Board
    {
        private final int N = 8;
        // size of the board
        private Piece [] pieces = new Piece[32];
        // piece is the rules we use
        // need to initialize the board and all the pieces
        private int x;
        private int y;

        public Board()
        {
            // create the board and create all the pieces
        }

        public Piece getXY(int x, int y)
        {
            for (int nIndex = 0; nIndex < 32; nIndex++)
            {
                if (pieces[nIndex] != null)
                {
                    if (pieces[nIndex].x() == x && pieces[nIndex].y() == y)
                        return pieces[nIndex];
                }

                else 
                {
                    continue;
                }
            }
        }

        // perhaps check shoudl be written here
    }

    public class Piece
    {
        private Suit suit;
        private int x;
        private int y;
        private boolean white;
        // white or black

        // private Board board;
        // connect the piece with the board

        public Piece(Suit s, int x, int y, boolean white)
        {
            suit = s;
            this.x = x;
            this.y = y;
            this.white = white;
        }

        public void Move(int x0, int y0)
        {
            // if (this.suit == )
        }
    }

    private boolean turn;
    // white first
    private Board board;

    public Chess(Board b)
    {
        // 
    }

    public void play()
    {
        /*
          if turn = true, choose and move white
          if true = false, choose and move black 
        */
    }

    public boolean check()
    {
        // wheter it's checking or not

    }

    public boolean draw()
    {
        // decide it';'s draw or not
    }

    public boolean end()
    {
        // if turn and white can kill black --> print(white win) and return true
        // if turn == flase and black can kill white --> print (black win) and return true
    }
}