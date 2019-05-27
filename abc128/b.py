n = int(input())
arr = []
for i in range(n):
    arr.append([i + 1] + list(input().split(" ")))
arr = [(a, b, -int(c)) for (a, b, c) in arr]
sarr = sorted(arr, key=lambda x: (x[1], x[2]))

for i, _, _ in sarr:
    print(i)
