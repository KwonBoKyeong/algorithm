a, b = map(int, input().split())

arr = []

for i in range(1, b+1) :
	arr.append(int(str(i*a)[::-1]))

print(max(arr))