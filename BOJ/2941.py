s = input()

item = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for i in item:
	if i in s :
		s = s.replace(i,'a')

print(len(s))
