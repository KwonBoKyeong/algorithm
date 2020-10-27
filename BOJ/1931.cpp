#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;


bool cmp(const pair<int, int> &a, const pair<int, int> &b)
{
	if(a.second == b.second)
		return a.first < b.first;
    return a.second < b.second;
}

int main()
{
	int n, a, b;
	vector<pair<int, int> > v;

	cin >> n;

	for(int i=0; i<n; i++)
	{
		cin >> a >> b;
		v.push_back(make_pair(a,b));
	}

	sort(v.begin(), v.end(), cmp);

	int num = v[0].second;
	int answer = 1;

	for(int i=1; i<v.size(); i++)
	{
		if(v[i].first >= num)
		{
			answer++;
			num = v[i].second;
		}
	}

	cout << answer << endl;

	return 0;

}