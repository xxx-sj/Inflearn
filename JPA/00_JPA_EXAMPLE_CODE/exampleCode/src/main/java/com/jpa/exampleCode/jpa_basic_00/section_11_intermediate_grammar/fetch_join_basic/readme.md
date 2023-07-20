# 페치 조인 - 기본

- JPQL에서 성능 최적화를 위해 제공하는 기능
- 연관된 엔티티나 컬렉션을 SQL 한번에 함께 조회하는 기능
- join fetch 명령어
- [LEFT [OUTER] | INNER ] JOIN FETCH 

- 회원을 조히하면서 연관ㄴ된 팀도 함께 조회
- JQPL
  - select m from Member m join fetch m.team
- SQL
  - select m.*, t.* from member m  inner join team t on team_id = t.id

### 컬렉션 패치 조인
- select t from Team t join fetch t.members where t.name = 'teamA'
- 일대 다 조인의 경우 데이터가 다[n] 만큼 증가한다.

### 페치 조인과 DISTINCT
- SQL에 DISTINCT를 추가
- **어플리케이션**에서 엔티티 중복 제거
  - 같은 식별자를 가진 team 엔티티 제거

### 페치조인과 일반조인의 차이
- 일반조인은 문자그대로 테이블 간 조인을 해주는 것이다.
  - select t from Team t join t.members m
  - join을 했기 때문에 데이터는 다 쪽인 member의 row수 만큼 조회가 된다.
  - 객체 탐색을 통해 member의 데이터를 조회할 때 (getter), member 관련 쿼리가 나가며 이 때 데이터를 가져오게 된다.
- 페치조인은 처음 쿼리를 통해 데이터를 가져온다.
  - select t from Team t join fetch t.members

- JPQL은 결과를 반환할 때 연관관계를 고려하지 않는다.
- 단지 SELECT절에 지정한 엔티티만 조회할 뿐
- 여기서는 팀 엔티티만 조회하고, 회원 엔티티는 조회하지 않음
- 페치 조인을 사용할 때만 연관된 엔티티도 함꼐 조회
- 페치 조인은 객체 그래프를 SQL 한번에 조회하는 개념

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21742&tab=curriculum