#include <bits/stdc++.h>
#include <vector>
#define rep(i, n) for (int i = 0; i < (int)(n); i++)
#define all(x) (x).begin(), (x).end()
#define SZ(x) ((int)(x).size())
#define MEMSET(v, h) memset((v), h, sizeof(v))
#ifdef LOCAL
#define eprintf(...) fprintf(stderr, __VA_ARGS__)
#else
#define eprintf(...) 42
#endif
using ll = long long;
using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<ll> c(n);
    rep(i, n){
        cin >> c.at(i);
    }
    cout << c[0];
    return 0;
}

long long reversi(){
    
}

