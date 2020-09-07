#include <iostream>
#include <queue>

using namespace std;

int main() {
	int t, N, M, a;
	queue<int> q;

	cin >> t;

	while(t--)
	{
		cin >> N >> M;
		
		for(int i=0; i<N; i++)
		{
			cin >> a;
			q.push(a);
		}

		int cnt;

		while(1)
		{
			for(int i=9; i>0; i--)
			{
				if(q.front() == i)
				{
					cnt++;
					q.pop();
				}
				else
				{
					q.push(q.front());
					q.pop();
				}
			}
		}


	}





	return 0;
}