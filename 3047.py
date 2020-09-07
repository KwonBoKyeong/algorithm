num = list(map(int, input().split()))

num.sort()

s = input()

for i in s : 
	if(i == 'A') :
		print(num[0], end=' ')
	elif(i == 'B') :
		print(num[1], end=' ')
	else :
		print(num[2], end=' ')

print()