//
// Created by Dell on 2019/12/15.
//
//
// Created by Dell on 2019/12/15.
//
#include <utility>
#include<vector>
#include<iostream>
#include<algorithm>
#include<queue>
#include<iomanip>
#include <stack>
#include <fstream>

using namespace std;


struct HuffmanNode {
    float data;
    char ch;
    string code;
    HuffmanNode *leftchild, *rightchild, *parent;

    HuffmanNode() : data(-1), ch('$'), code(""), leftchild(nullptr), rightchild(nullptr), parent(nullptr) {}

    //HuffmanNode(const HuffmanNode& h);
    HuffmanNode(float elem, HuffmanNode *left = nullptr, HuffmanNode *right = nullptr, HuffmanNode *pr = nullptr) :
            data(elem), leftchild(left), rightchild(right), parent(pr) {}

    bool operator<=(HuffmanNode &R) { return data <= R.data; }

    bool operator>(HuffmanNode &R) { return data > R.data; }
};

/*
HuffmanNode::HuffmanNode(const HuffmanNode& h)
{
	data = h.data;
	leftchild = h.leftchild;
	rightchild = h.rightchild;
	//��ʵparent���д��д����ν����Ϊ���parent��=null��
	//��֤���Ѿ��������ڵ�ϳ�һ�����ڵ���,���ᱻ�ŵ�������
	parent = h.parent;
}
*/


bool cmp(const HuffmanNode &a, const HuffmanNode &b) {
    return a.data < b.data;
}


class HuffmanTree {
public:
    HuffmanTree();

    HuffmanTree(const float w[], const char ch[], int n);

    ~HuffmanTree() {
        deleteTree(root);
        charactorSize = 0;
    }

    void LevelOrder();

    void PrintGeneralizedList();

    void PrintGeneralizedList(HuffmanNode *BT);

    void setCode();

    void getCode();

    void enCoding(string originalFile, string encodingFile);

    void BuildDeCodingTree();

    void deCoding(string encodingFile, string outputFile);

private:
    HuffmanNode *root;

    string map[256];//���ַ���Ӧ�ı���

    char *charactor;//�жϴ�����Щ�ַ�

    int charactorSize;//����ַ�����

    void buildHuffmanTree(const float w[], const char ch[], int n);

    void deleteTree(HuffmanNode *t);

    void mergeTree(HuffmanNode *h1, HuffmanNode *h2, HuffmanNode *&parent);

    static void setCode(string s, HuffmanNode *ptr);
};


void display(vector<HuffmanNode> &v);//ʹ��vector����������

HuffmanTree::HuffmanTree() {
    int n;
    char ch[256];
    float weight[256];
    cout << "������Ҫ������ַ�����" << endl;
    cin >> n;
    cout << "��ֱ�����Ҫ������ַ�" << endl;
    for (int i = 0; i < n; i++)
        cin >> ch[i];
    cout << "��ֱ������Ӧ�ַ���Ȩ��" << endl;
    for (int i = 1; i < n; i++)
        cin >> weight[i];
    buildHuffmanTree(weight, ch, n);
}


