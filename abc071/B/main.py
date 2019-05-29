#!/usr/bin/env python3
import sys

ALPHABETS = "abcdefghijklmnopqrstuvwxyz"


def solve(S: str):
    for alphabet in ALPHABETS:
        if alphabet not in S:
            print(alphabet)
            return
    print("None")
    return


# Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
def main():
    def iterate_tokens():
        for line in sys.stdin:
            for word in line.split():
                yield word

    tokens = iterate_tokens()
    S = next(tokens)  # type: str
    solve(S)


if __name__ == '__main__':
    main()