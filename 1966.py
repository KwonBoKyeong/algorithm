from collections import deque

t = int(input())

for i in range(t) :

	n, m = map(int, input().split()) 

	arr = list(map(int, input().split()))
	q = deque()
	doc = deque()

	for i in range(len(arr)):
		q.append(arr[i])
		doc.append(i)

	cnt = 0

	while(True) :

		if(q[0] != max(q)) :
			q.append(q.popleft())
			doc.append(doc.popleft())

		else :
			cnt += 1

			if(m == doc[0]) :
				print(cnt)
				break
			else :
				q.popleft()
				doc.popleft()

