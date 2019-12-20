//
// Created by Dell on 2019/12/15.
//
#include <iostream>
#include <queue>
#include <iomanip>
#include <vector>
#include <algorithm>


using namespace std;
const int maxWeight = 9999;
const int DefaultVertices = 30;

#include "UFsets.h"


template<class T, class E>
struct MSTEdgeNode {
    int tail, head;
    E cost;
};

template<class T, class E>
bool cmp(const MSTEdgeNode<T, E> &a, const MSTEdgeNode<T, E> &b) {
    return a.cost < b.cost;  //����
}


template<class T, class E>
struct Edge {
    int dest;    //�ߵ���һ������λ��
    E cost;            //���ϵ�Ȩֵ
    Edge<T, E> *link;

    Edge() : dest(-1), cost(-1), link(nullptr) {}

    Edge(int num, E weight) : dest(num), cost(weight), link(0) {}
};

template<class T, class E>
struct Vertex {
    T data;
    Edge<T, E> *adj;
};

template<class T, class E>
class GraphLinked {
public:
    explicit GraphLinked(int sz = DefaultVertices);

    ~GraphLinked();

    T getValue(int i) {
        return (i >= 0 && i < numVertices) ? NodeTable[i].data : 0;
    }

    E getWeight(int v1, int v2);

    bool insertVertex(const T &vertex);

    bool removeVertex(int v);

    bool insertEdge(int v1, int v2, E weight);

    bool removeEdge(int v1, int v2);

    int getFirstNeighbor(int v);

    int getNextNeighbor(int v, int w);

    void CreateNodeTable();

    void PrintDest(); //���ڽӱ�����������
    void KruskalMinTree();

    void PrimMinTree();

    void Dijkstra();

    void printMinTree();

    //����
    void DFS();

    void BFS();


private:
    int numVertices;
    int maxVertices;
    int numEdges;
    bool *visited; //����dfs��bfs

    Vertex<T, E> *NodeTable; //����
    MSTEdgeNode<T, E> *mst;//��С����������

    int getVertexPos(const T vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (NodeTable[i].data == vertex)
                return i;
        }
        return -1;
    }

    void DFS(int v);
};


template<class T, class E>
GraphLinked<T, E>::GraphLinked(int sz) {
    mst = nullptr;
    maxVertices = sz;
    numVertices = 0;
    numEdges = 0;
    visited = nullptr;

    NodeTable = new Vertex<T, E>[maxVertices];
    if (NodeTable == nullptr) {
        cerr << "�ִ�������" << endl;
        exit(1);
    }
    for (int i = 0; i < maxVertices; i++) {
        NodeTable[i].adj = nullptr;
    }
}


template<class T, class E>
GraphLinked<T, E>::~GraphLinked() {
    for (int i = 0; i < numVertices; i++) {
        Edge<T, E> *p = NodeTable[i].adj;
        while (p != nullptr) {
            NodeTable[i].adj = p->link;
            delete p;
            p = NodeTable[i].adj;
        }
    }
    delete[]NodeTable;
}


template<class T, class E>
E GraphLinked<T, E>::getWeight(int v1, int v2) {
    if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
        Edge<T, E> *p = NodeTable[v1].adj;
        while (p != nullptr && p->dest != v2) {
            p = p->link;
        }
        if (p != nullptr)
            return p->cost;  //�ҵ��˱�,����Ȩֵ
    }
    return 0;
}


template<class T, class E>
bool GraphLinked<T, E>::insertVertex(const T &vertex) {
    if (numVertices == maxVertices)
        return false;
    NodeTable[numVertices].data = vertex;
    numVertices++;
    return true;
}


template<class T, class E>
bool GraphLinked<T, E>::removeVertex(int v) {
    if (numVertices == 1 || v < 0 || v >= numVertices)
        return false;
    Edge<T, E> *p, *s, *t;
    int k;
    while (NodeTable[v].adj != nullptr) {
        p = NodeTable[v].adj;
        k = p->dest;
        s = NodeTable[k].adj;  //�ҶԳƴ�ŵı߽��
        t = nullptr;                 //t �� s��ǰһ��ָ�룬����s�ߣ��������ɾ�����
        while (s != nullptr && s->dest != v) {
            t = s;
            s = s->link;
        }
        if (s != nullptr) {
            if (t == nullptr)
                NodeTable[k].adj = s->link;
            else
                t->link = s->link;
            delete s;
        }

        NodeTable[v].adj = p->link;
        delete p;
        numEdges--;
    }

    numVertices--;   //ͼ�Ķ�������1
    NodeTable[v].data = NodeTable[numVertices].data;  //�����һ��������
    p = NodeTable[v].adj = NodeTable[numVertices].adj;
    while (p != nullptr) {
        s = NodeTable[p->dest].adj;
        while (s != nullptr) {
            if (s->dest == numVertices) {
                //��ԭ������ΪnumVertices�ĸ�Ϊv,��Ϊ���Ѿ��ᵽv��
                s->dest = v;
                break;
            } else
                s = s->link;
        }
        ///////////////////////////////////////////////
        //����û��������
        p = p->link;
        //////////////////////////////////////////////
    }

    return true;
}


