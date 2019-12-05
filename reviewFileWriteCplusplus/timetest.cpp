#include <iostream>
using namespace std;
#include <time.h>

int seqsearch(int a[], const int n, const int x)
{
    int i ;
    for ( i = 0; i < n; i++)
    {
        if (a[i] == x)
            break;
    }
    if (i == n)
        return -1;
    else
        return i;
}

void TimeSearch()
{
    int a[1001], n;
    long start, stop;
    for (int i = 0; i < 1000; i++)
    {
        a[i] = i + 1;
    }
    cin >> n;
    time(&start);
    int k = seqsearch(a, n, 0);
    time(&stop);
    long runTime = stop - start;
    cout << " " << n << " " << runTime << endl;
    cout << "k:" << k <<endl;
}

int main()
{
    TimeSearch();
    system("pause");
}