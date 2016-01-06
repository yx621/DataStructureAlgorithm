public class Othello
{
    public class Piece
    {
        enum Type {WHITE, BLACK}

        private Type type;
        private int x, y;
        // coordinate in the board. Where is the board
        public void setType(Type type)
        {
            this.type = type;
        }

        public boolean isBlack()
        {
            return type == Type.BLACK;
        }

        public boolean isWhite()
        {
            return type == Type.WHITE; 
        }

        public Piece(Type type, int x, int y)
        {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public Type getType()
        {
            return type;
        }

        public int getX()
        {
            return x;
        }

        public int getY()
        {
            return y;
        }

    }

    private Piece [][] pieces;
    private int nBoardSize;

    public Othello()
    {

    }

    private void setGrid(int x, int y, Piece piece)
    {
        // if (null) can put
        // check the left right property
    }

    private Piece getGrid(int x, int y)
    {
        for (Piece piece : pieces)
        {
            if (piece.getX() == x && piece.getY() == y)
                return piece;
        }

        return null;
    }

    private boolean isFull()
    {
        // if piece are null, then full
    }

    public void Game()
    {
        // play the game
    }



}