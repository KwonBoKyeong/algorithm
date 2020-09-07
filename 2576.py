num = [int(input()) for _ in range(7)]

odd = []

for i in num :
	if (i % 2 == 1) :
		odd.append(i)

if(len(odd) == 0) :
	print(-1)
else :
	print(sum(odd))
	print(min(odd))
