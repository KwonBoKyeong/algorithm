#include <iostream>
#include <stack>

using namespace std;

int main() {

	int N;
	string s;
	int c;

	cin >> N;

	stack<int> st;

	for(int i=0; i<N; i++) 
	{
		cin >> s;

		if(s == "push")
		{
			cin >> c;
			st.push(c);
		}
		else if(s == "pop")
		{
			if(!st.empty())
			{
				cout << st.top() << endl;
				st.pop();
			} 
			else 
				cout << "-1" << endl;
		}
		else if(s == "size")
			cout << st.size() << endl;
		else if(s == "empty")
			cout << st.empty() << endl;
		else if(s == "top")
		{
			if(!st.empty())
			{
				cout << st.top() << endl;
			} 
			else 
				cout << "-1" << endl;
		}
		
	}

	return 0;
}