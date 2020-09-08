#include <iostream>
#include <queue>

using namespace std;

int main() {

	int N;
	string s;
	int c;

	cin >> N;

	queue<int> q;

	for(int i=0; i<N; i++) 
	{
		cin >> s;

		if(s == "push")
		{
			cin >> c;
			q.push(c);
		}
		else if(s == "pop")
		{
			if(!q.empty())
			{
				cout << q.front() << endl;
				q.pop();
			} 
			else 
				cout << "-1" << endl;
		}
		else if(s == "size")
			cout << q.size() << endl;
		else if(s == "empty")
			cout << q.empty() << endl;
		else if(s == "front")
		{
			if(!q.empty())
			{
				cout << q.front() << endl;
			} 
			else 
				cout << "-1" << endl;
		}
		else if(s == "back")
		{
			if(!q.empty())
			{
				cout << q.back() << endl;
			} 
			else 
				cout << "-1" << endl;
		}
		
	}

	return 0;
}