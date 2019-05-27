def take(n, lis):
    if n >= len(lis):
        return lis
    if n <= 0:
        return []
    else:
        return lis[:n]


n, k = list(map(int, input().split(" ")))
vs = list(map(int, input().split(" ")))
if n == 1:
    print(max(0, vs[0]))
    exit()
if k == 1:
    print(max(0, vs[0], vs[-1]))
    exit()
scores = []
score = 0
length = min(n, k)
for gets in range(length + 1):
    for left in range(gets + 1):
        right = gets - left
        retnum = k - gets
        get_list = take(left, vs) + take(right, vs[::-1])
        minus = sorted([get for get in get_list if get <= 0])
        score = sum(get_list) - sum(take(retnum, minus))
        scores.append(score)
print(max(0, *scores))
