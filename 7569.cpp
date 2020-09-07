#include <iostream>
#include <queue>

using namespace std;


int dx[6] = {1,0,-1,0,0,0};
int dy[6] = {0,-1,0,1,0,0};
int dz[6] = {0,0,0,0,1,-1};

int tomato[101][101][101];
int visit[101][101][101];

int m,n,h;
queue<pair<int, pair<int, int> > >q;

int main()
{
	cin >> m >> n >> h;

	for(int k=0; k<h; k++)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				cin >> tomato[k][i][j];
				visit[k][i][j] = 0;
				if(tomato[k][i][j] == 1) 
				{
					q.push(make_pair(k, make_pair(i,j)));
					visit[k][i][j] = 1;
				}	
			}
		}
	}

	int ans = 0;

	//bfs
	while(!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second.first;
		int z = q.front().second.second;
		q.pop();

		for(int i=0; i<6; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			int nz = z + dz[i];

			if(nx < 0 || ny < 0 || nz < 0 || nx >= h || ny >= n || nz >= m) continue;
			if(tomato[nx][ny][nz] != 0 || visit[nx][ny][nz] == 1) continue;

			visit[nx][ny][nz] = visit[x][y][z] + 1;
			q.push(make_pair(nx, make_pair(ny,nz)));

			tomato[nx][ny][nz] = 1;
		}
	}

	for(int k=0; k<h; k++)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				ans = max(ans, visit[k][i][j]);
				if(tomato[k][i][j] == 0)
				{
					cout << -1 << endl;
					return 0;
				}
			}
		}
	}

	cout << ans-1 << endl;
}