HuffmanTree::HuffmanTree(const float w[], const char ch[], int n) {
    //Ϊ���������棬root = 0����ʵû��Ҫ�����root = parent
    //�Ѿ�������������
    root = nullptr;
    vector<HuffmanNode> hp;
    HuffmanNode *parent = 0, *first, *second, *work;
    HuffmanNode tempFirst, tempSecond;
    charactor = new char[n];
    //��ɱ�����ַ�
    for (int i = 0; i < n; i++) {
        charactor[i] = ch[i];
    }
    charactorSize = 0;


    for (int i = 0; i < n; i++) {
        work = new HuffmanNode;
        work->data = w[i];
        work->ch = ch[i];
        work->leftchild = nullptr;
        work->rightchild = nullptr;
        work->parent = nullptr;
        hp.push_back(*work);
        //make_heap(hp.begin(), hp.end(), cmp);
        //sort_heap(hp.begin(), hp.end(), cmp);
    }
    make_heap(hp.begin(), hp.end(), cmp);
    sort_heap(hp.begin(), hp.end(), cmp);
    for (int i = 0; i < n - 1; i++) {
        if (hp.empty()) {
            cout << "��empty" << endl;
            return;
        }
        tempFirst = hp.front();
        first = new HuffmanNode();
        first->data = tempFirst.data;
        first->ch = tempFirst.ch;
        first->leftchild = tempFirst.leftchild;
        first->rightchild = tempFirst.rightchild;
        first->parent = tempFirst.parent;
        hp.erase(hp.begin());

//        cout << "��firstȡ������ɾ��,��ֵΪ " << (*first).data;
//        cout << " ,��Ӧ���ַ�Ϊ " << (*first).ch << " ,ɾ����Ķ���Ԫ��: " << endl;
//        display(hp);

        tempSecond = hp.front();
        second = new HuffmanNode();
        second->data = tempSecond.data;
        second->ch = tempSecond.ch;
        second->leftchild = tempSecond.leftchild;
        second->rightchild = tempSecond.rightchild;
        second->parent = tempSecond.parent;
        hp.erase(hp.begin());

//        cout << "��secondȡ������ɾ��,��ֵΪ " << (*second).data;
//        cout << " ,��Ӧ���ַ�Ϊ " << (*second).ch << " ,ɾ����Ķ���Ԫ��: " << endl;
//        display(hp);

        mergeTree(first, second, parent);
        hp.push_back(*parent);
        make_heap(hp.begin(), hp.end(), cmp);
        sort_heap(hp.begin(), hp.end(), cmp);

//        cout << "�� " << (*first).data << " �� " << (*second).data << " merge��Ȼ��õ�ֵ ";
//        cout << (*parent).data << " ,��Ӧ�ַ�Ϊ " << (*parent).ch;
//        cout << " ,������������Ԫ��: " << endl;
//        display(hp);
//        cout << endl;
    }
    root = parent;
}


void HuffmanTree::buildHuffmanTree(const float *w, const char *ch, int n) {
    //Ϊ���������棬root = 0����ʵû��Ҫ�����root = parent
    //�Ѿ�������������
    root = nullptr;
    vector<HuffmanNode> hp;
    HuffmanNode *parent = 0, *first, *second, *work;
    HuffmanNode tempFirst, tempSecond;
    charactor = new char[n];
    //��ɱ�����ַ�
    for (int i = 0; i < n; i++) {
        charactor[i] = ch[i];
    }
    charactorSize = 0;


    for (int i = 0; i < n; i++) {
        work = new HuffmanNode;
        work->data = w[i];
        work->ch = ch[i];
        work->leftchild = nullptr;
        work->rightchild = nullptr;
        work->parent = nullptr;
        hp.push_back(*work);
        //make_heap(hp.begin(), hp.end(), cmp);
        //sort_heap(hp.begin(), hp.end(), cmp);
    }
    make_heap(hp.begin(), hp.end(), cmp);
    sort_heap(hp.begin(), hp.end(), cmp);
    for (int i = 0; i < n - 1; i++) {
        if (hp.empty()) {
            cout << "��empty" << endl;
            return;
        }
        tempFirst = hp.front();
        first = new HuffmanNode();
        first->data = tempFirst.data;
        first->ch = tempFirst.ch;
        first->leftchild = tempFirst.leftchild;
        first->rightchild = tempFirst.rightchild;
        first->parent = tempFirst.parent;
        hp.erase(hp.begin());

//        cout << "��firstȡ������ɾ��,��ֵΪ " << (*first).data;
//        cout << " ,��Ӧ���ַ�Ϊ " << (*first).ch << " ,ɾ����Ķ���Ԫ��: " << endl;
//        display(hp);

        tempSecond = hp.front();
        second = new HuffmanNode();
        second->data = tempSecond.data;
        second->ch = tempSecond.ch;
        second->leftchild = tempSecond.leftchild;
        second->rightchild = tempSecond.rightchild;
        second->parent = tempSecond.parent;
        hp.erase(hp.begin());

//        cout << "��secondȡ������ɾ��,��ֵΪ " << (*second).data;
//        cout << " ,��Ӧ���ַ�Ϊ " << (*second).ch << " ,ɾ����Ķ���Ԫ��: " << endl;
//        display(hp);

        mergeTree(first, second, parent);
        hp.push_back(*parent);
        make_heap(hp.begin(), hp.end(), cmp);
        sort_heap(hp.begin(), hp.end(), cmp);

//        cout << "�� " << (*first).data << " �� " << (*second).data << " merge��Ȼ��õ�ֵ ";
//        cout << (*parent).data << " ,��Ӧ�ַ�Ϊ " << (*parent).ch;
//        cout << " ,������������Ԫ��: " << endl;
//        display(hp);
//        cout << endl;
    }
    root = parent;
}

