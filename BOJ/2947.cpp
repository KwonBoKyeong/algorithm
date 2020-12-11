#include <iostream>
#include <vector>

using namespace std;

int main()
{
	vector<int> v;
	int n;
	for(int i=0; i<5; i++)
	{
		cin >> n;
		v.push_back(n);
	}

	while(1)
	{
		int tmp;
		if(v[0] > v[1])
		{
			tmp = v[0];
			v[0] = v[1];
			v[1] = tmp;
			for(int i=0; i<5; i++)
				cout << v[i] << " ";
			cout << endl;
		}
		if(v[1] > v[2])
		{
			tmp = v[2];
			v[2] = v[1];
			v[1] = tmp;
			for(int i=0; i<5; i++)
				cout << v[i] << " ";
			cout << endl;
		}
		if(v[2] > v[3])
		{
			tmp = v[2];
			v[2] = v[3];
			v[3] = tmp;
			for(int i=0; i<5; i++)
				cout << v[i] << " ";
			cout << endl;
		}
		if(v[3] > v[4])
		{
			tmp = v[4];
			v[4] = v[3];
			v[3] = tmp;
			for(int i=0; i<5; i++)
				cout << v[i] << " ";
			cout << endl;
		}

		int check = 1;
		for(int i=0; i<5; i++)
		{
			if(v[i] != i+1)
				check = 0;
		}

		if(check == 1)
			break;
	}

}