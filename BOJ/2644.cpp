#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

queue<int> q;
int visit[102];
int map[102][102];

int main()
{

	int n, m, a, b;

	cin >> n >> a >> b >> m;

	memset(visit, 0, sizeof(visit)); //0으로 초기화
	memset(map, 0, sizeof(map)); //0으로 초기화

	for(int i=0; i<m; i++)
	{
		int x,y;
		cin >> x >> y;
		map[x][y] = 1;
		map[y][x] = 1;
	}

	visit[a] = 0;
	q.push(a);

	while(!q.empty())
	{
		a = q.front();
		q.pop();

		for(int i=1; i<=n; i++)
		{
			if(map[a][i] == 1 && visit[i] == 0)
			{
				q.push(i);
				visit[i] = visit[a]+1;
			}
		}
	}

	if(visit[b] == 0) cout << -1 << endl;
	else cout << visit[b] << endl;

	return 0;
}


