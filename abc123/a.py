a, b, c, d, e = [int(input()) for _ in range(5)]
k = int(input())

max_distance = e - a
if max_distance > k:
    print(":(")
else:
    print("Yay!")
