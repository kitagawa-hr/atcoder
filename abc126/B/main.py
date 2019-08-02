#!/usr/bin/env python3
import sys


YYMM = "YYMM"
MMYY = "MMYY"
AMBIGUOUS = "AMBIGUOUS"
NA = "NA"

def solve(S):
    a= S//100
    b= S % 100
    if 1 <= a <=12 and 1 <= b <= 12:
        print(AMBIGUOUS)
    elif 1 <= a <= 12:
        print(MMYY)
    elif 1 <= b <= 12:
        print(YYMM)
    else:
        print(NA)

    return


# Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
def main():
    def iterate_tokens():
        for line in sys.stdin:
            for word in line.split():
                yield word
    tokens = iterate_tokens()
    S = int(next(tokens))  # type: int
    solve(S)

if __name__ == '__main__':
    main()