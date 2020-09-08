#include <iostream>
#include <cstdlib>
#include <cmath>
#include <algorithm>

using namespace std;

int closestNumber(int n, int m);

int main(void)
{
  int t;
  int n, m;
  cin >> t;
  for(int i=0; i<t; i++)
  {
    cin >> n >> m;
    cout << closestNumber( n, m ) << endl;
  }
  return 0;
}

int closestNumber(int n, int m)
{
  int a;
  int i=0;

  while(1)
  {
    if((n+i)%m ==0 && (n-i)%m ==0)
    {
      if(n-i<0)
        a = n-i;
      else
        a = n+i;
      break;
    }
    else if((n+i) % m == 0)
    {
      a = n+i;
      break;
    }
    else if((n-i) % m == 0)
    {
      a = n-i;
      break;
    }
    else
    {
      i++;
      continue;
    }
  }

  return a;
}
