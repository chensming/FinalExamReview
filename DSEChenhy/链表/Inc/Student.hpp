#ifndef studUnit_h
#define studUnit_h

struct dateType
{
    int year;
    int month;
    int day;
};

struct student
{
    char number[10];   //ѧ��
    char name[20];     //����
    dateType dateTime; //��������
    char sex;          //�Ա�
    char health[200];  //����״��
};

struct LinkNode
{
    student data;
    LinkNode *next;

    LinkNode(LinkNode *ptr = 0) { next = ptr; }
};

class studentUnit
{
public:
    studentUnit();
    ~studentUnit();
    //�ÿ�
    void makeEmpty();
    //1.��ѧ�����������ѧ����Ϣ
    bool addStudent();
    //2.�ڽ������޸�ѧ����Ϣ
    bool editStudent();
    //3.�ڽ�����ɾ��ѧ����Ϣ
    bool deleteStudent();
    //4.���ļ��ж�ȡ��������Ϣ
    bool readFile();
    //5.���ļ�д��ѧ����������Ϣ
    bool writeFile();
    //6.�ڽ������в�ѯѧ����Ϣ(��ѧ��ѧ�������в���)
    bool searchStudent();
    //7.����Ļ�����ȫ��ѧ����Ϣ
    void output();
    //���ر��е� i ���ĵ�ַ
    LinkNode *Locate(int i);

private:
    LinkNode *first;
};

#endif