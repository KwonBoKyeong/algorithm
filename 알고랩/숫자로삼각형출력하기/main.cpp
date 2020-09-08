#include <iostream>

using namespace std;

int main()
{
  int numTestCases;
  cin >> numTestCases;

  for(int i=0; i<numTestCases; i++)
  {
    int k;
    cin >> k;

    int num = 1;
    int arr[k][k];


    for(int i=0; i<k; i++)
    {
      for(int j=0; j<k; j++)
      {
        arr[i][j] = 0;
        if(j>=i)
        {
          arr[i][j] = num;
          num++;
        }
      }
    }

    for(int i=0; i<k; i++)
    {
      for(int j=0; j<k; j++)
      {
        if(i>=j)
          cout << arr[j][i] << " ";
      }
      cout << endl;
    }

  }
}
