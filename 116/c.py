def count(h_list):
    if len(h_list) == 0:
        return 0
    if len(h_list) == 1:
        return h_list[0]
    if 0 not in h_list:
        return 1 + count([x-1 for x in h_list])
    elif all(x == 1 for x in h_list):
        return 1
    return sum([count(x) for x in divide_by_zero(h_list)])


def divide_by_zero(arr):
    non_zero = []
    for ar in arr:
        if ar == 0:
            if non_zero:
                yield non_zero
                non_zero = []
        else:
            non_zero.append(ar)
    yield non_zero


n = int(input())
h_list = [int(x) for x in input().split(" ")]
print(count(h_list))
