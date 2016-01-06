#include <iostream>
using namespace std;

class FirstClass
{
public:
    void methodA(int);
    void methodA(int, int);
};

void FirstClass::methodA(int i)
{
    cout << "one\n";
}

void FirstClass::methodA(int i, int j)
{
    cout << "two\n";
}

class SecondClass: public FirstClass
{
public:
    void methodA(int);
};

void SecondClass::methodA(int i)
{
    cout << "three\n";
}

int main(int argc, char const *argv[])
{
    /* code */
    FirstClass a1;
    a1.methodA(-1);
    a1.methodA(-1, 0);

    SecondClass a2;
    // a2.methodA(-1);
    a2.methodA(-1, 0);
    return 0;
}