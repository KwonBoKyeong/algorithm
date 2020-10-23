#include <iostream>
#include <vector>

using namespace std;

int main()
{
	vector<int> v;

	for(int i=0; i<5; i++)
	{
		int sum = 0;
		for(int j=0; j<4; j++)
		{
			int num;
			cin >> num;
			sum += num;
		}
		v.push_back(sum);

	}

	int max = 0;
	int idx = 0;

	for(int i=0; i<v.size(); i++)
	{
		if(v[i] > max)
		{
			max = v[i];
			idx = i;
		}
	}

	cout << idx+1 << " " << max << endl;
}