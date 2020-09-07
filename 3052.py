itm = [int(input()) for _ in range(10)]
arr = []

for i in itm :
	i %= 42
	if i not in arr :
		arr.append(i)

print(len(arr))


