import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solver 
{
    private MinPQ<Node> pq;
    private MinPQ<Node> twinpq;
    
    //private Queue qboard = new Queue<Board>();
    private Stack sBoardSol = new Stack<Board>();
    private Board bTempBoard;
    private Node  solNode;
    
    private Board Initial;
    
    public Solver(Board initial) // find a solution to the initial board (using the A* algorithm)
    {
        
        if (initial == null)
            throw new java.lang.NullPointerException();
        
        pq = new MinPQ<Node>();
        twinpq = new MinPQ<Node>();
        
        Board twin = initial.twin();
        
        Node nodeInit = new Node(initial, 0, null);
        
        Node twinnode = new Node(twin, 0, null);
        
        pq.insert(nodeInit);
        twinpq.insert(twinnode);
        bTempBoard = null;
        Initial = initial;
        
    }
    
    public boolean isSolvable()            // is the initial board solvable?
    {
        if (Initial.isGoal())
            return true;
        
        if (bTempBoard != null)
            return bTempBoard.isGoal();
        
        Node nodeTop = pq.delMin();
        Node nodeToptw = twinpq.delMin();

        bTempBoard = nodeTop.getCurrentBoard();
        Node nTempNodePrev = nodeTop.getPreviousNode();
        
        Board bTempBoardtw = nodeToptw.getCurrentBoard();
        Node nTempNodetwPrev = nodeToptw.getPreviousNode();
        
        while (!bTempBoardtw.isGoal() && !bTempBoard.isGoal())
        {
            
            Iterator<Board> sboard = bTempBoard.neighbors().iterator();
            Iterator<Board> sboardtw = bTempBoardtw.neighbors().iterator();
            
            while(sboard.hasNext())
            {
                Board neighborBoard = sboard.next();
                if (nTempNodePrev == null)
                {
                    Node nTemp = new Node(neighborBoard, nodeTop.getMoves() + 1, nodeTop);
                    pq.insert(nTemp);
                }
                
                else if (!neighborBoard.equals(nTempNodePrev.getCurrentBoard()))
                {
                    //Node nTemp = new Node(neighborBoard, currentMoves, bTempBoard);
                    Node nTemp = new Node(neighborBoard, nodeTop.getMoves() + 1, nodeTop);
                    pq.insert(nTemp);
                }
                
            }
            
            while(sboardtw.hasNext())
            {
                Board neighborBoard = sboardtw.next();
                
                if (nTempNodetwPrev == null)
                {
                    Node nTemp = new Node(neighborBoard, nodeToptw.getMoves() + 1, nodeToptw);
                    twinpq.insert(nTemp);
                }
                
                else if (neighborBoard != nTempNodetwPrev.getCurrentBoard())
                {
                    //Node nTemp = new Node(neighborBoard, currentMoves, bTempBoard);
                    Node nTemp = new Node(neighborBoard, nodeToptw.getMoves() + 1, nodeToptw);
                    twinpq.insert(nTemp);
                }
            }
            
            nodeTop = pq.delMin();
            solNode = nodeTop;
            nodeToptw = twinpq.delMin();
            bTempBoard = nodeTop.getCurrentBoard();
            nTempNodePrev = nodeTop.getPreviousNode();
            bTempBoardtw = nodeToptw.getCurrentBoard();
            nTempNodetwPrev = nodeToptw.getPreviousNode();
        }
        
        return bTempBoard.isGoal();
        
    }
    
    public int moves() // min number of moves to solve initial board; -1 if unsolvable
    {
        if (Initial.isGoal())
            return 0;
        
        if (isSolvable())
            return solNode.getMoves();
        
        return -1;
        
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
        if (Initial.isGoal())
        {
            sBoardSol.push(Initial);
            return sBoardSol;
        }
        
        if(isSolvable())
        {
            Node currentNode = solNode;
            
            while (currentNode != null)
            {
                sBoardSol.push(currentNode.getCurrentBoard());
                currentNode = currentNode.getPreviousNode();
            }
            
            return sBoardSol;
        }
        
        
        return null;
    }
    
    
    private class Node implements Comparable<Node>
    {
        private Board currentBoard;
        private Node previousNode;
        private int nMoves;
        
        public Node(Board boarda, int moves, Node pNode)
        {
            currentBoard = boarda;
            previousNode = pNode;
            nMoves = moves;
        }
        
        public Board getCurrentBoard()
        {
            return currentBoard;
        }
        
        public Node getPreviousNode()
        {
            return previousNode;
        }
        
        public int getMoves()
        {
            return nMoves;
        }
        
        public int compareTo(Node that)
        {
            final int nconst = 1;
            
            return (nconst*this.getCurrentBoard().manhattan() - nconst*that.getCurrentBoard().manhattan() + this.nMoves - that.nMoves);
        }
        
    }
    
    public static void main(String[] args) // solve a slider puzzle (given below)
    {
        
    }
    
    
    
}