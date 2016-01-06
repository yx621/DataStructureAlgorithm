public class Test extends card
{
    public static void main(String[] args) 
    {
        Suit suit = Suit.DIAMONDS;

        int nNumber = Integer.parseInt(args[0]);

        BlackJack bj = new BlackJack(nNumber, suit);

        System.out.println(bj.isAce());
        System.out.println(bj.value());
        System.out.println(bj.number());
        System.out.println(bj.suit());

        suit = Suit.SPADES;

        BlackJack [] bjA = (BlackJack []) new BlackJack[13];

        for (int nIndex = 0; nIndex < 13; nIndex++)
        {
            bjA[nIndex] = (BlackJack) new BlackJack(nIndex + 1, suit);
        }

        for (int nIndex = 0; nIndex < 13; nIndex ++)
        {
            System.out.println("The original card is [" + bjA[nIndex].suit() + " " + bjA[nIndex].number() + "] The BlackJack representation is [" + bjA[nIndex].suit() + " " + bjA[nIndex].value() + "]");
        }


    }
}