#include <iostream>

using namespace std;

int main()
{
	int n;
	cin >> n;
	int ans = 0;

	while(1)
	{

		if(n % 5 == 0)
		{
			ans += (n / 5);
			break;
		}

		n -=3;
		ans++;

		if(n < 0) 
		{
			ans = -1;
			break;
		}

	}

	cout << ans << endl;

	return 0;
}