#include <iostream>
#include <stack>

using namespace std;

int main()
{
	int N;
	cin >> N;

	int cnt = 0;

	for(int i=0; i<N; i++)
	{
		string s;
		cin >> s;

		stack<char> st;

		for(int j=0; j<s.length(); j++) 
		{
			if(st.empty()) 
			{
				st.push(s[j]);
				continue;
			}
			else if(st.top() == s[j])
			{
				st.pop();
			}
			else
				st.push(s[j]);
		}

		if(st.empty()) cnt++;

	}

	cout << cnt << endl;
}