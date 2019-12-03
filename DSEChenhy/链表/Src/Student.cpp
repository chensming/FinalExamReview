#include <fstream>
#include "Student.hpp"
#include <iostream>
#include <string>
#include <cstring>
using namespace std;

studentUnit::studentUnit()
{
    first = new LinkNode();
}

studentUnit::~studentUnit()
{
    makeEmpty();
}

void studentUnit::makeEmpty()
{
    LinkNode *q;
    while (first->next != 0)
    {
        q = first->next;
        first->next = q->next;
        delete q;
    }
}

bool studentUnit::addStudent()
{
    int i;
    cout << "������Ҫ���뵽�ڼ���ѧ��֮��(0������뵽��ǰ��)" << endl;
    cin >> i;
    LinkNode *current = Locate(i);
    if (current == 0)
    {
        cerr << "��������" << endl;
        return false;
    }
    // char number[10];   //ѧ��
    // char name[20];     //����
    // dateType dateTime; //��������
    // char sex;          //�Ա�
    // char health[200];  //����״��
    LinkNode *p = new LinkNode();
    if (p == 0)
    {
        cerr << "�ڴ�������" << endl;
        exit(1);
    }

    cout << "�������ѧ����ѧ��" << endl;
    cin >> p->data.number;
    cout << "�������ѧ��������" << endl;
    while (getchar() != '\n')
    {
        //null
    }
    cin.getline(p->data.name, 20);
    cout << "�������ѧ���ĳ�������" << endl;
    cin >> p->data.dateTime.year >> p->data.dateTime.month >> p->data.dateTime.day;
    cout << "�������ѧ�����Ա�(��m,Ůf)" << endl;
    cin >> p->data.sex;
    cout << "�������ѧ�������彡�����" << endl;
    while (getchar() != '\n')
    {
    }
    cin.getline(p->data.health, 200);

    //����ӵ������
    p->next = current->next;
    current->next = p;
    cout << "�������" << endl;
    cout << endl;
    return true;
}

bool studentUnit::editStudent()
{
    int i;
    cout << "��������Ҫ�޸ĵڼ���ѧ������Ϣ" << endl;
    cin >> i;
    if (i <= 0)
    {
        cout << "��������" << endl;
        return false;
    }
    LinkNode *current = Locate(i);
    if (current == 0)
    {
        cout << "��������" << endl;
        return false;
    }

    cout << "������Ҫ�޸ĵ�ѧ����ѧ��" << endl;
    cin >> current->data.number;
    cout << "������Ҫ�޸ĵ�ѧ��������" << endl;
    while (getchar() != '\n')
    {
        //null
    }
    cin.getline(current->data.name, 20);
    cout << "������Ҫ�޸ĵ�ѧ���ĳ�������" << endl;
    cin >> current->data.dateTime.year >> current->data.dateTime.month >> current->data.dateTime.day;
    cout << "������Ҫ�޸ĵ�ѧ�����Ա�(��m,Ůf)" << endl;
    cin >> current->data.sex;
    cout << "������Ҫ�޸ĵ�ѧ�������彡�����" << endl;
    while (getchar() != '\n')
    {
    }
    cin.getline(current->data.health, 200);

    cout << "�޸ĳɹ�" << endl;
    cout << endl;
    return true;
}

bool studentUnit::deleteStudent()
{
    int i;
    cout << "��������Ҫɾ���ڼ���ѧ������Ϣ" << endl;
    cin >> i;
    if (i <= 0)
    {
        cout << "��������" << endl;
        return false;
    }
    LinkNode *current = Locate(i-1);
    if (current == 0 || current->next == 0)
    {
        cout << "��������" << endl;
        return false;
    }
    LinkNode *del = current->next;
    current->next = del->next;
    cout << "ɾ���ɹ�" << endl;
    return true;
}

bool studentUnit::readFile()
{
    ifstream infile("student.dat", ios::in | ios::binary);
    if (!infile)
    {
        cerr << "infile��student.datʧ��" << endl;
        abort();
    }
    int i = 0;
    LinkNode *p = new LinkNode();
    if (p == 0)
    {
        cerr << "�����ڴ����" << endl;
        exit(1);
    }
    first->next = p;
    LinkNode *q = p;
    while (infile.read((char *)(&(p->data)), sizeof(p->data)))
    {
        i++;
        q = p;
        p = new LinkNode();
        if (p == 0)
        {
            cerr << "�����ڴ����" << endl;
            exit(1);
        }
        q->next = p;
    }
    q->next = 0;
    delete p;
    infile.close();
    cout << "�ɹ����� " << i << " ����Ϣ" << endl;
    cout << endl;
    return true;
}

bool studentUnit::writeFile()
{
    ofstream outfile("student.dat", ios::out|ios::binary);
    if (!outfile)
    {
        cerr << "outfile��student.datʧ��" << endl;
        exit(1);
    }
    LinkNode *p = first->next;
    int i = 0;
    while (p != 0)
    {
        outfile.write((char *)(&(p->data)), sizeof(p->data));
        i++;
        p = p->next;
    }
    cout << "�ɹ�д�� " << i << " ����Ϣ" << endl;
    cout << endl;
    return true;
}

bool studentUnit::searchStudent()
{
    char num[10];
    cout << "������Ҫ���ҵ�ѧ����ѧ��" << endl;
    cin >> num;
    LinkNode *p = first->next;
    while (p != 0 && (strcmp(p->data.number, num) != 0))
    {
        p = p->next;
    }
    if (p == 0)
    {
        cout << "û�ҵ���ѧ��" << endl;
        return false;
    }
    cout << "��ѧ����Ϣ����: " << endl;
    cout << "ѧ��: " << p->data.number << endl;
    cout << "����: " << p->data.name << endl;
    cout << "����: " << p->data.dateTime.year << " "
         << p->data.dateTime.month << " "
         << p->data.dateTime.day << endl;
    cout << "�Ա�:(��m,Ůf) " << p->data.sex << endl;
    cout << "�������: " << p->data.health << endl;
    cout << endl;
    return true;
}

void studentUnit::output()
{
    LinkNode *p = first->next;
    cout << "-------------ѧ����Ϣ��--------------" << endl;
    while (p != 0)
    {
        cout << "ѧ��: " << p->data.number << endl;
        cout << "����: " << p->data.name << endl;
        cout << "����: " << p->data.dateTime.year << " "
             << p->data.dateTime.month << " "
             << p->data.dateTime.day << endl;
        cout << "�Ա�:(f:�� m:Ů)" << p->data.sex << endl;
        cout << "�������: " << p->data.health << endl;
        cout << endl;
        p = p->next;
    }
    cout << "--------------------------------------" << endl;
    cout << "������" << endl;
    cout << endl;
}

LinkNode *studentUnit::Locate(int i)
{
    if (i < 0)
        return 0;
    LinkNode *current = first;
    int k = 0;
    while (current != 0 && k < i)
    {
        current = current->next;
        k++;
    }
    return current;
}
