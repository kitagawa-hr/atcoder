def num_of_2(x):
    y = 0
    while x%2==0:
        x = x // 2
        y += 1
    return y

n = int(input())
a_list = list(map(int, input().split(" ")))
print(sum([num_of_2(x) for x in a_list]))
