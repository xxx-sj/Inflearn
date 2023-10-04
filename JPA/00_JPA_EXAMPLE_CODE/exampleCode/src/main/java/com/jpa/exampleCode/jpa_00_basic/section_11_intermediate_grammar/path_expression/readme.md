# 경로 표현식 

- 상태 필드 select m.username
  - 단순히 값을 저장하기 위한 필드
- 단일 값 연관 필드 join m.team t
  - 연관관계를 위한 필드
- 컬렉션 값 연관 필드 join m.orders o
  - 연관관계를 위한 필드

### 경로 표현식 특징
- 상태 필드: 경로 탐색의 끝, 탐색 x 
  - m.username 과 같이 필드 값 
- 단일 값 연관 경로: 묵시적 내부 조인 발생, 탐색 o
  - m.team 과 같이 연관관계가 있는 필드 값 m.team.name으로 갈 수 있다.
  - 묵시적 내부조인으로 만들면 튜닝하기 어렵기 때문에 지양한다.
- 컬렉션 값 연관 경로: 묵시적 내부조인 발생, 탐색x
  - 컬렉션으로 값이 조회되기 때문에 더 이상 탐색할 수 없다. size 만 찍을 수 있다.
    - From 절에서 명시적 조인을 통해 별칭을 얻으면 별칭을 통해 탐색 가능


**실무에서는 묵시적 조인을 쓰지말 것.**
- 조인은 SQL 튜닝에 중요 포인트
- 묵시적 조인은 조인이 일어나는 상황을 한눈에 파악하기 어려움

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21727&tab=curriculum