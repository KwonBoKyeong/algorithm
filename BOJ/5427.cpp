#include <iostream>
#include <queue>
#include <cstring>
#include <utility>

using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

char map[1001][1001];
int visit[1001][1001];



int t, w, h, ans;

int main()
{
	cin >> t;
	
	while(t--)
	{
		queue<pair<int,int> > q; //상근이 이동 큐
		queue<pair<int,int> > fq; //불 큐
		
		memset(visit, 0, sizeof(visit));
		
		bool check = false;

		cin >> w >> h;

		for(int i=0; i<h; i++)
		{
			for(int j=0; j<w; j++)
			{
				cin >> map[i][j];
				if(map[i][j] == '@')
				{
					q.push(make_pair(i,j));
				}
				else if(map[i][j] == '*')
				{
					fq.push(make_pair(i,j));
				}
			}
		}

		//bfs 
		ans = 0;

		while(!q.empty())
		{	
			ans++;

			int nx, ny, x, y;
			int fqsize = fq.size();
			int qsize = q.size();

			while(fqsize--)
			{
				x = fq.front().first;
				y = fq.front().second;

				fq.pop();

				for(int i=0; i<4; i++)
				{
					nx = x + dx[i];
					ny = y + dy[i];

					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

					if(map[nx][ny] == '*' || map[nx][ny] == '#' || visit[nx][ny] == 1) continue;
					
					fq.push(make_pair(nx,ny));
					visit[nx][ny] = 1;
				}
			}

			while(qsize--)
			{
				x = q.front().first;
				y = q.front().second;
				
				q.pop();

				if(x == 0 || y == 0 || x == h-1 || y == w-1) 
				{
					check = true;
					break;
				}

				for(int i=0; i<4; i++)
				{
					nx = x + dx[i];
					ny = y + dy[i];

					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					
					if(map[nx][ny] == '*' || map[nx][ny] == '#'|| visit[nx][ny] == 1) continue;
					
					q.push(make_pair(nx,ny));
					visit[nx][ny] = 1;
				}

			}
			if ( check) break;
		}


		if(check == true) cout << ans << endl;
		else cout << "IMPOSSIBLE" << endl;
	}

	return 0;
}