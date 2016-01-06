#include <iostream>
#include <cstring>
using namespace std;
/*
  shallow copy is used when no need to pass informtion about complex structure
  without actual duplication of data (call by reference)

  smart pointer -- enhancement of shallow copy concept

  deep copy should always be used 
  
*/

struct Test
{
    char *ptr;
};

void shallow_copy(Test & src, Test & dest)
{
    dest.ptr = src.ptr;
}

void deep_copy(Test &src, Test &dest)
{
    dest.ptr = malloc(strlen(src.ptr) + 1);
    memcpy(dest.ptr, src.ptr);
}

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}