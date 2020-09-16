#include <iostream>
#include <algorithm>
using namespace std;

int main()
{

	int t,hp1,mp1,a1,d1,hp2,mp2,a2,d2;

	cin >> t;

	while(t--)
	{
		cin >> hp1 >> mp1 >> a1 >> d1 >> hp2 >> mp2 >> a2 >> d2;

		hp1 = max(1, hp1+hp2);
		mp1 = max(1, mp1+mp2);
		a1 = max(0, a1+a2);

		int answer = hp1 + 5*mp1 + 2*a1 +2*(d1+d2);

		cout << answer << endl;
	}
	
}