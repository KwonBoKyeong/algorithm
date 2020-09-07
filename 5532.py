L, A, B, C, D = [int(input()) for _ in range(5)]

kor = A / C
math = B / D

if A % C != 0 : 
	kor += 1

if B % D != 0 :
	math += 1

print(L - max(kor, math))
