#include <iostream>
using namespace std;
#include "studUnit.hpp"

void mainLoop(studUnit& student);
void showTitle();

int main()
{
    studUnit a(10);
    showTitle();
    mainLoop(a);
    cout << "exit successfully!" << endl;
}

void showTitle()
{
    /*
        �������ָ��
    */
    cout << endl
         << endl;
    cout << "***************************************************" << endl;
    cout << " 1.��ѧ�����������ѧ����Ϣ" << endl;
    cout << " 2.�ڽ������޸�ѧ����Ϣ" <<endl;
    cout << " 3.�ڽ�����ɾ��ѧ����Ϣ" << endl;
    cout << endl;
    cout << " 4.���ļ��ж�ȡ��������Ϣ" << endl;
    cout << " 5.���ļ�д��ѧ����������Ϣ" << endl;
    cout << endl;
    cout << " 6.�ڽ������в�ѯѧ����Ϣ(��ѧ��ѧ�������в���)" << endl;
    cout << " 7.����Ļ�����ȫ��ѧ����Ϣ" << endl;
    cout << endl;
    cout << " 8.��ʾ������ָ��" << endl;
    cout << " 0.�˳�" << endl;
    cout << "***************************************************" << endl;
    cout << endl
         << endl;
}

void mainLoop(studUnit& student)
{
    int userChoose = 1;
    while(userChoose)
    {
        cout << "��������Ҫ���еĲ���: "<<endl;
        cin >> userChoose;
        switch (userChoose)
        {
        case 1:
            student.addStudent();
            break;
        case 2:
            student.editStudent();
            break;
        case 3:
            student.deleteStudent();
            break;
        case 4:
            student.readFile();
            break;
        case 5:
            student.writeFile();
            break;
        case 6:
            student.searchStudent();
            break;
        case 7:
            student.output();
            break;
        case 8:
            showTitle();
            break;
        case 0:
            cout << "preparing to exit!" << endl;
            break;
        default:
            cout << "invalid operation!" << endl;
            break;
        }
    };
}
