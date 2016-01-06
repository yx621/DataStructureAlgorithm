public class AddNumber
{
    public static int add(int a, int b)
    {
        int sum = a^b;
        int carry = a&b;
        carry = carry<<1;
        
        while(carry != 0)
        {
            int temp = sum;
            sum = sum^carry;
            carry = (carry&temp) << 1;
        }
        
        return sum;
    }
    public static void main(String [] args)
    {
        int nNum1 = Integer.parseInt(args[0]);
        int nNum2 = Integer.parseInt(args[1]);
        
        System.out.println("The inputs are " + nNum1 + " " + nNum2);
        System.out.println("The sum is " + add(nNum1, nNum2));
    }
}