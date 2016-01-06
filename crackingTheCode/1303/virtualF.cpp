#include <iostream>
using namespace std;

/*
  virtual function depends on virtual table
  if function of a class is declared as virtual 
    -- virtual table is constructed which stored the addresses of the virtual functions of this class
    -- compiler adds a hidden virtual-pointer varable in all such classes which points to the vtable of that class 
    -- if virtual function is not overrideen in the derived class, v-table us used to resolve the address of the 
       function whenever the virtual function is called 
    -- Dynamic binding in C++ is performed through the vtable mechanism
*/

class Shape
{
public: 
    int length;
    // virtual int circumference()
    Shape()
    {
        length = 0;
    }
    virtual int circumference()
    {
        cout << "circumference of base calss \n";
        return 0;
    }
};

class Triangle: public Shape
{
public:
    //virtual int circumference()

    int circumference()
    {
        cout << "circumference of Triangle class\n";
        cout << 3*length << endl;
        return 3*length;
    }
};

int main(int argc, char const *argv[])
{
    /* code */
    Triangle x; //= new Shape();
    x.circumference();
    // Triangle * y = &x;
    // y.circumference();
    Shape &y = x;
    y.circumference();
    
    return 0;
}