#include <iostream>
#include <cstring> //memset
#include <vector>
#include <queue>
#include <algorithm> //sort

using namespace std;

int N;
int total = 0; //총 단지 수

char map[25][25];
int visit[25][25];
int answer[10001] = {0, };

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

queue<pair<int,int> > q;

int main()
{
	cin >> N;
	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			cin >> map[i][j];
			visit[i][j] = 0;
		}
	}

	int x, y, nx, ny;

	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			if(visit[i][j] == 0 && map[i][j] == '1')
			{
				//bfs
				total++;
				q.push(make_pair(i,j));
				visit[i][j] = 1;

				while(!q.empty())
				{
					answer[total]++;
					x = q.front().first;
					y = q.front().second;

					q.pop();

					for(int i=0; i<4; i++)
					{
						nx = x + dx[i];
						ny = y + dy[i];

						if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						if(visit[nx][ny] == 1 || map[nx][ny] == '0') continue;

						visit[nx][ny] = 1;
						q.push(make_pair(nx,ny));

					}
				}
			}
		}
	}

	sort(answer, answer+total+1);

	cout << total << endl;

	for(int i=1; i<=total; i++)
		cout << answer[i] << endl;

	return 0;
}