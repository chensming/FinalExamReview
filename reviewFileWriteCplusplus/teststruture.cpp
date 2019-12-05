#include <iostream>
using namespace std;

void Josephus(int* A, int n, int s, int m)
{
    int i, j, k, temp;
    if (!m) 
    {
        cerr << "m=0是无效的参数" <<endl;
        return ;
    }
    for(i = 0; i < n; i++)
        A[i] = i + 1;
    i = (s - 1 + n) % n;
    for(k = n; k > 1; i--)
    {
        if(i == k)
            i = 0;
        i = (i + m - 1) % k;
        if(i != k - 1){
            temp = A[i];
            for(j = i; j < k - 1; j++)
                A[j] = A[j + 1];
            A[k - 1] = temp;
        }
    }
     for(k = 0; k < n / 2; k++)
    {
        temp = A[k];
        A[k] = A[n-k-1];
        A[n - k -1] = temp;
    }   
        
}

int main()
{
    int A[58],n,s,m;
    cin>>n>>s>>m;
    Josephus(A,n,s,m);

}