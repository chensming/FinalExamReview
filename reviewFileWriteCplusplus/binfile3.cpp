#include <cstring>
#include <string>
#include <iostream>
using namespace std;
#include <fstream>

struct student
{
    int num;
    char name[20];
    float score;
};

int main()
{
    student stud[5] = {
        1001, "Li", 85,
        1002, "Fang", 97.5,
        1004, "Wang", 54,
        1006, "Tan", 76.5,
        1010, "Ling", 96};
    fstream iofile("f4.dat",ios::in|ios::out|ios::binary);
    if (!iofile)
    {
        cerr << "open error!" << endl;
        abort();
    }

//将stud的数组中的数据写到f4.dat中
    for (int i = 0; i < 5; i++)
    {
        iofile.write((char *)&stud[i], sizeof(stud[i]));
    }

//将文件f4.dat中数据写到stud1的数组中
    student stud1[5];
    for (int i = 0; i < 5; i = i + 2)
    {
        iofile.seekg(i * sizeof(stud[i]), ios::beg);
        iofile.read((char *)&stud1[i/2],sizeof(stud1[0]));
        cout<<stud1[i/2].num<<" "<<stud1[i/2].name<<" "<<stud1[i/2].score<<endl;
    }
    cout<<endl;

//对某个数据进行修改
    stud[2].num = 1012;
    strcpy(stud[2].name,"Wu");
    stud[2].score = 60;

//将更改的stud[2]写到文件中去
    iofile.seekg(2 * sizeof(stud[0]),ios::beg);
    iofile.write((char *)&stud[2],sizeof(stud[2]));

//从头开始，将文件中的内容写到stud的数组中，
//然后打印输出
    iofile.seekg(0,ios::beg);
    for(int i = 0; i < 5; i++)
    {
        iofile.read((char *)&stud[i],sizeof(stud[i]));
        cout<<stud[i].num<<" "<<stud[i].name<<" "<<stud[i].score<<endl;
    }
    iofile.close();
    system("pause");
}