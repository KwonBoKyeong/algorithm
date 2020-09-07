import sys

input = lambda : sys.stdin.readline().rstrip()

n = int(input())

a = [int(input()) for _ in range(n)]

a.sort()

for i in a : 
	print(i)