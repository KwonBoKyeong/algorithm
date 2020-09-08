#include <iostream>

using namespace std;

int main()
{
  int numTestCases,a,b,c;
  cin >> numTestCases;

  for(int i=0; i<numTestCases; i++)
  {
    cin >> a >> b >> c;

    if(a+b <= c)
      cout << 0 << endl;
    else if(a == b && b == c && c == a)
      cout << 1 << endl;
    else if((a*a)+(b*b) == c*c)
      cout << 2 << endl;
    else if (a == b || b == c || a == c)
      cout << 3 << endl;
    else
      cout << 4 << endl;
  }
}
