a, b, c, d, e = [int(input()) for _ in range(5)]
nums = [a, b, c, d, e]
tmp = [num if num % 10 == 0 else 10 * (num // 10 + 1) for num in nums]
buf = [num % 10 for num in nums if num % 10 != 0]
if not buf:
    print(sum(nums))
    exit()
ans = sum(tmp) + min(buf) - 10
print(ans)
