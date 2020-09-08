#include <iostream>
#include <stack>

using namespace std;

int main() 
{
	int N;
	string s;

	cin >> N >> s;

	int arr[30] = {0}; //각 피연산자에 대응하는 값
	for(int i=0; i<N; i++)
	{
		cin >> arr[i];
	}

	stack<double> st;
	double a,b;

	for(int i=0; i<s.length(); i++)
	{
		if('A' <= s[i] && s[i] <= 'Z') 
		{
			st.push(arr[s[i]-'A']);
		}
		else
		{
			a = st.top();
			st.pop();
			b = st.top();
			st.pop();

			if(s[i] == '*')
				st.push(b*a);
			else if(s[i] == '/')
				st.push(b/a);
			else if(s[i] == '+')
				st.push(b+a);
			else if(s[i] == '-')
				st.push(b-a);

		}
	}

	cout << fixed;
	cout.precision(2);
	cout << st.top() << endl;
	
	return 0;
}