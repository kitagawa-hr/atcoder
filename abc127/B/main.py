#!/usr/bin/env python3


def calc(x1, r, D):
    return r * x1 - D


# Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
def main():
    r, d, x = list(map(int, input().split(" ")))
    for _ in range(10):
        x = calc(x, r, d)
        print(x)


if __name__ == '__main__':
    main()