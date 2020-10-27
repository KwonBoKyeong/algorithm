#include <iostream>
#include <algorithm>

using namespace std;

char board[51][51];
int n;
int max_num = 0;

void cntC()
{
	for(int i=0; i<n; i++)
	{
		int t = 1;
		for(int j=0; j<n; j++)
		{
			if(board[i][j] == board[i][j+1])
				t++;
			else
			{
				if(max_num < t) max_num = t;
				t = 1;
			}
		}
	}
}

void cntR()
{
	for(int i=0; i<n; i++)
	{
		int t = 1;
		for(int j=0; j<n; j++)
		{
			if(board[j][i] == board[j+1][i])
				t++;
			else
			{
				if(max_num < t) max_num = t;
				t = 1;
			}
		}
	}
}

int main()
{
	cin >> n;

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			cin >> board[i][j];
		}
	}

	//가로 방향 바꾸기
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n-1; j++)
		{
			if(board[i][j] != board[i][j+1])
			{
				swap(board[i][j], board[i][j+1]);
				cntR();
				cntC();
				swap(board[i][j], board[i][j+1]);
			}
		}
	}

	//세로 방향 바꾸기
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n-1; j++)
		{
			if(board[j][i] != board[j+1][i])
			{
				swap(board[j][i], board[j+1][i]);
				cntR();
				cntC();
				swap(board[j][i], board[j+1][i]);
			}
		}
	}

	cout << max_num << endl;


}