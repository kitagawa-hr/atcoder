s = input()
if len(s) == 0:
    print("0")
    exit()

s_10 = "10" * (len(s) // 2)
if len(s) % 2 != 0:
    s_10 += "1"

s_01 = "01" * (len(s) // 2)
if len(s) % 2 != 0:
    s_01 += "0"

a = len([i for i in range(len(s)) if s[i] != s_01[i]])
b = len([i for i in range(len(s)) if s[i] != s_10[i]])
ans = min(a, b)
print(ans)
