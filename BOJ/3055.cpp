#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

char map[51][51];
int visit[51][51];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ans;

int main() 
{
	memset(visit, 0, sizeof(visit));
	queue<pair<int, int> > q;
	queue<pair<int, int> > wq; //물

	bool check = false;

	int R, C;
	cin >> R >> C;

	for(int i=0; i<R; i++)
	{
		for(int j=0; j<C; j++)
		{
			cin >> map[i][j];
			if(map[i][j] == 'S') 
			{
				q.push(make_pair(i,j));
			}
			if(map[i][j] == '*')
			{
				wq.push(make_pair(i,j));
			}
		}
	}

	//bfs
	ans = 0;

	while(!q.empty())
	{
		ans++;

		int x, y, nx, ny;
		int wqsize = wq.size();
		int qsize = q.size();

		while(wqsize--)
		{
			x = wq.front().first;
			y = wq.front().second;

			wq.pop();

			for(int i=0; i<4; i++)
			{
				nx = x + dx[i];
				ny = y + dy[i];

				if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
				
				if(map[nx][ny] == '*' || map[nx][ny] == 'X' || map[nx][ny] == 'D' || visit[nx][ny] == 1) continue;

				wq.push(make_pair(nx,ny));
				visit[nx][ny] = 1;
			}

		}

		while(qsize--)
		{
			x = q.front().first;
			y = q.front().second;

			q.pop();

			if(map[x][y] == 'D') 
			{
				check = true;
				break;
			}

			for(int i=0; i<4; i++)
			{
				nx = x + dx[i];
				ny = y + dy[i];

				if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

				if(map[nx][ny] == '*' || map[nx][ny] == 'X' || visit[nx][ny] == 1) continue;

				q.push(make_pair(nx,ny));
				visit[nx][ny] = 1;
			}

		}

		if(check == 1) break;
	
	}

	if(check == 1) cout << ans-1 << endl;
	else cout << "KAKTUS" << endl;

	return 0;
}