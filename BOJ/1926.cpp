#include <iostream>
#include <cstring>
#include <queue>
#include <utility>

using namespace std;

int map[501][501];
int visit[501][501];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main()
{
	int n, m; //n:세로, m:가로
	memset(map, 0, sizeof(map));
	memset(visit, 0, sizeof(visit));
	int max_draw = 0;
	int cnt = 0;

	cin >> n >> m;

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			cin >> map[i][j];
		}
	}

	queue<pair<int, int> > q;

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(map[i][j] == 1 && visit[i][j] == 0)
			{
				cnt++;
				q.push(make_pair(i,j));
				visit[i][j] = 1;

				int tmp = 0;

				while(!q.empty())
				{
					tmp++;

					int x = q.front().first;
					int y = q.front().second;

					q.pop();

					for(int i=0; i<4; i++)
					{
						int nx = x + dx[i];
						int ny = y + dy[i];

						if(map[nx][ny] == 0 || visit[nx][ny] == 1) continue;
						if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

						q.push(make_pair(nx,ny));
						visit[nx][ny] = 1;
					}
				}

				if(tmp > max_draw) max_draw = tmp;
			}
		}
	}
	cout << cnt << "\n" << max_draw << endl;


	return 0;
}