#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int n, m;
	int arr[1001];
	cin >> n;
	for(int i=0; i<n; i++)
	{
		cin >> m;
		arr[i] = m;
	}

	sort(arr, arr+n);

	int sum = arr[0];

	for(int i=1; i<n; i++)
	{
		arr[i] += arr[i-1];
		sum += arr[i];
	}
	cout << sum << endl;
}