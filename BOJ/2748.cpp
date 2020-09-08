#include <iostream>

using namespace std;

long long dp[1000] = {0};

long long fibo(int n)
{
	if(n <= 2) return 1;
	if(dp[n] == 0)
	{
		dp[n] = fibo(n-1) + fibo(n-2);
	}
	return dp[n];
}

int main()
{
	int n;

	cin >> n;

	cout << fibo(n) << endl;;

	return 0;
}