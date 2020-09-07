# 문자열 입력
s = input() 

# 숫자를 입력으로 받아오기 : 강제 형 변환
num = int(input())

# 공백을 기준으로 나뉜 문자열의 경우 (리스트로 반환)
s = input().split()

# 각 변수에 값 할당
x, y, z = map(int, input().split())

x, y, z = [int(input()) for _ in range(3)]

# 리스트의 각 문자열 요소에 형 변환 적용
num = list(map(int, input().split()))

# 입력의 개수 n과 n개 숫자를 받아오는 경우 (m은 리스트)
n, *m = map(int, input().split())

# 1차원 배열 0으로 초기화
arr = [0] * 5

# 2차원 배열 0으로 초기화 (n x m)
arr = [[0] * m for _ in range(n)]

# 2차원 입력받기
n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]