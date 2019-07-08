#include <bits/stdc++.h>
#define rep(i, n) for (int i = 0; i < (int)(n); i++)
#define all(x) (x).begin(), (x).end()
#define SZ(x) ((int)(x).size())
#define MEMSET(v, h) memset((v), h, sizeof(v))
using namespace std;

typedef long long ll;

template <typename T>
inline string toString(const T &a)
{
    ostringstream oss;
    oss << a;
    return oss.str();
}

template <typename A, size_t N, typename T>
void fillArray(A (&array)[N], const T &val)
{
    std::fill((T *)array, (T *)(array + N), val);
}

const ll MOD = 1000000007;
const int N = 2005;

int lf[N][N];
int rt[N][N];
int up[N][N];
int down[N][N];

void solve(int H, int W, std::vector<std::string> S)
{
    fillArray(lf, 0);
    fillArray(rt, 0);
    fillArray(up, 0);
    fillArray(down, 0);
    int score = 0LL;

    rep(h, H)
    {
        rep(w, W)
        {
            if (S[h][w] == '#')
            {
                continue;
            }
            lf[h][w] = (h == 0) ? 0 : lf[h - 1][w] + 1;
            up[h][w] = (w == 0) ? 0 : up[h][w - 1] + 1;
        }
    }

    for (int h = H - 1; h >= 0; h--)
    {
        for (int w = W - 1; w >= 0; w--)
        {
            if (S[h][w] == '#')
            {
                continue;
            }
            rt[h][w] = (w == W - 1) ? 0 : rt[h][w + 1] + 1;
            down[h][w] = (h == H - 1) ? 0 : down[h + 1][w] + 1;
        }
    }
    rep(h, H)
    {
        rep(w, W)
        {
            score = max(score, lf[h][w] + rt[h][w] + up[h][w] + down[h][w]);
        }
    }
    cout << score << endl;
}

int main()
{
    int H;
    scanf("%lld", &H);
    int W;
    scanf("%lld", &W);
    std::vector<std::string> S(H);
    for (int i = 0; i < H; i++)
    {
        std::cin >> S[i];
    }
    solve(H, W, std::move(S));
    return 0;
}
