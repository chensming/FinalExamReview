#include<vector>
#include<iostream>
#include<algorithm>

using namespace std;

bool cmp(const int& a, const int& b)
{
    return a > b;
}


int main()
{
    int a[10] = {1,5,2,6,3,7,8,4,9,0};
    vector<int> v1(a,a+10);
    //从大到小 0-size-1
    //make_heap(v1.begin(),v1.end(),greater<int>());
    //sort_heap(v1.begin(),v1.end(),greater<int>());

    //从小到大 0-size-1
    //make_heap(v1.begin(),v1.end(),less<int>());
    //sort_heap(v1.begin(),v1.end(),less<int>());

    //用自定函数
    make_heap(v1.begin(),v1.end(),cmp);
    sort_heap(v1.begin(),v1.end(),cmp);

    for(int i=0; i<10; i++){
        cout << v1[i]<<";";
    }

    cout<<endl;

    return 0;
}
