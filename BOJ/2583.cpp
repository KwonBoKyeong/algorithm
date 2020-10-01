#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;

int map[101][101];
int visit[101][101];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int m, n, k, x1, x2, y1, y2;

int cnt = 0;

void dfs(int x, int y)
{
	visit[x][y] = 1;

	cnt++;

	for(int i=0; i<4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];

		if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
		if(visit[nx][ny] == 0 && map[nx][ny] == 0)
			dfs(nx, ny);
	}
}

int main()
{

	vector<int> v;

	memset(map, 0, sizeof(map));
	memset(visit, 0, sizeof(visit));

	cin >> m >> n >> k;

	while(k--)
	{
		cin >> x1 >> y1 >> x2 >> y2;

		for(int j=y1; j<y2; j++)	
		{
			for(int i=x1; i<x2; i++)
			{
				map[i][j] = 1;
			}
		}
	}


	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(map[i][j] == 0 && visit[i][j] == 0)
			{
				cnt = 0;
				dfs(i, j);
				v.push_back(cnt);
			}
		}
	}

	sort(v.begin(), v.end());

	cout << v.size() << endl;

	for(int i=0; i<v.size(); i++)
	{
		cout << v[i] << " ";
	}
	cout << "\n";

}