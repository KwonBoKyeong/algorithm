#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int map[51][51];
queue<pair<int, int> > q;

int dx[8] = {1,0,-1,0,1,1,-1,-1};
int dy[8] = {0,1,0,-1,1,-1,1,-1};

int main()
{
	int w, h;

	while(1)
	{
		int ans = 0;

		cin >> w >> h;

		if(w == 0 && h == 0) break;

		memset(map, 0, sizeof(map));

		for(int i=0; i<h; i++)
		{
			for(int j=0; j<w; j++)
			{
				cin >> map[i][j];
			}
		}

		for(int i=0; i<h; i++)
		{
			for(int j=0; j<w; j++)
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

						for(int i=0; i<8; i++)
						{
							int nx = x + dx[i];
							int ny = y + dy[i];

							if(0 > nx || nx >= h || 0 > ny || ny >= w) continue;
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