#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int num;
	int arr[10] = {0};
	cin >> num;

	if (num == 0) arr[0]++;
	while(num>0)
	{
		if(num % 10 == 9) arr[6]++;
		else
			arr[num % 10]++;

		num /= 10;
	}

	arr[6] = (arr[6] + 1)/2;

	int max_set = 0;

	for(int i=0; i<10; i++)
	{
		max_set = max(max_set, arr[i]);
	}

	cout << max_set << endl;
}