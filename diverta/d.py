import math
from collections import defaultdict
from itertools import product
from functools import reduce 
from operator import mul


def is_prime(num):
    if not isinstance(num, int):
        return False
    if num <= 1:
        return False
    if num == 2 or num == 3:
        return True
    if num % 6 in [0, 2, 3, 4]:
        return False
    div_max = int(math.sqrt(num))
    for div in range(5, div_max + 1, 2):
        if num % div == 0:
            return False
    return True

def factorint(x):
    factors = defaultdict(int)
    if x==1:
        factors[1] = 1
        return factors
    while not is_prime(x):
        div_max = int(math.sqrt(x))
        for div in range(2, div_max + 1):
            if x % div == 0:
                factors[div] += 1
                x = int(x / div)
                break
    factors[x] += 1
    return factors

ans = 0
n = int(input())
rn = math.sqrt(n+1) + 1
factor_dict = factorint(n)
ks = [range(k+1) for k in factor_dict.values()]
prs = product(*ks)
for pr in prs:
    s = reduce(mul, [factor**p for factor,p in zip(factor_dict.keys(), pr)])
    if s >= rn:
        ans += s -1
print(ans)
