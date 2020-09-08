#include <iostream>
#include <queue>
#include <cstring>
#include <utility>

using namespace std;

int L, R, C, sx, sy, sz, ex, ey, ez;
int dx[6] = {1,0,-1,0,0,0};
int dy[6] = {0,1,0,-1,0,0};
int dz[6] = {0,0,0,0,1,-1};

char map[50][50][50];
int visit[50][50][50];

int main()
{
	while(1)
	{
		memset(visit, -1, sizeof(visit));
		queue<pair<char, pair<char, char> > > q;

		cin >> L >> R >> C;

		if(L==0 && R==0 && C==0) break;

		for(int i=0; i<L; i++)
		{
			for(int j=0; j<R; j++)
			{
				for(int k=0; k<C; k++)
				{
					cin >> map[i][j][k];
					if(map[i][j][k] == 'S')
						sx = i, sy = j, sz = k;
					else if(map[i][j][k] == 'E')
						ex = i, ey = j, ez = k;
				}
			}
		}

		visit[sx][sy][sz] = 0;
		q.push(make_pair(sx,make_pair(sy,sz)));

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

				if(nx < 0 || nx >= L || ny < 0 || ny >= R || nz < 0 || nz >= C) continue;
				if(visit[nx][ny][nz] != -1 || map[nx][ny][nz] == '#') continue;

				visit[nx][ny][nz] = visit[x][y][z] + 1;
				q.push(make_pair(nx, make_pair(ny, nz)));

			}
		}

		if(visit[ex][ey][ez] != -1)
			cout << "Escaped in " << visit[ex][ey][ez] << " minute(s)." << endl;

		else
			cout << "Trapped!" << endl;

	}
	

	return 0;
}