import java.util.Random;

public class deckCard
{
    public static void shuffle(int [] card)
    {
        Random rnd = new Random();
        int length = card.length;

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            int nRandom = rnd.nextInt(nIndex + 1);
            //change the element in [nIndex] and nRandon
            int nTemp = card[nRandom];
            card[nRandom] = card[nIndex];
            card[nIndex] = nTemp;
        }
    
    }

    public static void chooseM(int [] arr, int m)
    {
        int length = arr.length;

        if (length < m)
        {
            System.out.println("Array out of bound error");
            return;
        }

        for (int nIndex = 0; nIndex < length; nIndex++)
        {
            System.out.print(arr[nIndex] + " ");

            if ((nIndex + 1)%10 == 0)
                System.out.println();
        }
        
        System.out.println();

        // then we will choose the first m elements to output 
        Random rnd = new Random();
        for (int nIndex = 0; nIndex < m; nIndex++)
        {
            int nRandom = rnd.nextInt(length - nIndex);
            int nTemp = arr[nIndex];
            arr[nIndex] = arr[nRandom+nIndex];
            arr[nRandom+nIndex] = nTemp;
        }

        System.out.println("The chosen number are ");

        for (int nIndex = 0; nIndex < m; nIndex++)
        {
            System.out.print(arr[nIndex] + " ");

            if ((nIndex + 1)%10 == 0)
                System.out.println();
        }
        
    }

    public static void main(String[] args) 
    {
        int [] card = new int[52];
        int number = Integer.parseInt(args[0]);

        for (int nIndex = 0; nIndex < 52; nIndex++)
        {
            card[nIndex] = nIndex + 1;
        }

        // for (int nIndex = 0; nIndex < 52; nIndex++)
        // {
        //     System.out.print(card[nIndex] + " ");

        //     if ((nIndex+1)%10 == 0)
        //         System.out.print("\n");
        // }

        // System.out.print("\n");
        // System.out.print("\n");

        // shuffle(card);

        // for (int nIndex = 0; nIndex < 52; nIndex++)
        // {
        //     System.out.print(card[nIndex] + " ");

        //     if ((nIndex+1)%10 == 0)
        //         System.out.print("\n");
        // }

        // System.out.print("\n");
        chooseM(card, number);


    }
}