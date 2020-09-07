#include <iostream>
#include <vector>

using namespace std;

int n, m, u, v;
int visit[1001] = {0};
vector<int> graph[1001];

int ans = 0;

void dfs(int i)
{
	if(visit[i] == 0)
	{
		visit[i] = 1;

		for(int j=0; j<graph[i].size(); j++)
		{
			dfs(graph[i][j]);
		}
	}
	
}

int main()
{
	cin >> n >> m;

	for(int i=0; i<m; i++)
	{
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	for(int i=1; i<=n; i++)
	{
		if(visit[i] == 0)
		{
			dfs(i);
			ans++;
		}
	}

	cout << ans << endl;
}