#include <iostream>
using namespace std;
#include <fstream>

void save_to_file()
{   /*
        将键盘输入的一行字符存入磁盘文件
    */
    ofstream outfile("f2.dat");
    if (!outfile)
    {
        cerr << "open f2.dat error!" << endl;
        exit(1);
    }
    char c[80];
    cin.getline(c, 80);
    for (int i = 0; c[i] != '\0'; i++)
    {
        if ((c[i] >= 65 && c[i] <= 90) || (c[i] >= 97 && c[i] <= 122))
        {
            outfile.put(c[i]);
            cout << c[i];
        }
    }
    cout << endl;
    outfile.close();
}

void get_from_file()
{   /*
        从磁盘文件f2.dat中读入字母字符,将小写字母转化为大写字母，
        再存入f3.dat
    */
    char ch;
    ifstream infile("f2.dat", ios::in);
    if (!infile)
    {
        cerr << "open f2.dat error" << endl;
        exit(1);
    }
    ofstream outfile("f3.dat");
    if (!outfile)
    {
        cerr << "open f3.dat error!" << endl;
        exit(1);
    }
    while (infile.get(ch))
    {
        if (ch >= 97 && ch <= 122)
            ch = ch - 32;
        outfile.put(ch);
        cout << ch;
    }
    infile.close();
    outfile.close();
}

void display_file(char * filename)
{
    /*
        将传入名字为filename的文件在屏幕上显示出来，
        如display_file("f2.dat")
    */
    ifstream infile(filename,ios::in);
    if(!infile)
    {
        cerr<<"open error!"<<endl;
        exit(1);
    }
    char ch;
    while(infile.get(ch))
    {
        cout.put(ch);
    }
    cout<<endl;
    infile.close();
}


int main()
{
    save_to_file();
    get_from_file();
    cout<<endl<<endl;
    cout<<"*************************************************"<<endl<<endl;
    display_file("f2.dat");
    cout << endl << "run successfully!" << endl;
    system("pause");
}