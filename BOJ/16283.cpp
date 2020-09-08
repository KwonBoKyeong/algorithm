#include <iostream>

using namespace std;

int main()
{
	int a,b,n,w;
	cin >> a >> b >> n >> w;

	int cnt = 0;
	int sheep;
	int goat;

	for(int i=1; i<n; i++)
	{
		if(a*(n-i) + b*i == w)
		{
			cnt++;
			sheep = n-i;
			goat = i;
		}
	}

	if(cnt == 1) 
		cout << sheep << " " << goat << endl;
	else
		cout << -1 << endl;
}