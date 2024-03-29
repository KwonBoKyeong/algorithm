#include <iostream>

using namespace std;

int n, m;
int visit[100] = {0,};
int arr[100] = {0,};

void dfs(int cnt)
{
	if(cnt == m)
	{
		int check = 0;
		for(int i=0; i<m-1; i++) 
		{
			if (arr[i] > arr[i+1]) 
			{
				check = 1;
				break;
			}
		}

		if(check == 0)
		{
			for(int i=0; i<cnt; i++)
			{
				cout << arr[i] << " ";
			}
			cout << "\n";
		}		
	}

	else
	{
		for(int i=1; i<=n; i++)
		{
			if(visit[i] == 0)
			{
				visit[i] = 1;
				arr[cnt] = i;
				dfs(cnt+1);
				visit[i] = 0;
			}
		}
	}
}

int main()
{
	cin >> n >> m;

	dfs(0);

	return 0;	
}