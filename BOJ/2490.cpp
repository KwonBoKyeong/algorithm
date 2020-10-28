#include <iostream>

using namespace std;

int main()
{
	int t = 3;
	int n;
	while(t--)
	{
		char c;
		int cnt = 0;

		for(int i=0; i<4; i++)
		{
			cin >> n;
			if(n == 1) cnt++;
		}

		if(cnt == 3) c = 'A';
		if(cnt == 2) c = 'B';
		if(cnt == 1) c = 'C';
		if(cnt == 0) c = 'D';
		if(cnt == 4) c = 'E';

		cout << c << endl;
	}
}