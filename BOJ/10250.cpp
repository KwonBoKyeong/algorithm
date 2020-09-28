#include <iostream>

using namespace std;

int main()
{
	int t, h, w, n;
	cin >> t;

	while(t--)
	{
		cin >> h >> w >> n;
		int y = n % h; //층수
		

		int x = n / h + 1; //호수

		if(y == 0)
		{
			y = h;
			x -= 1;
		} 

		cout << y*100 + x << endl;
	}
}