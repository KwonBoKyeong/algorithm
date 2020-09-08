A, B, C = [int(input()) for _ in range(3)]

num = list(str(A * B * C))

for i in range(10) :
	print(num.count(str(i)))
