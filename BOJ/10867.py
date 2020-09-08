import sys

input = lambda : sys.stdin.readline().rstrip()

n = int(input())

num = list(set(map(int, input().split())))

num.sort()

print(" ".join(str(i) for i in num))
