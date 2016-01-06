#include <iostream>
using namespace std;

class Base
{
protected:
 
public:
    const virtual char* GetName() { return "Base"; }
};
 
class Derived: public Base
{
public:
    const virtual char* GetName() { return "Derived"; }
};


int main(int argc, char const *argv[])
{
	/* code */
	Derived cDerived;
	Base *rBase = &cDerived;
	cout << "rBase is a " << rBase->GetName() <<"\n";
	return 0;
}