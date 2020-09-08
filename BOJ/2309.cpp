#include <iostream>
#include <algorithm>

using namespace std;

int main() {

	int arr[9];
	int sum = -100;
	int check = 0;

	for(int i=0; i<9; i++)
	{
		cin >> arr[i];
		sum += arr[i]; //총 난쟁이들의 키
	}

	for(int i=0; i<8; i++)
	{
		for(int j=i+1; j<9; j++)
		{
			if(arr[i]+arr[j] == sum)
			{
				arr[i] = 200;
				arr[j] = 201;
				check = 1;
			}
		}
		if(check == 1)
			break;
	}

	sort(arr,arr+9);

	for(int i=0; i<7; i++)
		cout << arr[i] << endl;

	return 0;
}