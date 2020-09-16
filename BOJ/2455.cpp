#include <iostream>
#include <algorithm>

using namespace std;

int main() 
{
	int num = 0;
	int ans = 0;
	int plus, minus;
	for(int i=0; i<4; i++)
	{
		cin >> minus >> plus;

		num -= minus;
		num += plus;
		ans = max(num, ans);
	}

	cout << ans << endl;
}