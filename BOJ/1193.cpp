#include <iostream>

using namespace std;

int main()
{
	int n;
	cin >> n;

	int cnt = 1;

	while(cnt < n)
	{	
		n -= cnt;
		cnt++;
	}

	if(cnt % 2 == 1)
	{
		cout << cnt-n+1 << "/" << n << endl;
	}
	else
	{
		cout << n << "/" << cnt-n+1  << endl;
	}
}