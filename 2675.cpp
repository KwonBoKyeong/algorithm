#include <iostream>
#include <string>

using namespace std;

int main() {
	int n;
	cin >> n;

	for(int i=0; i<n; i++)
	{
		int r;
		string s;
		cin >> r >> s;
		for(int j=0; j<s.size(); j++)
		{
			for(int k=0; k<r; k++)
			{
				cout << s[j];
			}
		}
		cout << endl;
	}
}


