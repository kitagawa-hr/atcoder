def main():
    n, m = map(int, input().split())
    x_s = list(map(int, input().split()))
    if n >= m:
        print(0)
        return
    x_s.sort()
    sa = [x_s[i + 1] - x_s[i] for i in range(m - 1)]
    sa.sort()
    print(sum(sa) - sum(sa[m - n : m]))
    return


if __name__ == "__main__":
    main()
