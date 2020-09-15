#include <iostream>

using namespace std;

int main()
{
	int n, c;
	cin >> n;

	for(int i=0; i<9; i++)
	{
		cin >> c;
		n -= c;
	}

	cout << n << endl;

	return 0;
}