template<class T, class E>
bool GraphLinked<T, E>::insertEdge(int v1, int v2, E weight) {
    if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
        Edge<T, E> *q, *p = NodeTable[v1].adj;
        while (p != nullptr && p->dest != v2)
            p = p->link;
        if (p != nullptr)
            return false; //���д˱�,����p��ʱ��Ϊ0
        p = new Edge<T, E>;
        q = new Edge<T, E>;

        p->dest = v2;
        p->cost = weight;
        q->dest = v1;
        q->cost = weight;

        //ͷ����v1�ı�����
        p->link = NodeTable[v1].adj;
        NodeTable[v1].adj = p;

        //ͷ����v2�ı�����
        q->link = NodeTable[v2].adj;
        NodeTable[v2].adj = q;


        numEdges++;
        return true;
    }
    return false;
}


template<class T, class E>
bool GraphLinked<T, E>::removeEdge(int v1, int v2) {
    if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
        Edge<T, E> *p = NodeTable[v1].adj;
        Edge<T, E> *q = 0, *s = p; //q��p��һ��ָ��,����ɾ������

        while (p != 0 && p->dest != v2) {
            q = p;
            p = p->link;
        }
        if (p != 0) {
            if (p == s)    //Ҫɾ�Ľ�㱻ͷָ��ָ��
                NodeTable[v1].adj = p->link;
            else
                q->link = p->link;
            delete p;
        } else
            return false; // p == 0��û�ҵ�������

        p = NodeTable[v2].adj;  //v2��Ӧ��������ɾ��
        q = 0;
        s = p;
        while (p->dest != v1) {
            q = p;
            p = p->link;
        }
        if (p == s)   //Ҫɾ�Ľ�㱻ͷָ��ָ��
            NodeTable[v2].adj = p->link;
        else
            q->link = p->link;
        delete p;
        return true;
    }
    return false;
}


template<class T, class E>
int GraphLinked<T, E>::getFirstNeighbor(int v) {
    if (v >= 0 && v < numVertices) {
        Edge<T, E> *p = NodeTable[v].adj;
        if (p != nullptr)
            return p->dest;//���ڣ����ص�һ���ٽ��
    }
    return -1;
}


template<class T, class E>
int GraphLinked<T, E>::getNextNeighbor(int v, int w) {
    if (v >= 0 && v < numVertices) {
        Edge<T, E> *p = NodeTable[v].adj;
        while (p != nullptr && p->dest != nullptr)
            p = p->link;
        if (p != nullptr && p->link != nullptr)
            return p->link->dest;
    }
    return -1;  //-1��������
}


//�����ڽӱ�ṹ
template<class T, class E>
void GraphLinked<T, E>::CreateNodeTable() {
    int n, i, j, m;
    Edge<T, E> *p;

    cout << "������Ҫ�����Ľ�����" << endl;
    cin >> n; //������
    if (n > maxVertices) {
        cout << "�����������" << endl;
        return;
    }
    numVertices = n;
    for (i = 0; i < n; i++) {
        NodeTable[i].adj = 0;  //Ԥ��Ϊ����
        cout << "��������Ϊ " << i << "�Ľ���ֵ: ";
        cin >> NodeTable[i].data;

        cout << "������" << NodeTable[i].data << "���ڽӵ������";
        cin >> m;
        cout << "���������� " << m << "���ڽӵ�(���ڶ����� Ȩ��)" << endl;
        for (j = 0; j < m; j++) {
            p = new Edge<T, E>;
            cin >> p->dest;
            cin >> p->cost;
            //ͷ���뽨��
            p->link = NodeTable[i].adj;
            NodeTable[i].adj = p;
        }
    }
}


template<class T, class E>
void GraphLinked<T, E>::DFS(int v) {
    visited[v] = true;
    cout << NodeTable[v].data << " ";
    Edge<T, E> *p = NodeTable[v].adj;
    while (p != 0) {
        if (!visited[p->dest])
            DFS(p->dest);
        p = p->link;
    }
}


