#include <bits/stdc++.h>
using namespace std;

const long long MOD = 1000000007;
const long long N_MAX = 100000;

void solve(long long N, long long M, std::vector<long long> a)
{
    long long fibo[N + 10] = {1, 1};
    for (long long i = 2; i < N + 10; i++)
    {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    long long b[N];
    for (auto j : a)
    {
        b[j] = 1;
    }
}

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
int main()
{
    long long N;
    scanf("%lld", &N);
    long long M;
    scanf("%lld", &M);
    std::vector<long long> a(M);
    for (int i = 0; i < M; i++)
    {
        scanf("%lld", &a[i]);
    }
    solve(N, M, std::move(a));
    return 0;
}
