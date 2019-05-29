"""
a = Aで終わる
b = Bで始まる
ab = Aで始まりBで終わる
"""
s_list = []
n = int(input())
for _ in range(n):
    s_list.append(input())
ab= len([s for s in s_list if s.startswith("B") and s.endswith("A")])
a= len([s for s in s_list if s.endswith("A")]) -ab
b= len([s for s in s_list if s.startswith("B")]) -ab
c = len([s for s in s_list if "AB" in s])

ans = 0
p1, p2 = min([a-ab, b-ab]), max([a-ab, b-ab])
p3, p4 = min([p2 -p1, ab]), max([p2-p1, ab])
if ab - p3>=0:
    ans += (ab - p3) //2
ans += p1 + p3 + c
print(p1 + p3 + c)
