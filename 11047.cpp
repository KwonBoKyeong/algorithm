#include <iostream>

using namespace std;

int coin[11] = {0}; //동전의 가치

int main()
{
	int n, k, num;
	cin >> n >> k;

	for(int i=0; i<n; i++)
	{
		cin >> coin[i];
	}

	int cnt = 0;

	for(int i=n-1; i>=0; i--)
	{
		num = k / coin[i];
		cnt += num;
		k -= num*coin[i];
	}
	
	cout << cnt << endl;

}
