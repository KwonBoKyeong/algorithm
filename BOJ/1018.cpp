#include <iostream>

using namespace std;

int main()
{
	int N, M, answer;
	char arr[51][51];
	int min = 999000;

	cin >> N >> M;	

	for(int i=0; i<N; i++)
	{
		for(int j=0; j<M; j++)
		{
			cin >> arr[i][j];
		}
	}


	for(int bi=0; bi<=N-8; bi++)
	{
		for(int bj=0; bj<=M-8; bj++)
		{
			int sum1 = 0; //첫 시작이 흰 색일 때
			int sum2 = 0; //첫 시작이 검은 색일 때

			for(int i=0; i<8; i++)
			{
				for(int j=0; j<8; j++)
				{
					if((i+j)%2 == 0)
					{
						if(arr[bi+i][bj+j] == 'B') sum1++;
						else sum2++;
					}
					else
					{
						if(arr[bi+i][bj+j] =='W') sum1++;
						else sum2++;
					}
				}
			}

			if(sum1 > sum2 && min > sum2) 
					min = sum2;
			if(sum2 >= sum1 && min > sum1)
					min = sum1;
		}
	}

	cout << min << endl;

	return 0;
}
