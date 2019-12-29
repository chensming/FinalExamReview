#include <iostream>
using namespace std;

struct BTreeNode{
    int data;  
    BTreeNode* leftchild;
    BTreeNode *rightchild;
};


int ancestors[50];
int pos = 0;

bool Getancestors(BTreeNode *t, int x)
{
    if( t == 0 ) 
        return false;
    if(Getancestors(t->leftchild) || Getancestors(t->rightchild))
    {
        ancestors[pos] = t->data;
        pos++;
        return true;
    }
    if(t->data == x)
        return true;
    return false;
}


void main()
{
    //........
    BTreeNode *t;
    int x;
    if(Getancestors(t, x))
    {
        cout << "found!";
        if(pos == 0)
            cout << "No parent" << endl;
        else
        {
            /* 输出ancestors数组里的内容 */
        }
        
    }
    else
    {
        cout << "Not found!";
    }
    
}