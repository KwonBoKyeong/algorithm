#include <iostream>

using namespace std;

int main()
{
	string s;
	cin >> s;
	int size = s.size()/2;
	int ans = 1;

	for(int i=0; i<size; i++)
	{
		if(s[i] == s[s.size()-1-i])
			continue;
		else
		{
			ans = 0;
			break;
		} 
	}

	cout << ans << endl;
}