template<class T, class E>
void GraphLinked<T, E>::DFS() {
    visited = new bool[numVertices];
    for (int i = 0; i < numVertices; i++)
        visited[i] = false;
    int v0;
    cout << "������������ȱ����ĳ������ţ�0�� " << numVertices - 1 << endl;
    cin >> v0;
    DFS(v0);
    cout << endl << endl;
}


template<class T, class E>
void GraphLinked<T, E>::BFS() {
    visited = new bool[numVertices];
    for (int i = 0; i < numVertices; i++)
        visited[i] = false;
    int v;
    Edge<T, E> *p;
    queue<int> Q;
    cout << "�����������ȱ����ĳ������ţ�0�� " << numVertices - 1 << endl;
    cin >> v;
    Q.push(v);

    while (!Q.empty()) {
        v = Q.front();
        Q.pop();
        if (!visited[v]) {
            visited[v] = true;
            cout << NodeTable[v].data << " ";
            p = NodeTable[v].adj;
            while (p != 0) {
                if (!visited[p->dest])
                    Q.push(p->dest);
                p = p->link;
            }
        }
    }
    cout << endl << endl;
}


template<class T, class E>
void GraphLinked<T, E>::PrintDest() {
    Edge<T, E> *p;
    for (int i = 0; i < numVertices; i++) {
        cout << "-----��" << "���Ϊ " << i << " ,ֵΪ ";
        cout << NodeTable[i].data << " �����ĵ� : ����ֵ(���,Ȩֵ)" << endl;
        p = NodeTable[i].adj;
        while (p != 0) {
            cout << NodeTable[p->dest].data;
            cout << "( " << p->dest << ", " << p->cost << ")" << " ";
            p = p->link;
        }
        cout << endl << endl;
    }
    cout << endl << endl;
}

template<class T, class E>
void GraphLinked<T, E>::KruskalMinTree() {
    if (mst != nullptr)
        delete[] mst;
    mst = new MSTEdgeNode<T, E>[numVertices];

    if (visited != nullptr)
        delete[] visited;
    visited = new bool[numVertices];
    for (int i = 0; i < numVertices; i++) {
        visited[i] = false;
    }

    MSTEdgeNode<T, E> *p, leastNode;
    vector<MSTEdgeNode<T, E>> hp;
    UFsets fsets(numVertices);

    //��ʼ������
    Edge<T, E> *edgePtr;
    for (int i = 0; i < numVertices; i++) {
        edgePtr = NodeTable[i].adj;
        while (edgePtr != nullptr) {
            if (!visited[edgePtr->dest]) {

            }
            p = new MSTEdgeNode<T, E>;
            p->tail = i;
            p->head = edgePtr->dest;
            p->cost = edgePtr->cost;
            hp.push_back(*p);
            edgePtr = edgePtr->link;
        }
    }
    make_heap(hp.begin(), hp.end(), cmp<T, E>);
    sort_heap(hp.begin(), hp.end(), cmp<T, E>);
    display(hp);

    int count = 1; //��С������������
    while (count < numVertices) {
        leastNode = hp.front();
        hp.erase(hp.begin());

        int u = fsets.Find(leastNode.tail);
        int v = fsets.Find(leastNode.head);
        if (u != v) { //���������·
            fsets.Union(u, v);
            mst[count - 1] = leastNode;
            cout << leastNode.tail << "(" << NodeTable[leastNode.tail].data << ")->";
            cout << leastNode.head << "(" << NodeTable[leastNode.head].data;
            cout << "),w(" << leastNode.cost << ")  ";
            count++;
        }
    }
    cout << endl;
    if (count == numVertices)
        cout << "��С����������" << endl;
}


