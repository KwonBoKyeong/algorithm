#include <iostream>

using namespace std;

int dp[11];

int main()
{
	int n, m;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	for(int i=4; i<11; i++)
	{
		dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
	}

	cin >> n;
	while(n--)
	{
		cin >> m;
		cout << dp[m] << endl;
	}
}