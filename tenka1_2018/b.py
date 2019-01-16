def swap(a, b, k):
    if k % 2 == 0:
        if a % 2 == 1:
            a -= 1
        return a/2, b+a/2
    if b % 2 == 1:
        b -= 1
    return int(a+b/2), int(b/2)


if __name__ == '__main__':
    a, b, k = list(map(int, input().split()))
    for i in range(k):
        a,b = swap(a,b,i)
    print(int(a), int(b))
