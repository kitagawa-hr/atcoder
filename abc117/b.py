n = int(input())
l_list = list(map(int, input().split(" ")))

l_max = max(l_list)
l_list.pop(l_list.index(l_max))

if l_max < sum(l_list):
    print('Yes')
else:
    print('No')
