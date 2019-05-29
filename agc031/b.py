import numpy as np

MOD = 10e9 + 7


def reverse(arr):
    


def reversi_count(arr):
    return sum([reversi_count(x) % MOD for x in reverse(arr)])


def main():
    n = int(input())
    cs = np.array(map(int, input().split(" ")))
    print(reversi_count(cs))


if __name__ == "__main__":
    main()
