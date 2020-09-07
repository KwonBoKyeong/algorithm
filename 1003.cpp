#include <iostream>
#include <vector>

using namespace std;

int dp0[50] = {-1};
int dp1[50] = {-1};

int main()
{
	int T, N;
	cin >> T;

	dp0[0] = 1;
	dp1[0] = 0;
	dp0[1] = 0;
	dp1[1] = 1;

	for(int i=2; i<=40; i++)
	{
		dp0[i] = dp0[i-2] + dp0[i-1];
		dp1[i] = dp1[i-2] + dp1[i-1];
	}

	for(int i=0; i<T; i++)
	{
		cin >> N;
		cout << dp0[N] << " " << dp1[N] << endl;
	}
}