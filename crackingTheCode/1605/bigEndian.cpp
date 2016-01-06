#define BIG_ENDIAN 0
#define LITTLE_ENDIAN 1
#include <iostream>
using namespace std;


int main(int argc, char const *argv[])
{
    
    int word = 0x0001;
    char *byte = (char *) &word;
    cout << word << endl;

    cout << byte[0] << endl;
    cout << byte[1] << endl;

    cout << BIG_ENDIAN << endl;
    
    cout << LITTLE_ENDIAN << endl;
    
    cout <<(byte[0] ? LITTLE_ENDIAN : BIG_ENDIAN) << endl; 
    
    return (byte[0] ? LITTLE_ENDIAN : BIG_ENDIAN);
}