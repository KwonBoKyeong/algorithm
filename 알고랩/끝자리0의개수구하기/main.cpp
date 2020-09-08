#include <iostream>
#include <stdio.h>

using namespace std;

int two(int a)
{
  int two=0;
  while(a%2 == 0)
  {
    two++;
    a /= 2;
  }

  return two;
}

int five(int a)
{
  int five=0;
  while(a%5 == 0)
  {
      five++;
      a/=5;
  }

  return five;
}

int main()
{
  int t;
  cin >> t;

  for(int i=0; i<t; i++)
  {
    int fivenum = 0;
    int twonum = 0;

    int n;
    cin >> n;

    for(int i=0; i<n; i++)
    {
      int num;

      cin >> num;

      twonum += two(num);
      fivenum += five(num);

    }

    if(fivenum<twonum)
      cout << fivenum << endl;

    else
      cout << twonum << endl;

  }

  return 0;
}
