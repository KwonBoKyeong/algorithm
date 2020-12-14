#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int t, n;
	cin >> t;
	for(int i=0; i<t; i++)
	{
		vector<int> v;

		for(int j=0; j<10; j++)
		{
			cin >> n;
			v.push_back(n);
		}

		sort(v.begin(), v.end());

		cout << v[7] << endl;
	}

}