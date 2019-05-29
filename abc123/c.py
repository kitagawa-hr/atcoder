import math

n, a, b, c, d, e = [int(input()) for _ in range(6)]
print(math.ceil(n / min([a,b,c,d,e])) + 4)
