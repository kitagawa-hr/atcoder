#include <bits/stdc++.h>
using namespace std;

const string YES = "Yes";
const string NO = "No";

long long digit_sum(long long n)
{
    int a = 0;
    int sum = 0;
    while (n)
    {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

void solve(long long N)
{
    if (N % digit_sum(N) == 0)
    {
        cout << YES << endl;
    }
    else
    {
        cout << NO << endl;
    }
}

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
int main()
{
    long long N;
    scanf("%lld", &N);
    solve(N);
    return 0;
}
