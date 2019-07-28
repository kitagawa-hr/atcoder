from itertools import combinations


def min_index(seq):
    m = seq[0]
    index = 0
    for i, element in enumerate(seq):
        if element < m:
            m = element
            index = i
    return index, m

n, a, b, c = map(int, input().split())
a, b, c = sorted([a,b,c])
ls = [int(input()) for _ in range(n)]
scores = []
for i in range(2, n-2):
    combs = combinations(range(n), i)
    for comb in combs:
        score = 10 * (i - 1)
        bamboos = [ls[x] for x in range(n) if x not in combs]
        bamboos.extend([ls[x] for x in comb])
        idx, m = min_index([abs(bamboo - a) for bamboo in bamboos])
        del bamboos[idx]
        score += m
        idx, m = min_index([abs(bamboo - b) for bamboo in bamboos])
        del bamboos[idx]
        score += m
        idx, m = min_index([abs(bamboo - c) for bamboo in bamboos])
        del bamboos[idx]
        score += m
score = 0
bamboos = ls
idx, m = min_index([abs(bamboo - a) for bamboo in bamboos])
del bamboos[idx]
score += m
idx, m = min_index([abs(bamboo - b) for bamboo in bamboos])
del bamboos[idx]
score += m
idx, m = min_index([abs(bamboo - c) for bamboo in bamboos])
del bamboos[idx]
score += m
scores.append(score)
print(min(scores))

