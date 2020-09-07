k = input()

arr = [chr(alpha) for alpha in range(97, 123)]

for i in arr:
	if i in k :
		print(k.count(i), end=' ')
	else : 
		print(0, end=' ')