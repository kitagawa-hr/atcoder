#include <bits/stdc++.h>
using namespace std;

long long ceil_div(long long num, long long mod){
    return (num / mod) + ceil(num % mod);
}
void solve(long long N, long long K, std::vector<long long> A)
{
    if (K >= A.size())
    {
        cout << 1 << endl;
        exit(0);
    }
    auto min_it = min_element(A.begin(), A.end());
    int d1 = distance(A.begin(), min_it);
    int d2 = distance(min_it, A.end()) - 1;
    // cout << "d1:" << d1 << ", d2:" << d2 << endl;
    int ans = ceil_div(d1 , (K - 1)) + ceil_div(d2 , (K - 1));
    cout << ans << endl;
    exit(0);
}

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
int main()
{
    long long N;
    scanf("%lld", &N);
    long long K;
    scanf("%lld", &K);
    std::vector<long long> A(N);
    for (int i = 0; i < N; i++)
    {
        scanf("%lld", &A[i]);
    }
    solve(N, K, std::move(A));
    return 0;
}
