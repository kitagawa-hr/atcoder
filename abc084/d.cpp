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

class PrimeUtils
{
public:
    static bool isPrime(int num);
    static vector<int> devisor(int num);
};

inline bool PrimeUtils::isPrime(int num)
{
    if (num < 2)
        return false;
    else if (num == 2)
        return true;
    else if (num % 2 == 0)
        return false;
    double sqrtNum = sqrt(num);
    for (int i = 3; i <= sqrtNum; i += 2)
    {
        if (num % i == 0)
        {
            return false;
        }
    };
    return true;
}

int main()
{
    vector<int> primes;

    int i = 13;
    while (i < 100000)
    {
        if (PrimeUtils::isPrime(i))
        {
            primes.push_back(i);
        }
        i += 12;
    }
    cout << primes.at(100);
    return 0;
}
