#!/usr/bin/env python3
import sys

from bisect import bisect_left, bisect_right


def count(seq, element):
    "Return number of occurrences of item"
    i = bisect_left(seq, element)
    j = bisect_right(seq, element)
    return seq[i:j].count(element)


def solve(N: int, A: "List[int]"):
    flag = 0
    ans = 1
    seta = sorted(list(set(A)))
    sa = sorted(A)
    for a in reversed(seta):
        if count(sa, a) >= 4:
            if flag == 1:
                ans *= a
                print(ans)
                return
            ans = a * a
            print(ans)
            return
        elif count(sa, a) >= 2:
            flag += 1
            ans *= a
            if flag == 2:
                print(ans)
                return
    print(0)
    return


# Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
def main():
    def iterate_tokens():
        for line in sys.stdin:
            for word in line.split():
                yield word

    tokens = iterate_tokens()
    N = int(next(tokens))  # type: int
    A = [int(next(tokens)) for _ in range(N)]  # type: "List[int]"
    solve(N, A)


if __name__ == '__main__':
    main()
