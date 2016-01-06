#include <iostream>
using namespace std;

template <class T> class SmartPointer
{
protected:
    T *ref;
    int *ref_count;
    // I don't know why they prefer the unsiged type..
public:
    SmartPointer(T *ptr)
    {
        ref = ptr;
        ref_count = (int*)malloc(sizeof(int));
        // malloc delloc
        *ref_count = 1;
    }

    SmartPointer(SmartPointer<T> & sptr)
    {
        ref = sptr.ref;
        ref_count = sptr.ref_count;
        ++*ref_count;
    }

    SmartPointer<T> &operator=(SmartPointer<T> & sptr)
    {
        if (this!= &sptr)
        {
            ref = sptr.ref;
            ref_count = sptr.ref_count;
            ++*ref_count;
        }

        return *this;
    }

    ~SmartPointer()
    {
        --*ref_count;

        if (*ref_count == 0)
        {
            delete ref;
            free(ref_count);
            ref = NULL;
            ref_count = NULL;
        }
    }

    T getValue()
    {
        return *ref_count;
    }
};

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}