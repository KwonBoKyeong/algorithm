#include <iostream>
#include <deque>

using namespace std;

int main() {

	int N;
	string s;
	int c;

	cin >> N;

	deque<int> dq;

	for(int i=0; i<N; i++) 
	{
		cin >> s;

		if(s == "push_front")
		{
			cin >> c;
			dq.push_front(c);
		}
		else if(s == "push_back")
		{
			cin >> c;
			dq.push_back(c);
		}
		else if(s == "pop_front")
		{
			if(!dq.empty())
			{
				cout << dq.front() << endl;
				dq.pop_front();
			}
			else 
				cout << "-1" << endl;
		}
		else if(s == "pop_back")
		{
			if(!dq.empty())
			{
				cout << dq.back() << endl;
				dq.pop_back();
			} 
			else 
				cout << "-1" << endl;
		}
		else if(s == "size")
			cout << dq.size() << endl;
		else if(s == "empty")
			cout << dq.empty() << endl;
		else if(s == "front")
		{
			if(!dq.empty())
			{
				cout << dq.front() << endl;
			} 
			else 
				cout << "-1" << endl;
		}
		else if(s == "back")
		{
			if(!dq.empty())
			{
				cout << dq.back() << endl;
			} 
			else 
				cout << "-1" << endl;
		}
		
	}

	return 0;
}