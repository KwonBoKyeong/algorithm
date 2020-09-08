#include <iostream>

using namespace std;

int main()
{
	int n;
	int cnt = 0;
	for(int i=0; i<5; i++)
	{
		cin >> n;
		if(n < 40)
			cnt += 40;
		else
			cnt += n;
	}

	cout << cnt/5 << endl;
}