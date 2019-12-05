#include <iostream>
#include <strstream>
using namespace std;
struct student
{
    int num;
    char name[20];
    float score;
};

int main()
{
    student stud[3] = {1001, "Li", 78,
                       1002, "Wang", 89.5,
                       1004, "Fang", 90};
    char c[50];
    ostrstream strout(c, 50);
    for (int i = 0; i < 3; i++)
    {
        strout << " " << stud[i].num << " " << stud[i].name
               << " " << stud[i].score;
    }
    strout << ends;
    cout << "array c:" << c << endl;

    system("pause");
}