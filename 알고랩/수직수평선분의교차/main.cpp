#include <iostream>
#include <cmath>

using namespace std;

int main()
{
  int numTestCases;
  cin >> numTestCases;

  for(int i=0; i<numTestCases; i++)
  {
    int ax1,ax2,ay1,ay2,bx1,bx2,by1,by2,tmp;
    cin >> ax1 >> ay1 >> ax2 >> ay2;
    cin >> bx1 >> by1 >> bx2 >> by2;

    if(ax1 > ax2) {tmp=ax1; ax1=ax2; ax2=tmp;}
    else if(ay1>ay2) {tmp=ay1; ay1=ay2; ay2=tmp;}
    else if(bx1>bx2) {tmp=bx1; bx1=bx2; bx2=tmp;}
    else if(by1>by2) {tmp=by1; by1=by2; by2=tmp;}

    int answer = 0;

    if(ax1 == ax2)
    {
      if(bx1 <= ax1 && ax1 <= bx2 && ay1 <= by2 && by2 <= ay2)
      {
        if((ax1 == bx1) || (ax1 == bx2) || (by2 == ay1) || (by2 == ay2))
          answer = 2;
        else
          answer = 1;
      }
    }

    else
    {
      if(by1 <= ay1 && ay1 <= by2 && ax1 <= bx1 && bx1 <= ax2)
      {
        if(ay1 == by1 || ay1 == by2 || ax1 == bx1 || bx1 == ax2)
          answer = 2;
        else
          answer = 1;
      }
    }


    cout << answer << endl;



  }
}
