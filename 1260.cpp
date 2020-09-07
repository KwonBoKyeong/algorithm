#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int map[1001][1001];
int visit[1001];
queue<int> q;
int N, M, V, a, b; //N:정점의 개수, M:간선의 개수, V:탐색 시작 정점의 번호

void dfs(int V)
{
	cout << V << " ";
	visit[V] = 1;
	for(int i=1; i<=N; i++) 
	{
		if(map[V][i] == 1 && visit[i] == 0) 
			dfs(i);
	}
}


void bfs(int V) 
{
	visit[V] = 1;
	q.push(V);

	while(!q.empty())
	{
		V = q.front();
		q.pop();

		cout << V << " ";
		for(int i=1; i<=N; i++)
		{
			if(map[V][i] == 1 && visit[i] == 0)
			{
				q.push(i);
				visit[i] = 1;
			}
		}
	}
	cout << endl;
}


int main() 
{
	cin >> N >> M >> V;

	memset(map,0,sizeof(map));
	memset(visit,0,sizeof(visit)); 

	for(int i=0; i<M; i++)
	{
		cin >> a >> b;

		map[a][b] = 1;
		map[b][a] = 1;
	}

	dfs(V);
	cout << endl;
	memset(visit,0,sizeof(visit)); 
	bfs(V);

	
	return 0;
}