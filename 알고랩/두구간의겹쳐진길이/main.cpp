#include <iostream>
#include <algorithm>

using namespace std;

int lengthOfIntervalIntersection(int a, int b, int c, int d);


int main(void)
{
    int t;
    int a,b,c,d;
    cin >> t;

    for(int i=0; i<t; i++)
    {
        cin >> a >> b >> c >> d;
        cout << lengthOfIntervalIntersection( a, b, c, d ) << endl;
    }
    return 0;
}

int lengthOfIntervalIntersection(int a, int b, int c, int d)
{

  int maxNum = max(a,c);
  int minNum = min(b,d);


  if(maxNum > minNum)
    return -1;
  else
    return (minNum - maxNum);


}
