#include <iostream>
#include <queue>
#include <utility>
#include <cstring>

using namespace std;

int map[301][301];

int dx[8] = {-2,-1,1,2,2,1,-1,-2};
int dy[8] = {1,2,2,1,-1,-2,-2,-1};

int main()
{
	int t, l, nowX, nowY, nextX, nextY;
	cin >> t;

	while(t--)
	{
		cin >> l >> nowX >> nowY >> nextX >> nextY;

		memset(map, -1, sizeof(map));

		queue<pair<int, int> > q;

		q.push(make_pair(nowX,nowY));
		map[nowX][nowY]++;

		while(!q.empty())
		{
			int x = q.front().first;
			int y = q.front().second;

			q.pop();

			if(x == nextX && y == nextY) break;

			for(int i=0; i<8; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
				if(map[nx][ny] != -1) continue;

				map[nx][ny] = map[x][y] + 1;

				q.push(make_pair(nx, ny));
			}
		}

		cout << map[nextX][nextY] << endl;
	}

	return 0;
}