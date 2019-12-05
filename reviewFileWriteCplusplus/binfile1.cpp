#include <string>
#include <iostream>
using namespace std;
#include <fstream>

struct student
{
    char name[20];
    int num;
    int age;
    char sex;
};

int main()
{
    student stud[3] = {"Li", 1001, 18, 'f',
                       "Fang", 1002, 19, 'm',
                       "Wang", 1004, 17, 'f'};
    ///////////////////////////////////////////////////
    ofstream outfile("f4.dat", ios::binary);
    ///////////////////////////////////////////////////
    if (!outfile)
    {
        cerr << "open error!" << endl;
        abort();
    }
    for (int i = 0; i < 3; i++)
    {
        /////////////////////////////////////////////////////
        outfile.write((char *)&stud[i], sizeof(stud[i]));
        /////////////////////////////////////////////////////
    }
    outfile.close();
    cout << "run successfully!" << endl;
    system("pause");
}