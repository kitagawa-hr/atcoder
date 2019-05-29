def xor(x, a_list):
    return sum([x ^ a for a in a_list])


n, k = list(map(int, input().split(" ")))
a_list = list(map(int, input().split(" ")))

print(max([xor(k_, a_list) for k_ in range(k + 1)]))
