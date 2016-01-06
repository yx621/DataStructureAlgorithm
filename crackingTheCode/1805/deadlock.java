public class deadlock
{
    public static void main(String [] args)
    {
        /*
          release(a);

          acquire(a);
          release(b);

          acquire(b);
          release(c);

          acquire(c)
        */
    }
}

/*
synchronization in Java
    -- synchronized method and synchronized statement

synchronized method:
    -- methods that needs to be synchronized are declared with synchronized keyword.
    -- when one thread executing a synchronized method, all other threads which wants to execute any of the synchronized methods on the same objects get blocked

synchronized statement:
    -- provides the synchronization for a group of statements rather than a method as a whole
    -- need to provide onject on which the synchronized statements will be applied
*/