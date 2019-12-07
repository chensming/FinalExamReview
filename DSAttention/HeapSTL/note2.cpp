#include<vector>
#include<iostream>
#include<algorithm>

using namespace std;

struct w {
	int data;
	char ch;
};




bool cmp(const w& a, const w& b)
{
	return a.data < b.data;
}


int main()
{
	w test[10] = { {1,'a'},{5,'e'},{2,'b'},{6,'f'},{3,'c'},{7,'g'},{8,'h'},{4,'d'},{9,'i'},{0,'j'} };
	vector<w> v1(test, test + 10);

	make_heap(v1.begin(), v1.end(), cmp);
	sort_heap(v1.begin(), v1.end(), cmp);
	
	for (int i = 0; i < 10; i++) {
		cout << v1[i].ch << " ";
	}

	cout << endl;

	return 0;
}
