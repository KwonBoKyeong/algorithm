n = int(input())

a = [list(map(int, input().split())) for _ in range(n)]

b = sorted(a, key = lambda x : (x[1], x[0]))

for i in b :
	print(i[0], i[1])