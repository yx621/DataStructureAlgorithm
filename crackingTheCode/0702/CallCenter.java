public class CallCenter
{
    enum EMPLOYEE{FRESHER, TL, PM}

    // the level number is 0 1 2 

    private int nFresher;

    private boolean [] bFresher;
    private boolean bTL;
    private boolean bPM;

    public CallCenter(int nNumber)
    {
        nFresher = nNumber;

        bFresher = new boolean[nNumber];

        for (int nIndex = 0; nIndex < nNumber; nIndex++)
        {
            bFresher[nIndex] = false;
        }

        bTL = false;
        bPM = false;

    }

    public void freshHandler(int level, int number)
    {
        bFresher[number] = true;

        if (level > EMPLOYEE.FRESHER.ordinal())
        {
            System.out.println("Fresher cannot handle this phone, direct to TL");
            tlHandler(level);
            bFresher[number] = false;
            return;
        }

        else
        {
            System.out.println("Fresher can handle this phone call");
            // wait for the processing time
            bFresher[number] = false;
            return;
        }


    }

    public void tlHandler(int level)
    {
        if (bTL == true)
        {
            System.out.println("TL is busy, direct to PM");   
            pmHandler();
            return;
        }
        if (level > EMPLOYEE.TL.ordinal())
        {
            System.out.println("TL cannot handle this phone, direct to PM");
            pmHandler();
            return;
        }

        bTL = true;

        // wait for the processing time
        System.out.println("TL has handled the problem");
        bTL = false;
    }

    public void pmHandler()
    {   
        if (bPM == true)
        {
            System.out.println("PM is busy");
            return;
        }

        bPM = true;
        // processing the call wait for some time for it
        System.out.println("PM has handled the problem");
        bPM = false;
    }


    public void getCallHandler(int level)
    {
        int nIndex = 0;

        for (nIndex = 0; nIndex < nFresher; nIndex++)
        {
            if (bFresher[nIndex] == false)
            {
                // bFresher[nIndex] = true;
                break;
            }
        }
        // choose the fresher first

        freshHandler(level, nIndex);

    }

    public static void main(String[] args) 
    {
        CallCenter cc = new CallCenter(10);

        for (int nIndex = 0; nIndex < 3; nIndex++)
            cc.getCallHandler(nIndex);

    }

}