#include <iostream>

using namespace std;

int main()
{
	int n, a;
	cin >> n;
	int cnt = 0;

	for(int i=0; i<n; i++)
	{
		cin >> a;
		if(a == 1)
			cnt++;
	}

	if(cnt > n/2)
		cout << "Junhee is cute!" << endl;
	else
		cout << "Junhee is not cute!" << endl;

	return 0;
}