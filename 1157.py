from collections import Counter

s = input().upper()

c = Counter(s).most_common()

if(len(c) > 1 and c[0][1] == c[1][1]) :
	print("?")
else :
	print(c[0][0])
