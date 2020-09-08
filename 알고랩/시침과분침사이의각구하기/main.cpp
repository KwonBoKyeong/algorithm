#include <iostream>
#include <cstdlib>

using namespace std;

int angleClock(int h, int m);

int main(void)
{
  int t;
  int h, m;
  cin >> t;
  for(int i=0; i<t; i++)
  {
    cin >> h >> m;
    cout << angleClock(h, m) << endl;
  }
  return 0;
}

int angleClock(int h, int m)
{
  double a = h*30 + m*0.5;
  double b = m*6;
  double c;
  if(a > b)
  {
    c = a-b;

  }
  else
  {
    c = b-a;
  }

  if(c > 180)
    c = 360 - c;

  return (int)c;
}
