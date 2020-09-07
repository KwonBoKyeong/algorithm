import sys

input = lambda : sys.stdin.readline().rstrip()

a, b, c= map(int, input().split())

print(pow(a,b,c))