void HuffmanTree::deleteTree(HuffmanNode *t) {
    if (t != nullptr) {
        deleteTree(t->leftchild);
        deleteTree(t->rightchild);
        delete t;
    }
    root = nullptr;
}


void HuffmanTree::mergeTree(HuffmanNode *h1, HuffmanNode *h2, HuffmanNode *&parent) {
    parent = new HuffmanNode;
    parent->leftchild = h2;//�����ݿ��ұ�
    parent->rightchild = h1;
    parent->data = h1->data + h2->data;
    h1->parent = h2->parent = parent;
}


void display(vector<HuffmanNode> &v)//ʹ��vector����������
{
    vector<HuffmanNode>::iterator i;
    for (i = v.begin(); i < v.end(); i++) {
        cout << (*i).data << " ";
    }
    cout << endl;
    for (i = v.begin(); i < v.end(); i++) {
        cout << (*i).ch << " ";
    }
    cout << endl << endl;
}


void HuffmanTree::LevelOrder() {
    int IsEven = 1;
    queue<HuffmanNode *> Q;
    HuffmanNode *p;
    Q.push(root);
    while (!Q.empty()) {
        IsEven = 1;
        int width = Q.size();
        for (int i = 0; i < width; i++) {
            p = Q.front();
            Q.pop();
            IsEven = (IsEven + 1) % 2;
            cout << setw(4) << p->data << "__" << setw(3) << p->ch;
            if (IsEven && i != width - 1)
                cout << " , ";
            if (p->leftchild != 0)
                Q.push(p->leftchild);
            if (p->rightchild != 0)
                Q.push(p->rightchild);
        }
        cout << endl;
    }
    cout << endl << endl << endl;
}


void HuffmanTree::PrintGeneralizedList() {
    PrintGeneralizedList(root);
    cout << endl;
}


void HuffmanTree::PrintGeneralizedList(HuffmanNode *BT) {
    if (BT != nullptr) {
        cout << BT->data << "  " << BT->ch;
        if (BT->leftchild != 0 || BT->rightchild != 0) {
            cout << "(";
            PrintGeneralizedList(BT->leftchild);
            if (BT->rightchild != 0) {
                cout << ",";
                PrintGeneralizedList(BT->rightchild);
            }
            cout << ")";
        }
    }
}

void HuffmanTree::setCode() {
    if (root == nullptr) {
        cout << "����Ϊ�գ��޷����ñ���" << endl;
        return;
    }
    setCode("", root);
}


void HuffmanTree::setCode(string s, HuffmanNode *ptr) {
    if (ptr != nullptr) {
        ptr->code = s;
        setCode(s + "0", ptr->leftchild);
        setCode(s + "1", ptr->rightchild);
    }
}

void HuffmanTree::getCode() {
    if (root == nullptr) {
        cout << "����Ϊ�գ��޷����б���" << endl;
        return;
    }
    stack<HuffmanNode *> S;
    HuffmanNode *p = root;
    do {
        while (p != nullptr) {
            S.push(p);
            if (p->leftchild == nullptr && p->rightchild == nullptr) {
                map[p->ch] = p->code;
                charactor[charactorSize] = p->ch;
                charactorSize++;
                cout << p->ch << ":" << p->code << " ";
            }
            p = p->leftchild;
        }
        if (!S.empty()) {
            p = S.top();
            S.pop();
            p = p->rightchild;
        }
    } while (p != nullptr || !S.empty());
    cout << endl << "����ɹ�";
    cout << endl;
}

