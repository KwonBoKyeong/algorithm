#include <iostream>
#include <vector>

using namespace std;

vector<int> v[7];

int main() {

	int N, P;
	cin >> N >> P;

	int cnt = 0;
	int n,p;

	for(int i=0; i<N; i++)
	{
		cin >> n >> p;
		if(v[n].size() == 0) //새로운 줄인 경우
		{
			cnt++;
			v[n].push_back(p);
			continue;
		}
		
		while(v[n].size() != 0 && v[n].back() > p)
		{
			v[n].pop_back();
			cnt++;
		}
		if(v[n].back() == p) continue;

		v[n].push_back(p);
		cnt++;
		
	}

	cout << cnt << endl;


	return 0; 
}