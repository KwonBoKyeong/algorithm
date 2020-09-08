#include <iostream>
#include <stack>

using namespace std;

int main() {
	int T;
	string s;

	cin >> T;

	while(T--)
	{
		int check = 0;
		stack<char> st;
		cin >> s;

		for(int i=0; i<s.length(); i++)
		{
			if(s[i] == ')')
			{
				if(st.size() == 0) 
				{
					check = 1;
					break;
				}
				else if(st.top() == '(')
					st.pop();
			}
			else
			{
				st.push(s[i]);
			}
		}

		if(check == 1) cout << "NO" << endl;
		else if(st.empty()) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
}