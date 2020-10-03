#include <iostream>

using namespace std;

int arr[101];

int main()
{
	int n, m;
	cin >> n >> m;

	int ans = 0;
	int min = 9999999;
	int sum;

	for(int i=0; i<n; i++)
	{
		cin >> arr[i];
	}

	for(int i=0; i<n-2; i++)
	{
		for(int j=i+1; j<n-1; j++)
		{
			for(int k=j+1; k<n; k++)
			{
				sum = arr[i] + arr[j] + arr[k];
				if(m-sum >= 0 && min > m-sum)
				{
					min = m - sum;
					ans = sum;
				}
			}
		}
	}

	cout << ans << endl;
	return 0;

}