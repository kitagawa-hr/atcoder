a, b = list(map(int, input().split(" ")))

if a == b:
    print(2*a)
else:
    print(2*max(a,b)-1)
