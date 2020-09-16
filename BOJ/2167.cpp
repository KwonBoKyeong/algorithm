#include <iostream>

using namespace std;

int main()
{
	int n, m, num;
	int arr[500][500];

	cin >> n >> m;
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=m; j++)
		{
			cin >> num;
			arr[i][j] = num;
		}
	}


	int t,i,j,x,y;
	cin >> t;

	while(t--)
	{
		int sum = 0;
		cin >> i >> j >> x >> y;

		for(int a=i; a<=x; a++)
		{
			for(int b=j; b<=y; b++)
			{	
				sum += arr[a][b];
			}
		}
		cout << sum << endl;
	}
}