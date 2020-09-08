#include <iostream>
#include <string>

using namespace std;

int main()
{
	int n;
	string test;
	cin >> n;

	while(n--)
	{
		cin >> test;

		int cnt = 0;
		int ans = 0;
		int arr[80] = {0};

		for(int i=0; i<test.length(); i++)
		{
			if(test[i] == 'O')
			{
				cnt++;
				arr[i] = cnt;
			}
			else
				cnt = 0;
		}
		
		for(int i=0; i<test.length(); i++)
		{
			ans += arr[i];
		}

		cout << ans << endl;
	}
}