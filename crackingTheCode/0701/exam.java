public class exam
{
    // this example is used to learn the enum data type in java
    enum Suit{CLUBS, SPADES, HEART, DIAMOND}

    public static void main(String[] args) 
    {
        Suit suit1 = Suit.SPADES;

        System.out.println(suit1);
        System.out.println(suit1.ordinal());
        System.out.println(suit1.name());
        System.out.println("*******");

        suit1 = Suit.CLUBS;

        System.out.println(suit1);
        System.out.println(suit1.ordinal());
        System.out.println(suit1.name());

    }
}