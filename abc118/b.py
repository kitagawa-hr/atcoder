n, m = map(int, input().split(" "))
a_list = []
for _ in range(n):
    a_list.append(list(map(int, input().split(" ")))[1:])

if len(a_list) == 1:
    print(len(a_list[0]))
    exit()
ans = set(a_list[0])
for a_lis in a_list:
    ans = ans & set(a_lis)

print(len(list(ans)))
