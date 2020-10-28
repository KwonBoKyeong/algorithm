#include <iostream>
#include <cstring>
#include <queue>
#include <utility>

using namespace std;

int map[101][101];
int visit[101][101];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main()
{
	int n, m, k, r, c;
	memset(map, 0, sizeof(map));
	memset(visit, 0, sizeof(visit));

	cin >> n >> m >> k;

	for(int i=0; i<k; i++)
	{
		cin >> r >> c;
		map[r-1][c-1] = 1;
	}

	int max = 0;
	queue<pair<int, int> > q;

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(map[i][j] == 1 && visit[i][j] == 0)
			{
				int cnt = 0;

				visit[i][j] = 1;
				q.push(make_pair(i,j));

				while(!q.empty())
				{
					cnt++;
					int x = q.front().first;
					int y = q.front().second;

					q.pop();

					for(int i=0; i<4; i++)
					{
						int nx = x + dx[i];
						int ny = y + dy[i];

						if(map[nx][ny] == 0 || visit[nx][ny] == 1) continue;
						if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

						q.push(make_pair(nx, ny));
						visit[nx][ny]= 1;
					}
				}
				if(cnt > max) max = cnt;
			}
		}
	}

	cout << max << endl;

	return 0;



}