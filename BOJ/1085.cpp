#include <iostream>

using namespace std;

int main()
{
	int x,y,w,h;
	cin >> x >> y >> w >> h;

	int ans = h-y;

	if(x < ans)
		ans = x;
	if(w-x < ans)
		ans = w-x;
	if(y < ans) 
		ans = y;
	

	cout << ans << endl;
	return 0;
}