#include <iostream>

using namespace std;

int testInclusion(int a, int b, int m);

int main(void)
{
    int t;
    int a, b, m;
    cin >> t;
    for(int i=0; i<t; i++)
    {
        cin >> a >> b >> m;
        cout << testInclusion( a, b, m ) << endl;
    }
    return 0;
}

int testInclusion(int a, int b, int m)
{
  for(int i=a; i<=b; i++)
  {
    if(i == m)
    {
      return 1;
    }
  }

  return 0;

}
