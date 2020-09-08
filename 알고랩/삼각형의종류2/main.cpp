#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main()
{
  int numTestCases,a_x,a_y,b_x,b_y,c_x,c_y;
  cin >> numTestCases;

  for(int i=0; i<numTestCases; i++)
  {
    cin >> a_x >> a_y >> b_x >> b_y >> c_x >> c_y;

    int a = pow(a_x-b_x,2) + pow(a_y-b_y,2);
    int b = pow(b_x-c_x,2) + pow(b_y-c_y,2);
    int c = pow(c_x-a_x,2) + pow(c_y-a_y,2);

    int arr[3] = {a,b,c};
    sort(arr,arr+3);

    if (sqrt(arr[0]) + sqrt(arr[1]) <= sqrt(arr[2]))
      cout << 0 << endl;
    else if(arr[0] + arr[1] == arr[2])
      cout << 1 << endl;
    else if(arr[0] + arr[1] < arr[2])
      cout << 2 << endl;
    else if(arr[0] + arr[1] > arr[2])
      cout << 3 << endl;

  }
}
