import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.In;
// import java.util.ArrayList;

public class BaseballElimination
{
    private int nTeams;
    private String [] strTeams;
    private FlowNetwork netwrok;
    private int [][] nGames;
    private int [] nWins;
    private int [] nLoses;
    private int [] nRemains;
    private boolean [] bEliminated;
    private Queue<String> qTeams;
    private boolean bTrival;
    private boolean bNonTrival;
    private Queue<String> [] arrQueue;
    private String sTop;
    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename)
    {
        In in1 = new In(filename);
        nTeams = in1.readInt();
        // System.out.println("The number of teams is " + nTeams);
        strTeams = new String[nTeams];
        nWins = new int[nTeams];
        nLoses = new int[nTeams];
        nRemains = new int[nTeams];
        nGames = new int[nTeams][nTeams];
        bEliminated = new boolean[nTeams];
        qTeams = new Queue<String>();
        bTrival = false;
        bNonTrival = false;
        arrQueue = (Queue<String> [])new Queue[nTeams];

        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            if (!in1.hasNextLine())
                throw new java.lang.IllegalArgumentException("The input file is empty, not valid input");
            String sTemp = in1.readString();
            strTeams[nIndex] = sTemp;
            qTeams.enqueue(sTemp);
            nWins[nIndex] = in1.readInt();
            nLoses[nIndex] = in1.readInt();
            nRemains[nIndex] = in1.readInt();

            for (int mIndex = 0; mIndex < nTeams; mIndex++)
                nGames[nIndex][mIndex] = in1.readInt();
        }
    }

    // number of teams
    public int numberOfTeams()
    {
        return nTeams;
    }

    // all teams
    public Iterable<String> teams()
    {
        return qTeams;
        // return null;
    }

    // number of wins for given team
    public int wins(String team)
    {
        if (team == null)
            throw new java.lang.NullPointerException("input to the wins function is null");

        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            if (team.equals(strTeams[nIndex]))
                return nWins[nIndex];
        }

        throw new java.lang.IllegalArgumentException("no such team exist");
        // return 0;
    }

    // number of losses for given team
    public int losses(String team)
    {
        if (team == null)
            throw new java.lang.NullPointerException("input to the loses function is null");

        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            if (team.equals(strTeams[nIndex]))
                return nLoses[nIndex];
        }

        throw new java.lang.IllegalArgumentException("no such team exist");
        // return 0;
    }
    
    // number of remaining games for given team
    public int remaining(String team)
    {
        if (team == null)
            throw new java.lang.NullPointerException("input to the remaining function is null");

        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            if (team.equals(strTeams[nIndex]))
                return nRemains[nIndex];
        }

        throw new java.lang.IllegalArgumentException("no such team exist");

        // return 0;
    }


    // number of remaining games between team1 and team2
    public int against(String team1, String team2)
    {
        if (team1 == null || team2 == null)
            throw new java.lang.NullPointerException("Null pointer input to against function");

        if (team1.equals(team2))
            return 0;
        boolean bFlag1 = false;
        boolean bFlag2 = false;
        int nTeam1 = 0;
        int nTeam2 = 0;

        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            if (!bFlag1 && strTeams[nIndex].equals(team1))
            {
                nTeam1 = nIndex;
                bFlag1 = true;
            }

            if (!bFlag2 && strTeams[nIndex].equals(team2))
            {
                nTeam2 = nIndex;
                bFlag2 = true;
            }

            if (bFlag2 && bFlag1)
                break;

        }

        if (!bFlag1 || !bFlag2)
            throw new IllegalArgumentException("The input team name is illegal");
        return nGames[nTeam1][nTeam2];
    }
    
    // is given team eliminated?
    public boolean isEliminated(String team)
    {
        if (team == null)
            throw new NullPointerException("The input to the Eliminate function is Null");

        if (!bNonTrival)
            nonTrivialEliminate();

        int nTemp = -1;
        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            if (strTeams[nIndex].equals(team))
            {
                nTemp = nIndex;
                break;
            }
        }

        if (nTemp == -1)
            throw new IllegalArgumentException("The input string is not found in the teams");

        return bEliminated[nTemp];
    }

    private void trivalEliminate()
    {
        // no parameter, just for internal use
        if (!bTrival)
        {
            int maxScore = 0;

            for (int nIndex = 0; nIndex < nTeams; nIndex++)
            {
                if (maxScore < nWins[nIndex])
                {
                    maxScore = nWins[nIndex];
                    sTop = new String(strTeams[nIndex]);
                }
            }

            for (int nIndex = 0; nIndex < nTeams; nIndex++)
            {
                if (nWins[nIndex] + nRemains[nIndex] < maxScore)
                    bEliminated[nIndex] = true;
            }

            bTrival = true;    
        }
        
    }

    private void nonTrivialEliminate()
    {
        // I think all the work should be done at the constructor
        // for the certificate and isEliminate, just read relevant data is enough

        if (!bTrival)
        {
            trivalEliminate();
        }
        
        // for (int iii = 0; iii < nTeams; iii++)
        // {
        //     System.out.println(nWins[iii]  + " " + nLoses[iii]  + " " + nRemains[iii]);
        // } 
        // System.out.println();
        // for (int iii = 0; iii < nTeams; iii++)
        // {
        //     for (int jjj = 0; jjj < nTeams; jjj++)
        //     {
        //         System.out.print(nGames[iii][jjj] + " ");
        //     }
        //     System.out.print(bEliminated[iii]);
        //     System.out.println();
        // }

        // System.out.println("The top team is " + sTop + "WIth team number " + nTeams);

        int nNodes = nTeams*nTeams + nTeams + 2;
        // 
        // System.out.println("Node number for the flow is " + nNodes);
        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            // arrQueue[nIndex] = new Queue<String>();

            if (bEliminated[nIndex])
            {
                arrQueue[nIndex] = new Queue<String>();
                arrQueue[nIndex].enqueue(sTop);
            }

            else
            {
                FlowNetwork fNetwork = new FlowNetwork(nNodes);
                boolean bqFlag = false;
                // construct the flow and run the FF algorithm
                // for (int m1Index = 0; m1Index < nTeams && m1Index != nIndex && !bEliminated[m1Index]; m1Index++)
                for (int m1Index = 0; m1Index < nTeams; m1Index++)
                {
                    if (m1Index == nIndex || bEliminated[m1Index] == true)
                        continue;

                    // if (m1Index == nIndex)
                    //     continue;

                    // for (int m2Index = m1Index+1; m2Index < nTeams && m2Index != nIndex && !bEliminated[m2Index]; m2Index++)
                    for (int m2Index = m1Index+1; m2Index < nTeams; m2Index++) 
                    {
                        if (m2Index == nIndex || bEliminated[m2Index] == true)
                            continue;

                        // if (m2Index == nIndex)
                        //     continue;

                        if (nGames[m1Index][m2Index] > 0)
                        {   
                            // System.out.println("****" + m1Index + " " + m2Index + "****");
                            // System.out.println(nGames[m1Index][m2Index]);
                            // System.out.println("**********************");

                            int nCurrentNode = m1Index*nTeams + m2Index + nTeams + 2;
                            FlowEdge eTemp = new FlowEdge(0, nCurrentNode, (double)nGames[m1Index][m2Index]);
                            fNetwork.addEdge(eTemp);
                            FlowEdge e1 = new FlowEdge(nCurrentNode, m1Index+1, Double.MAX_VALUE);
                            FlowEdge e2 = new FlowEdge(nCurrentNode, m2Index+1, Double.MAX_VALUE);
                            fNetwork.addEdge(e1);
                            fNetwork.addEdge(e2);
                        }
                    }
                }

                for (int mIndex = 0; mIndex < nTeams; mIndex++)
                {
                    if (mIndex == nIndex || bEliminated[mIndex] == true)
                        continue;

                    double dCapacity = nWins[nIndex] + nRemains[nIndex] - nWins[mIndex];
                    // System.out.print(dCapacity + " ");
                    FlowEdge eTemp = new FlowEdge(mIndex+1, nTeams+1, dCapacity);
                    fNetwork.addEdge(eTemp);
                } 
                // System.out.println();

                FordFulkerson ff = new FordFulkerson(fNetwork, 0, nTeams+1);

                // all are full then not eliminateted
                boolean [] bTempFlag = new boolean[nTeams];
                for (int mIndex = 0; mIndex < nTeams; mIndex++)
                    bTempFlag[mIndex] = false;

                // perhaps should use isCut function
                
                /*

                for (FlowEdge eTemp : fNetwork.adj(0))
                {
                    int nCurrentNode = eTemp.to();
                    nCurrentNode = nCurrentNode - nTeams - 2;

                    int mAxis = nCurrentNode/nTeams;
                    int nAxis = nCurrentNode%nTeams;

                    System.out.println(mAxis + " " + nAxis + " " + eTemp.capacity() + " " + eTemp.flow() + "********");
                    System.out.println(strTeams[nIndex]);
                    
                    if (eTemp.capacity() - eTemp.flow() > 0.000000001)
                    {
                        

                        bEliminated[nIndex] = true;

                        if (bTempFlag[mAxis] == false)
                        {
                            bTempFlag[mAxis] = true;
                            arrQueue[nIndex].enqueue(strTeams[mAxis]);
                        }

                        if (bTempFlag[nAxis] == false)
                        {
                            bTempFlag[nAxis] = true;
                            arrQueue[nIndex].enqueue(strTeams[nAxis]);
                        }
                    }
                }
                */  

                for (FlowEdge eTemp : fNetwork.adj(0))
                {
                    int nCurrentNode = eTemp.to();
                    if (ff.inCut(nCurrentNode))
                    {
                        
                        if (bqFlag == false)
                        {
                            arrQueue[nIndex] = new Queue<String>();
                            bqFlag = true;    
                        }

                        nCurrentNode = nCurrentNode - nTeams - 2;

                        int mAxis = nCurrentNode/nTeams;
                        int nAxis = nCurrentNode%nTeams;    
                        
                        // System.out.println(mAxis + " " + nAxis + " " + eTemp.capacity() + " " + eTemp.flow() + "********");
                        // System.out.println(strTeams[nIndex]);
                        
                        bEliminated[nIndex] = true;
                        
                        if (bTempFlag[mAxis] == false)
                        {
 
                            bTempFlag[mAxis] = true;
                            arrQueue[nIndex].enqueue(strTeams[mAxis]);
                        }

                        if (bTempFlag[nAxis] == false)
                        {
                            bTempFlag[nAxis] = true;
                            arrQueue[nIndex].enqueue(strTeams[nAxis]);
                        }

                    }
                    
                }
                
            }

            // System.out.println("Finish one loop");
        }

        bNonTrival = true;

    }
    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team)
    {
        // for the team, we can use a simple number to indicate it
        if (team == null)
            throw new NullPointerException("INput to the certificate function is null");

        if (!bNonTrival)
            nonTrivialEliminate();

        int nTemp = -1;
        for (int nIndex = 0; nIndex < nTeams; nIndex++)
        {
            if (strTeams[nIndex].equals(team))
            {
                nTemp = nIndex;
                break;
            }
        }

        if (nTemp == -1)
            throw new IllegalArgumentException("The input team name doesn't match");

        return arrQueue[nTemp];
        // return null;
    }

    public static void main(String[] args) 
    {

        // String filename = args[0];
        // BaseballElimination division = new BaseballElimination(args[0]);
        // // System.out.println(division.teams());

        // for (String team : division.teams()) 
        // {
        //     if (division.isEliminated(team)) 
        //     {
        //         StdOut.print(team + " is eliminated by the subset R = { ");
                
        //         for (String t : division.certificateOfElimination(team)) 
        //         {
        //             StdOut.print(t + " ");
        //         }
                
        //         StdOut.println("}");
        //     }

        //     else 
        //     {
        //         StdOut.println(team + " is not eliminated");
        //     }
        // }
    }
}