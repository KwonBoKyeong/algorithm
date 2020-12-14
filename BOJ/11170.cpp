#include <iostream>
#include <string>

using namespace std;

int main()
{
	int t, n, m;

	cin >> t;

	while(t--)
	{
		int cnt = 0;
		cin >> n >> m;

		for(int i=n; i<=m; i++)
		{
			string s = to_string(i);

			for(int j=0; j<s.size(); j++)
			{
				if(s[j] == '0') cnt++;
			}

		}
		

		cout << cnt << endl;
	}
}