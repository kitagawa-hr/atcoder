def collatz(x):
    if x%2==0:
        return int(x/2)
    return 3*x +1



s = int(input())
stack = [s]
index = 1
while True:
    s = collatz(s)
    index += 1
    if s in stack:
        print(index)
        break
    stack.append(s)
