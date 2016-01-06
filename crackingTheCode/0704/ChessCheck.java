public class ChessCheck
{
    // frist we need to have player object
    public abstract class PlayerBase
    {
        public abstract ChessPieceTure getTurn(Position p);
    }

    class ComputerPlayer extends PlayerBase
    {
        public ChessPieceTure getTurn(Position p)
        {
            return null;
        }

        public void setDifficulty()
        {
            // set the difficulty level
        }
        public PositionEstimator estimator;
        public PositionBackTracker backtracter;
    }

    public class HumanPlayer extends PlayerBase
    {
        public ChessPieceTure getTurn(Position p)
        {
            return null;
            // don't understand why return null in this situation
        }
    }

    public abstract class ChessPieceBase
    {
        abstract boolean canBeChecked();
        abstract boolean isSupportedCastle();
        // don't know what's the functionality of it here
    }

    public class King extends ChessPieceBase
    {
        // set the relevant functionality
    }
    public class Queen extends ChessPieceBase
    {

    }

    public class Position
    {
        ArrayList<ChessPieceBase> black;
        ArrayList<ChessPieceBase> white;
    }

    public class PositionBackTracker
    {
        public static Position getNext(Position p)
        {
            return null;
        }
    }

    public class PositionEstimator
    {
        public static PositionPotentialValue estimate(Position p)
        {
            // prediction something
        }
    }

    public abstract class PositionPotentialValue
    {
        abstract boolean lessThan(PositionPotentialValue pv);
    }

}