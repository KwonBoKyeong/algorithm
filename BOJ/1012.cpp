#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int map[51][51];
queue<pair<int, int> > q;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main()
{
	int t, m, n, k, a, b;
	cin >> t;

	while(t--)
	{
		int ans = 0;

		cin >> m >> n >> k;

		memset(map, 0, sizeof(map));

		for(int i=0; i<k; i++)
		{
			cin >> a >> b;
			map[b][a] = 1;
		}

		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				if(map[i][j] == 1)
				{
					ans++;
					q.push(make_pair(i,j));

					//BFS
					while(!q.empty())
					{
						int x = q.front().first;
						int y = q.front().second;

						q.pop();

						for(int i=0; i<4; i++)
						{
							int nx = x + dx[i];
							int ny = y + dy[i];

							if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;
							if(map[nx][ny] == 0) continue;

							map[nx][ny] = 0;
							q.push(make_pair(nx, ny));
						}
					}

				}
			}
		}

		cout << ans << endl;
	}

	return 0;
}