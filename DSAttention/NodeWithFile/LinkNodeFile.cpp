#include <iostream>
#include <fstream>

//这里写这个只是为了不让编辑器老是报错
//这里的结构体和类是不完整的
//只不过这里写文件涉及到结点，故保留一下
struct dataType{
    string name;
};

struct LinkNode{
    dataType data; 
    LinkNode *next;
};


class studentUnit{
public:
    bool writeFile();
    bool readFile();

private:
    LinkNode* first;
};

using namespace std;

bool studentUnit::writeFile()
{
    ofstream outfile("student.dat",ios::out|ios::binary);
    if(!outfile)
    {
        cerr << "outfile打开student.dat失败" << endl;
        return false;
    }
    LinkNode *p = first->next;
    int i = 0;
    while(p != 0)
    {
        outfile.write((char*)(&(p->data)),sizeof(p->data));
        i++;
        p = p->next;
    }
    cout << "成功写入 " << i << " 条信息" << endl;
    cout << endl;
    return true; 
}


bool studentUnit::readFile()
{
    ifstream infile("student.dat",ios::in | ios::binary);
    if(!infile)
    {
        cerr << "infile打开student.dat失败" << endl;
        return false;
    }
    int i = 0;
    LinkNode *p = new LinkNode();
    if(p == 0)
    {
        cerr << "分配内存错误" << endl;
        exit(1);
    }
    first->next = p;
    LinkNode *q = p;
    while(infile.read((char *)(&(p->data)),sizeof(p->data)))
    {
        i++;
        q = p;
        p = new LinkNode;
        if(p == 0)
        {
            cerr << "分配内存错误" << endl;
            exit(1);
        }
        q->next = p;
    }
    q->next = 0;
    //用这个while循环会多开了一个空间
    delete p;
    infile.close();
    cout << "成功读入 " << i << " 条信息" << endl;
    cout << endl;
    return true;
}