#include <iostream>

using namespace std;

int main()
{
	int numTestCases;
	cin >> numTestCases;
	int a,b;
	char c;
	for(int i=0; i<numTestCases; i++)
	{
		cin >> a >> c >> b;
		cout << a+b <<endl;
	}
	return 0;
}