void HuffmanTree::enCoding(string originalFile, string encodingFile) {
    string str[100];
    char ch;
    string temp1 = originalFile;
    string temp2 = encodingFile;
    originalFile = "./FirstProject/Chenhongy/HuffmanTree/Files/" + originalFile;
    ifstream infile(originalFile, ios::in);
    encodingFile = "./FirstProject/Chenhongy/HuffmanTree/Files/" + encodingFile;
    ofstream outfile(encodingFile, ios::out);
    if (!infile) {
        cerr << "open error when read file" << endl;
        exit(1);
    }
    if (!outfile) {
        cerr << "open error when write file" << endl;
        exit(1);
    }
    while (infile.get(ch)) {
        if (ch == ' ') {
            outfile << ' ';
        } else {
            outfile << map[ch % 256];
        }
    }
    infile.close();
    outfile.close();
    cout << endl << "�� ";
    cout << temp1 << " ���뵽 " << temp2 << " ��" << endl;
    cout << endl;
}

void HuffmanTree::BuildDeCodingTree() {
    if (root == nullptr) {
        cout << "����Ϊ��,���ܽ�������" << endl;
        return;
    }
    deleteTree(root);
    char ch;
    string code;
    HuffmanNode *p, *q;
    root = new HuffmanNode;
    for (int i = 0; i < charactorSize; i++) {
        ch = charactor[i];
        code = map[ch];
        p = root;
        //�������ڶ������룬�������һ�����뵥������
        for (int j = 0; j < code.length() - 1; j++) {
            if (code[j] == '0') {
                if (p->leftchild == nullptr) {
                    q = new HuffmanNode;
                    p->leftchild = q;
                }
                p = p->leftchild;
            } else { //code[j] == '1'
                if (p->rightchild == nullptr) {
                    q = new HuffmanNode;
                    p->rightchild = q;
                }
                p = p->rightchild;
            }
        }
        //��Ϊ�����һ����Ҷ�ӽ�㣬�϶�Ҫnew
        q = new HuffmanNode;
        //ֻ��chҪ�õ�������Ĭ�ϼ���
        q->ch = ch;
        if (code[code.length() - 1] == '0') {
            p->leftchild = q;
        } else {
            p->rightchild = q;
        }
    }
    cout << "�������������." << endl << endl;
}

void HuffmanTree::deCoding(string encodingFile, string outputFile) {
    char ch;
    HuffmanNode *p = root;
    string temp1 = encodingFile;
    string temp2 = outputFile;
    encodingFile = "./FirstProject/Chenhongy/HuffmanTree/Files/" + encodingFile;
    outputFile = "./FirstProject/Chenhongy/HuffmanTree/Files/" + outputFile;
    ifstream infile(encodingFile, ios::in);
    ofstream outfile(outputFile, ios::out);
    if (!infile) {
        cerr << "open error when read file" << endl;
        exit(1);
    }
    if (!outfile) {
        cerr << "open error when write file" << endl;
        exit(1);
    }
    while (infile.get(ch)) {
        if (ch == ' ')
            outfile << ' ';
        else {
            if (ch == '0' && p->leftchild != nullptr) {
                //����Ҷ�ӽ�㣬û�����ݣ�����
                p = p->leftchild;
            } else if (ch == '1' && p->rightchild != nullptr) {
                //����Ҷ�ӽ�㣬û�����ݣ�����
                p = p->rightchild;
            }
            if (p->leftchild == nullptr && p->rightchild == nullptr) {
                //��Ҷ�ӽ�㣬�����ݣ���ʼ��һ�β���
                outfile << p->ch;
                p = root;
            }
        }
    }
    infile.close();
    outfile.close();
    cout << "���ѱ����ļ� " << temp1 << " ���뵽 " << temp2 << " �����" << endl;
    cout << endl << endl;
}


int main() {

//    float test[10] = {1, 5, 2, 6, 3, 7, 8, 4, 9, 10};
//    char testch[10] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
//    HuffmanTree ht1(test, testch, 10);

    HuffmanTree ht1;
    cout << "�����ɹ�" << endl;


//    ht1.LevelOrder();
//    cout << endl;
//    ht1.PrintGeneralizedList();

    ht1.setCode();
    ht1.getCode();
    ht1.enCoding("a.txt", "encodedFile.txt");
    ht1.BuildDeCodingTree();

//    ht1.LevelOrder();
//    ht1.PrintGeneralizedList();
    ht1.deCoding("encodedFile.txt", "b.txt");

    cout << endl;
//    system("pause");
}

