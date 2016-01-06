#include <iostream>
using namespace std;

class Base
{
public:
    Base()
    {
        cout << "Base constructor\n";
    }

    virtual ~Base()
    {
        cout << "Base destructor\n";
    }
};

class Derived : public Base
{
public:
    Derived()
    {
        cout << "derived constructor\n";
    }

    ~Derived()
    {
        cout << "Derived destructor\n";
    }

};

int main(int argc, char const *argv[])
{
    /* code */
    Base *p = new Derived();
    delete p;
    return 0;
}