#include <bits/stdc++.h>
using namespace std;

void solve(long long N, long long M, std::vector<long long> A, std::vector<long long> B, std::vector<long long> C)
{
    for (int m = 0; m < M; m++)
    {
        
    }
}

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
int main()
{
    long long N;
    scanf("%lld", &N);
    long long M;
    scanf("%lld", &M);
    std::vector<long long> A(N);
    for (int i = 0; i < N; i++)
    {
        scanf("%lld", &A[i]);
    }
    std::vector<long long> B(M);
    std::vector<long long> C(M);
    for (int i = 0; i < M; i++)
    {
        scanf("%lld", &B[i]);
        scanf("%lld", &C[i]);
    }
    solve(N, M, std::move(A), std::move(B), std::move(C));
    return 0;
}
