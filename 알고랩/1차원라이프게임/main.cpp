#include <iostream>

using namespace std;

int main()
{
  int numTestCases;
  cin >> numTestCases;

  for(int i=0; i<numTestCases; i++)
  {
    int n,time; //time : 단위 시간
    cin >> n >> time;
    int arr[n+2];
    arr[0] = 0;
    arr[n+1] = 0;

    int ans[n+2];
    for(int j=1; j<n+1; j++)
    {
      cin >> arr[j];
      ans[j] = arr[j];
    }


    for(int t=0; t<time; t++)
    {
      for(int j=1; j<n+1; j++)
      {
        if(arr[j-1] + arr[j+1] < 3 && arr[j] > 0)
          ans[j] -= 1;
        else if(arr[j-1] + arr[j+1] > 7 && arr[j] > 0)
          ans[j] -= 1;
        else if((arr[j-1] + arr[j+1] > 3 && arr[j-1] + arr[j+1] <= 7 )&& arr[j] < 9)
          ans[j] += 1;
        else if(arr[j-1] + arr[j+1] == 3)
          continue;
      }

      for(int j=1; j<n+1; j++)
        arr[j] = ans[j];


    }
    for(int j=1; j<n+1; j++)
    cout << ans[j] << " ";

    cout << endl;



  }
}
