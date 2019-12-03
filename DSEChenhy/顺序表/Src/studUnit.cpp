#include <iostream>
#include "studUnit.hpp"
using namespace std;
#include <string>
#include <fstream>
#include <cstring>

studUnit::studUnit(int sz)
{
    if (sz > 0)
    {
        maxSize = sz;
        last = -1;
        data = new studType[maxSize];
        if (data == 0)
        {
            maxSize = 0;
            last = -1;
            return;
        }
    }
}

studUnit::~studUnit()
{
    maxSize = 0;
    last = -1;
    delete[] data;
}

//��last+1��ѧ��Ϊdata[last]������
void studUnit::addStudent()
{
    //last��ָ����ÿ����һ����last��ָ�����һ��
    last++;
    cout << "����� " << (last + 1) << " ��ѧ��" << endl;
    cout << "������ѧ��" << endl;
    cin >> data[last].number;
    // cout << data[last].number << "!!!" << endl;
    cout << "����������" << endl;
    while (getchar() != '\n')
        ;
    cin.getline(data[last].name, 20);
    // cout << data[last].name << "???" << endl;
    cout << "�������������(�� �� ��)" << endl;
    cin >> data[last].dateTime.year >> data[last].dateTime.month;
    cin >> data[last].dateTime.day;
    cout << "�������Ա�(��m,Ůf)" << endl;
    cin >> data[last].sex;
    cout << "�����뽡����Ϣ" << endl;
    while (getchar() != '\n')
        ;
    cin.getline(data[last].health, 200);
    cout << "�������! " << endl;
    cout << endl;
}

void studUnit::editStudent()
{
    int studnum;
    cout << "Ŀǰ�� " << last + 1 <<"��ѧ��" <<endl;
    cout << "������Ҫ�޸ĵڼ���ѧ������Ϣ " << endl;
    cin >> studnum;
    if(1 > studnum || last+1 < studnum)
        exit(1);
    studnum -= 1;
    cout << "������ѧ��" << endl;
    cin >> data[studnum].number;
    // cout << data[last].number << "!!!" << endl;
    cout << "����������" << endl;
    while (getchar() != '\n')
        ;
    cin.getline(data[studnum].name, 20);
    // cout << data[last].name << "???" << endl;
    cout << "�������������(�� �� ��)" << endl;
    cin >> data[studnum].dateTime.year >> data[studnum].dateTime.month;
    cin >> data[studnum].dateTime.day;
    cout << "�������Ա�(��m,Ůf)" << endl;
    cin >> data[studnum].sex;
    cout << "�����뽡����Ϣ" << endl;
    while (getchar() != '\n')
        ;
    cin.getline(data[studnum].health, 200);
    cout << "�������! " << endl;
    cout << endl;
}


void studUnit::deleteStudent()
{
    int num;
    cout << "������Ҫɾ���ڼ���ѧ��" << endl;
    cin >> num;
    if (num == 0)
    {
        cout << "��������ֲ���Ϊ0" << endl
             << endl;
        return;
    }
    if (num > last + 1)
    {
        cerr << "��������������" << endl;
        return;
    }
    for (int i = num; i <= last; i++)
    {
        data[i - 1] = data[i];
    }
    last--;
    cout << "ɾ������ " << (last + 1) << "��ѧ��" << endl;
    cout << endl;
}

void studUnit::searchStudent()
{
    int i = 0;
    char number[10];
    cout << "������Ҫ���ҵ�ѧ��ѧ��" << endl;
    cin >> number;
    for (; i <= last; i++)
    {
        if (strcmp(number, data[i].number) == 0)
        {
            cout << "ѧ��: " << data[i].number << endl;
            cout << "����: " << data[i].name << endl;
            cout << "����: " << data[i].dateTime.year << " "
                 << data[i].dateTime.month << " "
                 << data[i].dateTime.day << endl;
            cout << "�Ա�:(��m,Ůf)" << data[i].sex << endl;
            cout << "�������: " << data[i].health << endl;
            cout << endl;
            cout << endl;
            return;
        }
    }
    cout << "��Ҫ���ҵ�ѧ�Ų�����!" << endl
         << endl;
}

void studUnit::output()
{
    if (last == -1)
    {
        cout << "û��ѧ���ˣ�" << endl;
    }
    for (int i = 0; i <= last; i++)
    {
        cout << "ѧ��: " << data[i].number << endl;
        cout << "����: " << data[i].name << endl;
        cout << "����: " << data[i].dateTime.year << " "
             << data[i].dateTime.month << " "
             << data[i].dateTime.day << endl;
        cout << "�Ա�: f:�� m:Ů " << data[i].sex << endl;
        cout << "�������: " << data[i].health << endl;
        cout << endl;
    }
    cout << "������! " << endl
         << endl
         << endl;
}

void studUnit::readFile()
{
    ifstream infile("f1.dat", ios::in | ios::out | ios::binary);
    if (!infile)
    {
        cerr << "open error!" << endl;
        exit(1);
    }
    int i = 0;
    while (infile.read((char *)&data[i], sizeof(data[i])))
    {
        i++;
        last++;
    }
    cout << "��ȡ" << last + 1 << "����Ϣ�ɹ�" << endl;
    cout << endl;
    cout << endl;
}

void studUnit::writeFile()
{
    if(-1 == last)
    {
        int choose = 0;
        cout << "!!!�������ᵼ�����ݱ���գ��Ƿ����?" << endl;
        cout << "1.���� 0.����" <<endl;
        cin >> choose;
        if(0 == choose)
            return;
    }
    ofstream outfile("f1.dat", ios::binary);
    if (!outfile)
    {
        cerr << "open error!" << endl;
        abort();
    }
    for (int i = 0; i <= last; i++)
    {
        outfile.write((char *)&data[i], sizeof(data[i]));
    }
    outfile.close();
    cout << endl;
    if(-1 == last)
        cout << "��ճɹ� " << endl;
    else
        cout << " write " << last + 1 << " information successfully!" << endl;
    cout << endl;
}