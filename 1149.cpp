#include <iostream>

using namespace std;

int cost[1001][3];
int dp[1001][3];

int main()
{
	int n;
	cin >> n;

	for(int i=0; i<n; i++) //집
	{
		for(int j=0; j<3; j++) //RGB
		{
			cin >> cost[i][j];
		}
	}

	dp[0][0] = cost[0][0]; //첫번째 집, R
	dp[0][1] = cost[0][1]; //두번째 집, G
	dp[0][2] = cost[0][2]; //세번째 집, B

	for(int i=1; i<n; i++)
	{
		dp[i][0] = min(dp[i-1][1] , dp[i-1][2]) + cost[i][0];
		dp[i][1] = min(dp[i-1][0] , dp[i-1][2]) + cost[i][1];
		dp[i][2] = min(dp[i-1][0] , dp[i-1][1]) + cost[i][2];
	}

	cout << min(dp[n-1][0],min(dp[n-1][1],dp[n-1][2])) << endl;

}