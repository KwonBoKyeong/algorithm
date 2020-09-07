#include <iostream>

using namespace std;

int main()
{
	int h, m;
	cin >> h >> m;

	if(m - 45 < 0)
	{
		m = m - 45 + 60;
		h -= 1;
	}
	else m -= 45;
	
	if(h < 0)
	{
		h+=24;
	}

	cout << h << " " << m << endl;
}