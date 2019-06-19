#!/usr/bin/env python3
import sys


def solve(a: int, b: int, n: int):
    ans = n
    while True:
        if ans % a == 0 and ans % b == 0:
            break
        ans += 1
    print(ans)
    return


# Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
def main():
    def iterate_tokens():
        for line in sys.stdin:
            for word in line.split():
                yield word
    tokens = iterate_tokens()
    a = int(next(tokens))  # type: int
    b = int(next(tokens))  # type: int
    n = int(next(tokens))  # type: int
    solve(a, b, n)

if __name__ == '__main__':
    main()