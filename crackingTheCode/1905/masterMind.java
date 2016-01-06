import java.util.Random;

public class masterMind
{
    enum COLOR{RED, YELLOW, GREEN, BLUE}
    
    public static class Result 
    {
        public int hits;
        public int pseudoHits;
    };
    
    public static Result estimate(String guess, String solution) 
    {
        Result res = new Result();
        int solution_mask = 0;
        for (int i = 0; i < 4; ++i) 
        {
            solution_mask |= 1 << (1 + solution.charAt(i) - 'A');
            System.out.println(Integer.toBinaryString(solution_mask));
        }
        
        for (int i = 0; i < 4; ++i) 
        {
            if (guess.charAt(i) == solution.charAt(i)) 
            {
                ++res.hits;
            } 
            
            else if ((solution_mask & (1 << (1 + guess.charAt(i) - 'A'))) >= 1) 
            {
                ++res.pseudoHits;
            }
        }
        
        return res;
    }
    
    public static void solve(COLOR [] answer, COLOR [] solution)
    {
        int length = answer.length;
        
        System.out.println("The solution sequence is ");
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            System.out.print(solution[nIndex] + " " );
        }
        System.out.println();
        System.out.println("The answer sequence is ");
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            System.out.print(answer[nIndex] + " " );
        }
        System.out.println();
        boolean [] bArr1 = new boolean[length];
        boolean [] bArr2 = new boolean[length];
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            bArr1[nIndex] = false;
            bArr2[nIndex] = false;
        }
        
        int nHit = 0;
        int npHit = 0;
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            if (answer[nIndex] == solution[nIndex])
            {
                bArr1[nIndex] = true;
                bArr2[nIndex] = true;
                nHit++;
            }
        }
        
        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            for (int mIndex = 0; mIndex < length; mIndex++)
            {
                if (answer[nIndex] == solution[mIndex] && bArr2[mIndex] == false && bArr1[nIndex] == false)
                {
                    npHit++;
                    bArr2[mIndex] = true;
                    bArr1[nIndex] = true;
                }
            }
        }
        
        System.out.println("The number of hit is " + nHit);
        System.out.println("The number of peseudo hit is " + npHit);
    }
    
    public static void main(String [] args)
    {
        COLOR color1 = COLOR.RED;
       
        // COLOR [] color = new COLOR[4];
        Random rnd = new Random();
        COLOR [] solution = new COLOR[4];
        for (int nIndex = 0; nIndex < 4; nIndex++)
        {
            int nTemp = rnd.nextInt(4);
            
            switch(nTemp)
            {
                case 0:
                    solution[nIndex] = COLOR.RED;
                    break;
                case 1:
                    solution[nIndex] = COLOR.YELLOW;
                    break;
                case 2: 
                    solution[nIndex] = COLOR.GREEN;
                    break;
                case 3:
                    solution[nIndex] = COLOR.BLUE;
                    break;
                default:
                    solution[nIndex] = COLOR.RED;
            }
        }
        
        COLOR [] answer = new COLOR[4];
        /*
        int [] n = new int[4];
        int n[0] = Integer.parseInt(args[0]);
        int n[1] = Integer.parseInt(args[1]);
        int n[2] = Integer.parseInt(args[2]);
        int n[3] = Integer.parseInt(args[2]);
        */
        
        
        for (int nIndex = 0; nIndex < 4; nIndex++)
        {
            int nTemp = Integer.parseInt(args[nIndex]);
            
            switch(nTemp)
            {
                case 0:
                    answer[nIndex] = COLOR.RED;
                    break;
                case 1:
                    answer[nIndex] = COLOR.YELLOW;
                    break;
                case 2: 
                    answer[nIndex] = COLOR.GREEN;
                    break;
                case 3:
                    answer[nIndex] = COLOR.BLUE;
                    break;
                default:
                    answer[nIndex] = COLOR.RED;
            }
        }
        
        solve(answer, solution);
        
        String str1 = "ABCD";
        String str2 = "BBBB";
        
        Result res = estimate(str2, str1);
        
        System.out.println("The hit number is " + res.hits);
        System.out.println("The pseudo hit number is " + res.pseudoHits);
        
        
        
        
        
        
    }
}