template<class T, class E>
void GraphLinked<T, E>::PrimMinTree() {
    if (mst != nullptr)
        delete mst;
    mst = new MSTEdgeNode<T, E>[numVertices];
    MSTEdgeNode<T, E> *p, leastNode;
    vector<MSTEdgeNode<T, E>> hp;
    UFsets fsets(numVertices);
    if (visited != nullptr)
        delete[] visited;
    visited = new bool[numVertices];

    for (int i = 0; i < numVertices; i++)
        visited[i] = false;

    cout << "������������� 0��" << numVertices - 1 << endl;
    int u;
    cin >> u;
    if (u < 0 || u > numVertices - 1) {
        cout << "��������" << endl;
        return;
    }

    visited[u] = true;
    int count = 1;

    Edge<T, E> *edgePtr;
    while (count < numVertices) {
        edgePtr = NodeTable[u].adj;
        while (edgePtr != nullptr) {
            if (!visited[edgePtr->dest]) {
                p = new MSTEdgeNode<T, E>;
                p->tail = u;
                p->head = edgePtr->dest;
                p->cost = edgePtr->cost;

                hp.push_back(*p);
            }
            edgePtr = edgePtr->link;
        }
        make_heap(hp.begin(), hp.end(), cmp<T, E>);
        sort_heap(hp.begin(), hp.end(), cmp<T, E>);
        while (!hp.empty() && count < numVertices) {
            leastNode = hp.front();
            hp.erase(hp.begin());
            if (!visited[leastNode.head]) {
                mst[count - 1] = leastNode;
                cout << leastNode.tail << "(" << NodeTable[leastNode.tail].data << ")->";
                cout << leastNode.head << "(" << NodeTable[leastNode.head].data;
                cout << "),w(" << leastNode.cost << ")  ";
                u = leastNode.head;
                visited[u] = true;
                count++;
                break;
            }
        }
    }
    cout << endl;
}

template<class T, class E>
void GraphLinked<T, E>::Dijkstra() {
    int v0;
    E *dist = new E[numVertices];
    for (int i = 0; i < numVertices; i++)
        dist[i] = maxWeight;

    if (visited != nullptr)
        delete[] visited;
    visited = new bool[numVertices];

    for (int i = 0; i < numVertices; i++)
        visited[i] = false;
    int pos;


    cout << "������������� 0��" << numVertices - 1 << endl;
    cin >> v0;
    if (v0 < 0 || v0 > numVertices - 1) {
        cout << "��������" << endl;
        return;
    }
    dist[v0] = 0;
    //��ʼ������
    Edge<T, E> *edgePtr = NodeTable[v0].adj;
    while (edgePtr != nullptr) {
        dist[edgePtr->dest] = edgePtr->cost;
        edgePtr = edgePtr->link;
    }
    visited[v0] = true;

    int count = 1;
    while (count < numVertices) {
        E min = 9999;
        for (int k = 0; k < numVertices; k++) {
            if (!visited[k] && dist[k] < min) {
                pos = k;
                min = dist[k];
            }
        }
        visited[pos] = true;
        count++;
        edgePtr = NodeTable[pos].adj;
        while (edgePtr != nullptr) {
            if (!visited[edgePtr->dest] && edgePtr->cost + min < dist[edgePtr->dest])
                dist[edgePtr->dest] = edgePtr->cost + min;
            edgePtr = edgePtr->link;
        }
    }
    cout << NodeTable[v0].data << "�����������̾���ֱ�Ϊ" << endl;
    for (int i = 0; i < numVertices; i++)
        cout << "To--" << NodeTable[i].data << ":" << dist[i] << "  ";


    delete[] dist;
    delete[] visited;
}


template<class T, class E>
void display(vector<MSTEdgeNode<T, E>> &v)//ʹ��vector����������
{
    //vector<MSTEdgeNode<T, E> >::iterator iter;
    for (auto iter = v.begin(); iter < v.end(); iter++) {
        cout << (*iter).tail << "->" << (*iter).head << " : " << (*iter).cost << endl;
    }
    cout << endl << endl;
}


template<class T, class E>
void GraphLinked<T, E>::printMinTree() {
    if (mst == 0) {
        cout << "��С������Ϊ��" << endl;
        return;
    }
    for (int i = 0; i < numVertices - 1; i++)
        cout << mst[i].tail << "->" << mst[i].head << "(" << mst[i].cost << ")" << endl;
}


int main() {
    GraphLinked<char, double> a;
    //a.CreateNodeTable();

    //��ͼ�Ƚ�������

    //�Ȳ��붥��
    a.insertVertex('a');
    a.insertVertex('b');
    a.insertVertex('c');
    a.insertVertex('d');
    a.insertVertex('e');

    a.insertEdge(0, 1, 2.7);
    a.insertEdge(0, 2, 4.1);
    a.insertEdge(0, 4, 8.8);
    a.insertEdge(1, 3, 3.2);
    a.insertEdge(1, 4, 8.0);
    a.insertEdge(2, 3, 6.7);
    a.insertEdge(3, 4, 5.4);

    a.PrintDest();

//    cout << endl << "kruskal: " << endl;
//    a.KruskalMinTree();

//    cout << endl << "prim: " << endl;
//    a.PrimMinTree();

    a.Dijkstra();

    cout << endl;
}






