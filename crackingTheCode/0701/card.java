public class card
{
    enum Suit {CLUBS, SPADES, HEARTS, DIAMONDS}

    private int number;
    private Suit suit;

    public card()
    {
        number = 0;
        // suit = 0;
    }

    public card(int nNumber, Suit nSuit)
    {
        if (nNumber > 14 || nNumber < 1)
        {
            System.out.println("illegal number for card");
            return;
        }
        number = nNumber;
        suit = nSuit;

    }

    public int number()
    {
        return number;
    }

    public Suit suit()
    {
        return suit;
    }

}