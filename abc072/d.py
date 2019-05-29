from itertools import takewhile, groupby

import numpy as np


def count(arr, index):
    unsame = arr != index
    if not unsame.any():
        return 0
    num_of_consective = [len(list(g)) for k, g in groupby(unsame) if k]
    return sum([(x + 1) // 2 for x in num_of_consective])


def main():
    n = int(input())
    index = np.arange(1, n + 1)
    p_list = np.array(list(map(int, input().split(" "))))
    print(count(p_list, index))


if __name__ == "__main__":
    main()
