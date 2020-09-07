#include <iostream>

using namespace std;

int main()
{
	int N;
	cin >> N;

	int answer = 0;
	int n = N;
	int a, b;

	while(true)
	{
		answer++;

		a = n / 10; //십의 자리
		b = n % 10; //일의 자리

		if(a+b < 10)
			n = 10*b + a + b;
		else
			n = 10*b + (a+b)%10;

		if(n == N)
			break;
	}

	cout << answer << endl;

	return 0;
}