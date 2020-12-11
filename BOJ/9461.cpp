#include <iostream>

using namespace std;

int main()
{
	int t,n;
	cin >> t;

	long long dp[111] = {0};

	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 1;

	for(int i=3; i<110; i++)
	{
		dp[i] = dp[i-2] + dp[i-3];
	}

	while(t--)
	{
		cin >> n;
		cout << dp[n-1] << endl;
	}

}