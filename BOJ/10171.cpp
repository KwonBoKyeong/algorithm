#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, a;

	int min = 1000000;
	int max = -1000000;

	cin >> n;
	for(int i=0; i<n; i++)
	{
		cin >> a ;

		if(min > a) min = a;
		if(max < a) max = a;
	}

	cout << min << " " << max << endl;
}