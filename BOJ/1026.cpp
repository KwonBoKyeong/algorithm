#include <iostream>
#include <algorithm>

using namespace std;

bool desc(int a, int b)
{
	return a > b;
}

int main()
{
	int n, a, b;
	cin >> n;
	int A[100], B[100];

	for(int i=0; i<n; i++)
	{
		cin >> a;
		A[i] = a;
	}

	for(int i=0; i<n; i++)
	{
		cin >> b;
		B[i] = b;
	}

	sort(A, A+n);
	sort(B, B+n, desc);

	int sum = 0;

	for(int i=0; i<n; i++)
	{
		sum += (A[i] + B[i]);
	}

	cout << sum << endl;

}