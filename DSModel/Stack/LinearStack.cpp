#include<iostream>
using namespace std;

const int maxSize = 200;  //栈的最大容量

template<class T>
class Stack
{
public:
	Stack(); 
	~Stack();
	bool IsEmpty();
	bool IsFull();
	bool GetTop(T& x);
	bool Push(T x);
	bool Pop(T& x);
	bool Pop();
	void PrintFBottomToTop();

private:
	int CurrentSize;
	T data[maxSize];
};


template<class T>
Stack<T>::Stack()
{
	CurrentSize = 0;
}



template<class T>
Stack<T>::~Stack()
{
	CurrentSize = 0;
}


template<class T>
bool Stack<T>::IsEmpty()
{
	return (CurrentSize == 0) ? true : false;
}


template<class T>
bool Stack<T>::IsFull()
{
	return (CurrentSize == maxSize) ? true : false;
}


template<class T>
bool Stack<T>::GetTop(T& x)
{
	if (IsEmpty())
		return false;
	x = data[CurrentSize - 1];
	return true;
}


template<class T>
bool Stack<T>::Push(T x)
{
	if (IsFull())
		return false;
	data[CurrentSize++] = x;
	return true;
}



template<class T>
bool Stack<T>::Pop()
{
	if (IsEmpty())
		return false;
	CurrentSize--;
	return true;
}


template<class T>
bool Stack<T>::Pop(T& x)
{
	if (IsEmpty())
		return false;
	x = data[CurrentSize - 1];
	CurrentSize--;
	return true;
}


//从栈底到栈顶遍历
template<class T>
void Stack<T>::PrintFBottomToTop()
{
	if (IsEmpty())
	{
		cout << "栈为空" << endl;
		return;
	}
	cout << "栈中内容" << endl;
	for (int i = 0; i < CurrentSize; i++)
	{
		cout << data[i] << " ";
	}
}



template<class T>
void IsPushSucc(Stack<T>& a, T x)
{
	if (a.Push(x))
	{
		cout << "push " << x << " 成功" << endl;
	}
	else
	{
		cout << "push " << x << " 成功" << endl;
	}
}



template<class T>
void IsGetTop(Stack<T>& a, T& x)
{
	if (a.GetTop(x))
	{
		cout << "getTop " << x << " 成功" << endl;
	} 
	else
	{
		cout << "Stack is empty! So getTop failed!" << endl;
	}
}



template<class T>
void IsPopSucc(Stack<T>& a, T& x)
{
	if (a.Pop(x))
	{
		cout << "pop " << x << " 成功" << endl;
	}
	else
	{
		cout << "Stack is empty! So Pop failed!" << endl;
	}
}




template<class T>
void PrintIsEmpty(Stack<T>& a)
{
	if (a.IsEmpty())
	{
		cout << "Stack is empty" << endl;
	}
	else
	{
		cout << "Stack isn't empty" << endl;
	}
}


template<class T>
void PrintIsFull(Stack<T>& a)
{
	if (a.IsFull())
	{
		cout << "Stack is Full" << endl;
	}
	else
	{
		cout << "Stack isn't Full" << endl;
	}
}









int main()
{
	Stack<int> a;
	int x = 0;
	PrintIsEmpty(a);
	cout << endl;
	PrintIsFull(a);

	cout << endl;
	IsPopSucc(a, x);


	
	IsPushSucc(a, 6);
	IsPushSucc(a, 34);
	IsPushSucc(a, 75);
	IsPushSucc(a, 68);
	IsPushSucc(a, -50);
	IsPushSucc(a, 800);
	IsPushSucc(a, 67);
	IsPushSucc(a, -92);
	IsPushSucc(a, 167); 
	IsPushSucc(a, 485);
	IsPushSucc(a, 605);
	IsPushSucc(a, 735);

	cout << endl;
	IsGetTop(a, x);
	cout << "pop()..." << endl;
	a.Pop();
	IsPopSucc(a, x);
	a.PrintFBottomToTop();	
	
	cout << endl;
}