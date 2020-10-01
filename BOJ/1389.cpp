#include <iostream>
#include <cstring>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

int d[101][101];

vector<pair<int, int> > v;

bool compare(pair<int, int>a, pair<int, int>b) {
	return a.second < b.second;
}

int main()
{
	int n, m, a, b;
	cin >> n >> m;

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			d[i][j] = 10;
		}
	}

	for(int i=0; i<m; i++)
	{
		cin >> a >> b;
		d[a-1][b-1] = 1;
		d[b-1][a-1] = 1;
	}

	for (int k = 0; k < n; ++k) {

    	for (int i = 0; i < n; ++i) {

	        for (int j = 0; j < n; ++j) {

	            if (d[i][k] + d[k][j] < d[i][j])
	            {
	                d[i][j] = d[i][k] + d[k][j];
	            }
        	}
    	}
	}

	for(int i=0; i<n; i++)
	{
		int cnt = 0;

		for(int j=0; j<n; j++)
		{
			if(i != j)
				cnt += d[i][j];
		}

		v.push_back(make_pair(i+1, cnt));
	}

	sort(v.begin(), v.end(), compare);

	cout << v[0].first << endl;

	return 0;

}