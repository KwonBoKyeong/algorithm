from collections import deque

n, k = map(int, input().split())
q = deque()

ans = []

for i in range(1, n+1) :
	q.append(i)

cnt = 0

while(len(q) != 0) :
	cnt += 1

	if(cnt % k != 0) :
		q.append(q.popleft())
	else : 
		ans.append(q.popleft())


print("<"+", ".join(str(i) for i in ans)+">")
