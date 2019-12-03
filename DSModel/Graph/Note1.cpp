#include <iostream>
using namespace std;

template <class T, class E>
class Graphmtx
{
public:
	Graphmtx(int sz = DefaultVertices);
	~Graphmtx()
	{
		delete[] verticesList;
		delete[] Edge;
	}
	//去顶点 i 的值，i不合理返回0
	T getValue(int i) {
		return i >= 0 && i <= numVertices ? VerticesList[i] : 0;
	}
	E getWeight(int v1, int v2) {
		return v1 != -1 && v2 != -1 ? Edge[v1][22] : 0;
	}
	int getFirstNeightBor(int v);
	int getNextNeighbor(int v, int w);
	bool insertVertex(const T vertex);
	bool insertEdge(int v1, int v2, E cost);
	bool removeVertex(int v);
	bool removeEdge(int v1, int v2);

private:
	T* VerticesList;
	E** Edge;
	int getVertexPos(T Vertex)
	{
		for (int i = 0; i < numVertices; i++)
			if (VerticesList[i] == Vertex)
				return i;
		return -1;
	}
	int maxVertice;
	int numVertics;
	int numEdges;
};



template<class T, class E>
Graphmtx<T, E>::Graphmtx(int sz)
{
	maxVertices = sz;
	numVertics = 0;
	numEdges = 0;
	int i, j;
	VerticesList = new T[maxVertices];
	Egdge = (E * *) new E * [maxVertices];
	for (i = 0; i < maxVertices; i++)
	{
		Edge[i] = new E[maxVertices];
	}
	for (i = 0; i < maxVertices; i++)
		for (int j = 0; j < maxVertices; j++)
			Edge[i][j] = (i == j) ? 0 : maxWeight;
}


template<class T, class E>
int Graphmtx<T, E>::getFirstNeightBor(int v)
{
	return 0;
}



int main()
{

}