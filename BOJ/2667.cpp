#include <iostream>
#include <cstring> //memset
#include <vector>
#include <queue>
#include <algorithm> //sort

using namespace std;

int N, ans;
char map[25][25];
int visit[25][25];
int total = 0; //총 단지 수
int answer[10001] = {0, };

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

void dfs(int x, int y)
{
	visit[x][y] = 1;
	answer[total]++;

	for(int i=0; i<4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];

		if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
		if(visit[nx][ny] == 0 && map[nx][ny] == '1') dfs(nx,ny);
	}
}

int main()
{
	memset(visit, 0, sizeof(visit));

	cin >> N;
	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
			cin >> map[i][j];
	}

	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			if(map[i][j] == '1' && visit[i][j] == 0)
			{
				dfs(i,j);
				total++;
			}
		}
	}

	sort(answer, answer+total);

	cout << total << endl;

	for(int i=0; i<total; i++)
		cout << answer[i] << endl;

	return 0;
}