#include <iostream>
#include <cstring>

using namespace std;

int d[101][101];

int main()
{
	int N;
	cin >> N;

	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			cin >> d[i][j];
		}
	}


	for (int k = 0; k < N; ++k) {

    	for (int i = 0; i < N; ++i) {

	        for (int j = 0; j < N; ++j) {

	            if (d[i][k] == 1 && d[k][j] == 1) {
	                d[i][j] = 1;
	            }

        	}
    	}
	}

	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			cout << d[i][j] << " ";
		}
		cout << "\n";
	}

	return 0;

}