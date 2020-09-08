#include <iostream>
#include <cstring>

using namespace std;

int map[101][101];
int visit[101][101];
int N;

void dfs(int x)
{
	for(int i=0; i<N; i++)
	{
		if(map[x][i] == 1 && visit[x][i] == 0)
		{
			visit[x][i] = 1;
			dfs(i);
		}
	}
}

int main()
{
	cin >> N;

	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			cin >> map[i][j];
		}
	}

	for(int i=0; i<N; i++)
	{
		memset(visit, 0, sizeof(visit));
		dfs(i);

		for(int j=0; j<N; j++)
		{
			cout << visit[i][j] << " ";
		}
		cout << endl;

	}


	return 0;

}