#include <iostream>
#include <set>

using namespace std;

int main()
{
	int n, m;
	string name;

	cin >> n >> m;

	set<string> s;
	set<string> ans;

	for(int i=0; i<n; i++)
	{
		cin >> name;
		s.insert(name);
	}


	for(int i=0; i<m; i++)
	{
		cin >> name;
		auto it = s.find(name);
    	if(it != s.end()){
        	ans.insert(*it); 
    	}
	}

	cout << ans.size() << endl;

	for(auto it = ans.begin(); it != ans.end(); it++){
		cout << *it << '\n';
	}


}