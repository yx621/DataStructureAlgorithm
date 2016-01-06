public class BlackJack extends card
{
    public BlackJack(int r, Suit s)
    {
        super(r, s);
    }

    public int value()
    {
        int r = super.number();

        if (r == 1)
            return 11;

        if (r < 10)
            return r;

        else 
            return 10;
    }

    public boolean isAce()
    {
        int r = super.number();
        return r == 1;
    }

}