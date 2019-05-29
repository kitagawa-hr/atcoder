def main(ab_list, m):
    ab_list.sort(key=lambda x:x[0])
    it = iter(ab_list)
    paid = 0
    buyed_drinks = 0
    while buyed_drinks < m:
        rest_num = m - buyed_drinks
        a, b = next(it)
        if rest_num <= b:
            paid += a*rest_num
            return paid
        else:
            paid += a*b
            buyed_drinks += b



if __name__ == "__main__":
    n, m = list(map(int, input().split(" ")))
    ab_list = []
    for _ in range(n):
        a, b = list(map(int, input().split(" ")))
        ab_list.append((a, b))
    print(main(ab_list, m))
