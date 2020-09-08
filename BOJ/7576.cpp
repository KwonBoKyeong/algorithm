#include <iostream>
#include <queue>

using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,-1,0,1};

int tomato[1001][1001];
int visit[1001][1001];

int m,n;

int main()
{
	cin >> m >> n;
	queue<pair<int, int> > q;

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			cin >> tomato[i][j];
			visit[i][j] = 0;
			if(tomato[i][j] == 1) 
			{
				q.push(make_pair(i,j));
				visit[i][j] = 1;
			}
		}
	}

	int ans = 0;

	//bfs
	while(!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for(int i=0; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if(tomato[nx][ny] != 0 || visit[nx][ny] == 1) continue;

			visit[nx][ny] = visit[x][y] + 1;
			q.push(make_pair(nx,ny));
			tomato[nx][ny] = 1;
		}
	}

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			ans = max(ans, visit[i][j]);
			if(tomato[i][j] == 0)
			{
				cout << -1 << endl;
				return 0;
			}
		}
	}
	cout << ans-1 << endl;
}