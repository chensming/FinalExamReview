#include <iostream>
using namespace std;
#include <fstream>

int main()
{
    int a[10];
    ofstream outfile("f1.dat", ios::out);
    if (!outfile)
    {
        cerr << "open error" << endl;
        exit(1);
    }
    // cout << "enter 10 integer numbers:" << endl;
    for (int i = 0; i < 10; i++)
    {
        a[i] = i;
        outfile << a[i] << endl;
    }
    outfile.close();
    cout<<"successfully"<<endl;
    system("pause");
}