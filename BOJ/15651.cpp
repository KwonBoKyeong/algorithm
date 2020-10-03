#include <iostream>

using namespace std;

int n, m;
int arr[100] = {0,};

void dfs(int cnt)
{
	if(cnt == m)
	{
		for(int i=0; i<cnt; i++)
		{
			cout << arr[i] << " ";
		}
		cout << "\n";
	}

	else
	{
		for(int i=1; i<=n; i++)
		{
			arr[cnt] = i;
			dfs(cnt+1);
		}
	}
}

int main()
{
	cin >> n >> m;

	dfs(0);

	return 0;	
}