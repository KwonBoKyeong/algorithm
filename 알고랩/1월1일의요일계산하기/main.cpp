#include <iostream>

using namespace std;

int isLeapYear(int year);

int main(void)
{
  int t;
  int year;
  cin >> t;

  for(int i=0; i<t; i++)
  {
    cin >> year;

    int sum = 0;
    int answer;

    for(int j=1582; j<year; j++)
    {
      sum += isLeapYear(j);
    }

    switch (sum%7) {
      case 0 : answer = 5; break;
      case 1 : answer = 6; break;
      case 2 : answer = 0; break;
      case 3 : answer = 1; break;
      case 4 : answer = 2; break;
      case 5 : answer = 3; break;
      case 6 : answer = 4; break;

    }

    cout << answer << endl;


  }

  return 0;
}

int isLeapYear(int year)
{
  if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
    return 2;

  else
    return 1;
}
