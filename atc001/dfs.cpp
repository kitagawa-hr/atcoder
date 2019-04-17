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

int h, w, s1, s2;
vector<string> c;
vector<vector<int>> cache(500, (vector<int>(500, 0)));

bool dfs(int x, int y)
{
    if (x < 0 || y < 0 || x >= w || y >= h || c.at(y).at(x) == '#' || cache.at(y).at(x) == 1)
    {
        return false;
    }
    cache[y][x] = 1;
    if (c.at(y)[x] == 'g')
    {
        return true;
    }
    else
    {
        return dfs(x + 1, y) || dfs(x - 1, y) || dfs(x, y + 1) || dfs(x, y - 1);
    }
}

int main()
{
    cin >> h >> w;
    string s;
    rep (n, h){
        cin >> s;
        c.push_back(s);
    }
    rep(i, w)
    {
        rep(j, h)
        {
            if (c.at(j).at(i) == 's')
            {
                s1 = i;
                s2 = j;
            }
        }
    }
    if (dfs(s1, s2))
    {
        cout << "Yes";
    }
    else
    {
        cout << "No";
    }
    return 0;
}
