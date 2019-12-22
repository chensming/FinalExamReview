//
// Created by Dell on 2019/12/23.
//

#ifndef FIRSTPROJECT_MINHEAP_H
#define FIRSTPROJECT_MINHEAP_H
//
// Created by Dell on 2019/12/15.
//

#include <iomanip>
#include <iostream>
#include <queue>
using namespace std;
const int DefaultSize = 30;


template<class T>
class MinHeap {
public:
    MinHeap(int sz = DefaultSize);
    MinHeap(T arr[], int n);
    ~MinHeap() { delete[] heap; }
    bool Insert(const T& x);
    bool RemoveMin(T& x);
    bool IsEmpty() const;
    bool IsFull() const;
    void makeEmpty() { currentSize = 0; }
    int GetTreeDepth(int v);
    void PrintHeap();


private:
    T* heap;
    int currentSize;
    int maxHeapSize;
    void siftDown(int start, int m);
    void siftUp(int start);
};


template<class T>
MinHeap<T>::MinHeap(int sz)
{
    maxHeapSize = (DefaultSize > sz) ? DefaultSize : sz;
    heap = new T[maxHeapSize];
    if (heap == 0)
    {
        cerr << "堆存储分配失败" << endl;
        exit(1);
    }
    currentSize = 0;
}


template<class T>
MinHeap<T>::MinHeap(T arr[], int n)
{
    maxHeapSize = (DefaultSize > n) ? DefaultSize : n;
    heap = new T[maxHeapSize];
    if (heap == 0)
    {
        cerr << "堆存储分配错误" << endl;
        exit(1);
    }
    for (int i = 0; i < n; i++)
        heap[i] = arr[i];
    currentSize = n;
    int currentPos = (currentSize - 2) / 2;
    while (currentPos >= 0) {
        siftDown(currentPos, currentSize - 1);
        currentPos--;
    }
}


template<class T>
void MinHeap<T>::siftDown(int start, int m)
{
    int i = start, j = 2 * i + 1;
    T temp = heap[i];
    while (j <= m)
    {
        if (j < m && heap[j] > heap[j + 1])
            j++;
        if (temp < heap[j])
            break;
        else
        {
            heap[i] = heap[j];
            i = j;
            j = 2 * j + 1;
        }
    }
    heap[i] = temp;
}


template<class T>
void MinHeap<T>::siftUp(int start)
{
    int j = start, i = (j - 1) / 2;
    T temp = heap[j];
    while (j > 0)
    {
        if (heap[i] <= temp)
            break;
        else
        {
            heap[j] = heap[i];
            j = i;
            i = (i - 1) / 2;
        }
    }
    heap[j] = temp;
}


template<class T>
bool MinHeap<T>::Insert(const T& x)
{
    if (currentSize == maxHeapSize)
    {
        cerr << "Heap Full" << endl;
        return false;
    }
    heap[currentSize] = x;
    siftUp(currentSize);
    currentSize++;
    return true;
}




template<class T>
bool MinHeap<T>::RemoveMin(T& x)
{
    if (!currentSize)
    {
        cout << "Heap empty" << endl;
        return false;
    }
    x = heap[0];
    heap[0] = heap[currentSize - 1];
    currentSize--;
    siftDown(0, currentSize - 1);
    return true;
}





template<class T>
bool MinHeap<T>::IsEmpty() const
{
    return currentSize == 0;
}







template<class T>
bool MinHeap<T>::IsFull() const
{
    return currentSize == maxHeapSize;
}





template<class T>
int MinHeap<T>::GetTreeDepth(int v)
{
    int depth = 0;
    while (v < currentSize)
    {
        v = 2 * v + 1;
        depth++;
    }
    return depth;
}

template<class T>
void MinHeap<T>::PrintHeap()
{
    int IsEven= 1;
    queue<int> Q;
    int v;
    Q.push(0);
    while (!Q.empty())
    {
        IsEven = 1;
        int width = Q.size();
        for (int i = 0; i < width; i++)
        {
            v = Q.front();
            Q.pop();
            IsEven = (IsEven+1) % 2;
            cout << setw(4) << heap[v];
            if (IsEven && i != width - 1)
                cout << " , ";
            if (2 * v + 1 < currentSize)
                Q.push(2 * v + 1);
            if (2 * v + 2 < currentSize)
                Q.push(2 * v + 2);
        }
        cout << endl;
    }
    cout << endl << endl << endl;
}






#endif //FIRSTPROJECT_MINHEAP_H
