public class trycatch
{
    /*
      get executed when the try block exists

      even when we attept to exit within the try block (normal exit, return, continue, break or any exception)
      the final block will still be execued

      some cases will not get executed
      If virtual machine exists between the try/catch block execution
      or thread which is executing try/catch block get killed

    */


    /*
      final -- finally -- finalize

      1. Final

          when applied to a variable -- the value cannot be changed
          when applied to a reference -- the reference variable cannot point to any other object on the heap
          when applied to a method -- the method cannot be overriden
          when applied to a class -- the class cannot be subclassed

      2. Finally
          optional fianlly block after the try block or after the catch block. Statements in the fianlly block will always be executed (except if JVM
          exists from the try block). The final blcok is used to write the clean up code

      3. Finalize
          this is the method that the JVM runs before running the garbage collector.

    */

    /*
                  Templates in C++                  ||              Generics in Java
                                                    ||
      classes and functions can be templated        || classes amd methods can be genericized
                                                    ||
      parameters can be any type or integral value  || parameters can only be reference types (Integer, Double...)
                                                    || 
      separate copies of class or function are      || one version of the class or function is compiled, works for all 
      likely to be generated for each type          || type parameters
      compiled when compiled                        || 
                                                    || 
      Objects of a class with different type param  || Type parameters are erased when compiled. Object of a class with 
      -eters are different types at run time        || different parameters are the same type at run time
      
      

    */
    public static void main(String[] args) 
    {
        
    }
}