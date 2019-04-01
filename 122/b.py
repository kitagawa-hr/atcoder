ACGT = "ACGT"

s= input()
nums = []
num = 0
for _s in s:
    if _s not in ACGT:
        nums.append(num)
        num = 0
        continue
    num += 1
nums.append(num)
print(max(nums))
