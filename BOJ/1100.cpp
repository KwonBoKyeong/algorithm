#include <iostream>

using namespace std;

int main()
{
	char c;
	int cnt =0 ;
	for(int i=0; i<8; i++)
	{
		for(int j=0; j<8; j++)
		{
			cin >> c;
			if((i+j) % 2 == 0 && c == 'F')
				cnt++;
		}
	}
	cout << cnt << endl;
}