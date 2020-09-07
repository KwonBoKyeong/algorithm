#include <iostream>
#include <stack>

using namespace std;

int main() 
{
	string s;
	stack<char> st;
	string answer = "";

	cin >> s;

	for(int i=0; i<s.length(); i++)
	{
		if(s[i] == '*' || s[i] == '/')
		{
			while(!st.empty() && (st.top() == '*' || st.top() == '/')) 
			{
				answer += st.top();
				st.pop();
			}
			st.push(s[i]);
		}
		else if(s[i] == '+' || s[i] == '-')
		{
			while (!st.empty() && st.top() != '(')
			{
				answer += st.top();
				st.pop();
			}
			st.push(s[i]);
		}
		else if(s[i] == '(')
		{
			st.push(s[i]);
		}
		else if(s[i] == ')')
		{
			while(!st.empty() && st.top() != '(')
			{
				answer += st.top();
				st.pop();
			}
			st.pop();
		}
		else 
		{
			answer += s[i];
		}
	}

	while(!st.empty())
	{
		answer += st.top();
		st.pop();
	}

	cout << answer << endl;

	return 0;
}