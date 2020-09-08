#include <iostream>
#include <cstring> //memset

using namespace std;

int map[101][101];
int visit[101]; 

int ans = 0;
int c, r; //컴퓨터 수, 연결된 컴퓨터 쌍의 수

void dfs(int v)
{
	ans++;
	visit[v] = 1;

	for(int i=1; i<=c; i++) 
	{
		if(map[v][i] == 1 && visit[i] == 0) 
			dfs(i);
	}
}

int main()
{

	cin >> c >> r;

	memset(visit, 0, sizeof(visit));
	memset(map, 0, sizeof(map));

	int x, y;

	for(int i=0; i<r; i++)
	{
		cin >> x >> y;
		map[x][y] = 1;
		map[y][x] = 1;
	}

	dfs(1);

	cout << ans-1 << endl;

	return 0;
}