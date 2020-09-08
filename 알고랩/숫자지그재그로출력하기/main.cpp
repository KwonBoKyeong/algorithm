#include <iostream>

using namespace std;

void outputZigZag(int n, int k);

int main(void)
{
  int t;
  int n, k;
  cin >> t;
  for(int i=0; i<t; i++)
  {
    cin >> n >> k;
    outputZigZag( n, k );
  }
  return 0;
}


void outputZigZag(int n, int k)
{
  int a = 0;
  for(int i=1; i<=k; i++)
  {
    a += i;
  }

  if(k % 2 == 0)
  {
    int b = a;
    cout << b;
    for(int j=1; j<k; j++)
    {
      cout << "*" << b-1;
      b--;
    }
      cout << endl;
  }

  else
  {
    int c = a-k+1;
    cout << c;
    for(int j=c+1; j<=a; j++)
    {
      cout << "*" << j ;
    }
    cout << endl;
  }

}
