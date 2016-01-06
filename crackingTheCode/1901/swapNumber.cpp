#include <iostream>
using namespace std;

void swap(int &a, int &b)
{
    /*
    a = a^b;
    b = a^b = a^b^b = a;
    a = a^b = a^b^a = b
    */

    a = a^b;
    b = a^b;
    a = a^b;

    cout << "value in the function a = " << a << " b = " << b << "\n";

}
int main()
{
    cout << "Input 2 integer numbers a, b : \n";
    int a, b;

    cin >> a >> b;
    cout << "before swap \n";
    cout << "a = " << a << " b = " << b << "\n";
    cout << "after swap\n";
    swap(a,b);
    cout << "a = " << a << " b = " << b << "\n";

    return 0;

}