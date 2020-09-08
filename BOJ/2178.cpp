#include <iostream>
#include <queue>
#include <cstring> //memset
#include <utility> //pair

using namespace std;

string map[101];
int visit[1001][1001];
queue<pair<int,int> > q;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int N, M; 

int main() 
{
	cin >> N >> M;

	for(int i=0; i<N; i++)
	{
		cin >> map[i];
	}

	memset(visit,-1,sizeof(visit)); 

	visit[0][0] = 0;
	q.push(make_pair(0,0));

	while(!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for(int i=0; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(visit[nx][ny] >= 0 || map[nx][ny] == '0') continue;
			
			visit[nx][ny] = visit[x][y]+1;
			q.push(make_pair(nx,ny));
		}
	}

	cout << visit[N-1][M-1]+1 << endl;

	
	return 0;
}