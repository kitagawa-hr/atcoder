from functools import reduce


def exclusve_sum(x, y):
    return x^y

def calc_exclusive(a, b):
    """aは偶数であるとする"""
    if b - a <= 4:
        return reduce(exclusve_sum, [x for x in range(a, b + 1)])

    q, r = divmod(b - a, 4)
    rest = [a + 4 * q + r1 for r1 in range(0, r + 1)]
    ans = reduce(exclusve_sum, rest)
    return ans


if __name__ == "__main__":
    a, b = list(map(int, input().split(" ")))
    calc_exclusive(a, b)

    if a % 2 == 0:
        ans = calc_exclusive(a, b)
        print(ans)
    else:
        ans = a ^ calc_exclusive(a + 1, b)
        print(ans)
