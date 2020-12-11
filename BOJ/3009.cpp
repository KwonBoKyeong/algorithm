#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int x1,x2,x3,y1,y2,y3;

	int n, m;

	cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;

	if(x1 == x2) n = x3;
	else if(x2 == x3) n = x1;
	else n = x2;
	
	if(y1 == y2) m = y3;
	else if(y2 == y3) m = y1;
	else m = y2;

	cout << n << " " << m << endl;
}