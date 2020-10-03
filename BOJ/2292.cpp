#include <iostream>

using namespace std;

int main()
{
	int n;
	cin >> n;

	if(n==1)
	{
		cout << 1 << endl;
		return 0;
	}

	int num = 6;
	
	while(true)
	{
		for(int i=1; ;i++)
		{
			if(n-1 < num*i+1)
			{
				cout << i+1 << endl;
				return 0;
			}

			n -= num*i;
		}

	}
}