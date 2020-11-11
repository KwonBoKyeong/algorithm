#include <iostream>

using namespace std;

int main()
{
	int burg = 3000;
	int drink = 3000;
	int n;
	for(int i=0; i<3; i++)
	{
		cin >> n;
		if(burg > n) burg = n;
	}
	for(int i=0; i<2; i++)
	{
		cin >> n;
		if(drink > n) drink = n;
	}

	cout << drink + burg - 50 << endl;

}