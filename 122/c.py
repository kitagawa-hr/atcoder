n, q = list(map(int, input().split(" ")))
s = input()
s = s.replace("AC", "ZC")
num = 0
ac_index = []
for _s in s:
    if _s == "Z":
        ac_index.append(num)
        num += 1
    else:
        ac_index.append(num)

for _ in range(q):
    l, r = list(map(int, input().split(" ")))
    print(ac_index[r-1] - ac_index[l-1])
