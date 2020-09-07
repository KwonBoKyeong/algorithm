#include <iostream>

using namespace std;

int main()
{

	int N, M, sum;
	cin >> N;
	int answer = 0;

	for(int i=0; i<=N; i++)
	{
		M=i;
		sum = 0;
		while(M!=0)
		{
			sum += (M%10);
			M /= 10;
		}

		if(N == sum + i)
		{
			answer = i;
			break;
		}		
	}
	cout << answer << endl;

	return 0;
}
