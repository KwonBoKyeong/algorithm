#include <iostream>
#include <queue>

using namespace std;

int map[100000] = {0};
int visit[100000] = {0};

int main()
{
	int N, K, x, y;
	cin >> N >> K;

	queue<pair<int, int> > q;
	q.push(make_pair(N,0));

	while(!q.empty())
	{
		x = q.front().first;
		y = q.front().second;
		q.pop();

		if(x < 0 || x > 100000) continue;
		if(visit[x] == 1) continue;
		
		visit[x] = 1;

		if(x == K) break;

		q.push(make_pair(x*2, y+1));
		q.push(make_pair(x+1, y+1));
		q.push(make_pair(x-1, y+1));

	}

	cout << y << endl;

}