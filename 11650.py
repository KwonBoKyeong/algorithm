n = int(input())

a = [list(map(int, input().split())) for _ in range(n)]

b = sorted(a) #a.sort()

for i in b :
	print(i[0], i[1])