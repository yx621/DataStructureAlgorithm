public class objectRF
{
    public static void main(String[] args) 
    {
        try
        {
            Class c = Class.forName("java.sql.Connection");
            Method m[] = c.getDeclaredMethod();
            for (int nIndex = 0; nIndex < 3; nIndex++)
            {
                System.out.println(m[nIndex].toString());
            }
        }

        catch (Throwable e)
        {
            System.out.println(e);
        }
    }
}