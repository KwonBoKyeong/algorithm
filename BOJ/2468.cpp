#include <iostream>
#include <cstring>
#include <algorithm>
#include <array>

using namespace std;

int map[101][101];
int visit[101][101];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int N;
int ans = 1;

int cnt = 0;

void dfs(int h, int x, int y)
{
	visit[x][y] = 1;

	for(int i=0; i<4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];

		if(nx < 0 || ny < 0 || nx >= N || ny >= N)
			continue;
		if(visit[nx][ny] == 0 && map[nx][ny] > h)
			dfs(h,nx,ny);
	}

}


int main()
{
	int max_num = 0;
	int min_num = 1000;

	cin >> N;

	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			cin >> map[i][j];
			max_num = max(max_num, map[i][j]);
			min_num = min(min_num, map[i][j]);
		}
	}

	for(int i=min_num; i<max_num; i++)
	{
		cnt = 0;

		memset(visit, 0, sizeof(visit));

		for(int j=0; j<N; j++)
		{
			for(int k=0; k<N; k++)
			{
				if(map[j][k] > i && visit[j][k] == 0)
				{
					cnt++;
					dfs(i,j,k);
				}
			}
		}

		ans = max(ans, cnt);

	}

	cout << ans << endl;
}