#include <iostream>
#include <cmath>

using namespace std;

int main()
{
	int m, n;
	cin >> m >> n;

	int arr[101];
	for(int i=1; i<=100; i++)
	{
		arr[i] = i*i;
	}
	
	int cnt = 0;
	int num = 0;
	for(int i=100; i>=1; i--)
	{
		if(m <= arr[i] && arr[i] <= n)
		{
			cnt += arr[i];
			num = arr[i];
		}
	}

	if(cnt == 0)
	{
		cout << -1 << endl;
		return 0;
	}


	cout << cnt << endl;
	cout << num << endl;
	return 0;
}