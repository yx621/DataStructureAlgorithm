#include <iostream>
using namespace std;

class A
{
	public:
		A(){cout << "this is the constructor\n";}
		A& operator= (const A &other);
		// {
		// 	cout << " = operator for class\n";
		// 	return *this;
		// }

		~A(){cout << "This is the destructor function\n";}

};

A& A::operator= (const A &other)
{
	cout << " = operator for class\n";
	return *this;
}

A func()
{
	A a;
	return a;
}

int main(int argc, char const *argv[])
{
	A a ;
	a = func();


	return 0;
}