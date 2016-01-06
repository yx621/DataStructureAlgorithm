public class callHandler
{
    public class Employee
    {
        callHandler callhandler;
        int rank;
        // from 0 to 2
        boolean free;
        // treu or false
        public Employee(int rank)
        {
            this.rank = rank;
            free = true;
        }

        public void receive(Call call)
        {
            // do soemthing to the call...
        }

        public void callHandled(Call call)
        {
            // if (rank >= )
            // if handle set free to false
            // call is complete
        }

        public void callCannotHandle(Call call)
        {
            call.rank += 1;
            callhandler.disPatch(call); // relocate the call
            free = true;
            callhandler.getNextCall(this);
            // get the next call since some employee is free again
        }

    }

    public class Fresher extends Employee
    {   
        public Fresher()
        {
            super(0);
        }
    }

    public class TL extends Employee
    {
        public TL()
        {
            super(1);
        }
    }

    public class PM extends Employee
    {
        public PM()
        {
            super(2);
        }
    }

    public class Call
    {
        int rank = 0;
        public void reply(String message)
        {
            // process the message
        }

        public void disConnect()
        {
            // process something
        }
    }

    public static int LEVEL = 3;
    private int nFresher;
    ArrayList<Employee> [] employeeLevels = new ArrayList[LEVEL];
    //check all the elements in the employee element. Very useful for maintainance...
    Queue<Call> [] callQueues = new Queue[LEVEL];
    // we have queue, no need linked list here
    // service strategy is FIFO
    public callhandler(int nNumber)
    {
        nFresher = nNumber;
        for (int nIndex = 0; nIndex < nNumber; nIndex++)
        {
            Fresher eTemp = new Fresher();
            employeeLevels[0].add(eTemp);
        }

        TL tl = new TL();

        employeeLevels[1].add(tl);
        PM pm = new PM();
        employeeLevels[2].add();

    }

    // get a call, first return one employee to answer it
    public Employee getCallHandler(Call call)
    {
        for (int level = call.rank; level < LEVEL - 1; level++)
        {
            ArrayList<Employee> employeelevel = employeeLevels[level];

            for (Employee emp : employeelevel)
            {
                if(emp.free)
                    return emp;
            }
        }

        return null;
    }

    public void disPatch(Call call)
    {
        Employee emp = getCallHandler(call);
        if (emp != null)
        {
            emp.receive(call);
        }

        else
        {
            callQueues[call.rank].add(call);
            // add the call to relevant queue
        }


    }

    public void getNextCall(Employee emp)
    {

    }
    
    

    public static void main(String[] args) 
    {
        
    }




}