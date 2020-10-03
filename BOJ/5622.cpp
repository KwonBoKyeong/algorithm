#include <iostream>

using namespace std;

int dial[26] = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};

int main()
{
	string s;

	cin >> s;

	int ans = s.size();

	for(int i=0; i<s.size(); i++)
	{
		ans += dial[s[i]-65];
	}

	cout << ans << endl;

}