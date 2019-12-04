bool Getancestors(BTreeNode *t)
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
    if(Getancestors(t))
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