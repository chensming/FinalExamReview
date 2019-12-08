#include<iostream>
using namespace std;
#include <fstream>

void saveToFile(string str)
{
	ofstream outfile(str);
	if (!outfile)
	{
		cerr << "open " << str << " error" << endl;
		exit(1);
	}
	char c[80];
	cout << "请输入一行字符串(<80)" << endl;
	cin.getline(c, 80);
	cout << "写入 " << str << "中的内容" << endl;
	for (int i = 0; c[i] != '\0'; i++)
	{
		if ((c[i] >= 65 && c[i] <= 99) || (c[i] >= 97 && c[i] <= 122))
		{
			outfile.put(c[i]);
			cout << c[i] ;
		}
	}
	outfile.close();
	cout << endl;
}


void getFromFile1ToFile2(string str1,string str2)
{
	char ch;
	ifstream infile(str1, ios::in);
	if (!infile)
	{
		cerr << "open " << str1 << " failed";
		exit(1);
 	}

	ofstream outfile(str2, ios::out);
	if (!outfile)
	{
		cerr << "open " << str2 << " error" << endl;
		exit(1);
	}
	cout << "写入" << str2 << " 的内容" << endl;
	while (infile.get(ch))
	{
		if (ch >= 97 && ch <= 122)
			ch = ch - 32;
		outfile.put(ch);
		cout << ch;
	}
	infile.close();
	outfile.close();
}

void display(string str)
{
	ifstream infile(str, ios::in);
	if (!infile)
	{
		cerr << "open " << str << "error" << endl;
		exit(1);
	}
	char ch;
	cout << str << " 中的内容" << endl;
	while (infile.get(ch))
	{
		cout << ch ;
	}

	infile.close();
	cout << endl;
}




int main()
{
	saveToFile("f1.txt");
	getFromFile1ToFile2("f1.txt", "f2.dat");

	cout << endl << endl << endl;
	display("f2.dat");
}