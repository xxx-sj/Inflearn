# 페치 조인2 - 한계 

- 페치 조인 대상에는 별칭을 줄 수 없다.
  - 가급적 사용하지 않는다.
  - select t from Team t join fetch t.member m [x] 
  - join fetch는 기본적으로 관련된 데이터를 모두 가져오는 것인데 별칭을 주어 where 절에 조건을 추가하게 되면
    잘못 동작할 수 있다.
  - team과 연관된 멤버만 가져오고 싶을 때는 team에서 member를 가져오는게 아니라, member를 처음부터 가져올 만큼 가져온다.
  - 객체 그래프 탐색의 경우 모든 데이터가 나온다는 가정하에 만들어져 있다.
  - 여러 join fetch 을 사용할 때 별칭 사용
    - select t from Team t join fetch t.member m join fetch m.team t1 ...; 

### 일대 다 관계에서의 fetch join

- 둘 이상의 컬렉션은 페치 조인 할 수 없다.
  - select t from Team t join fetch t.member join fetch t.orders
  - 1 : N 관계가 2번 생기면 곱이 두번 생기기 때문에 데이터 적합성이 떨어진다.
  - 컬렉션의 데이터는 하나만 지정할 수 있다.

- 컬렉션을 페치 조인하면 페이징 API를 사용할 수 없다. 
  - 일대 다 같은 경우 데이터가 다 쪽에 맞춰서 증가하기 때문에 불가능. 
    - ex) teamA에는 member가 2명, teamB에는 member가 1명 있을 때
    - select t From Team t join fetch t.member;
    - 하게되면 join fetch를 통해 1:N관계인 team 과 member의 결과는 총 3row가 나오게 된다.
    - 이유는, team의 숫자는 2개 이지만, member의 갯수가 3개 이므로, join fetch로 인해 member row에 맞춰 
    - 총 3 row가 나오게 된다. 
    - 만약, 여기서 2개의 결과만 가져오게 페이징을 하게되면, 결과값은 teamA, teamB이지만, teamA, teamA의 결과를 얻게된다.
  - 일대일, 다대일 같은 단일 값 연관 필드들은 페치 조인해도 페이징 가능
  - 하이버네이트는 경고 로그를 남기고 메모리에서 페이징

- 해결법
  - 일대다 페이징이 아닌 다대일 페이징으로 변경
  - 일대다 관계에 batchsize를 추가해준다.
    - 먼저 페이징 만큼의 team을 가져온다. 
    - batchSize는 member 를 lazy로 가져올 때 in 절을 통해 where절에 team_id를 가져온다.
    - 일대다관계 위에 어노테이션으로 @BatchSize(size = {}) 또는
      - 전역으로 spring.jpa.properties.default_batch_fetch_size 와 같이 추가해주면 된다.
 ```jpaql
    select
    memberlist0_.team_id as team_id5_24_1_,
    memberlist0_.id as id1_24_1_,
    memberlist0_.id as id1_24_0_,
    memberlist0_.age as age2_24_0_,
    memberlist0_.team_id as team_id5_24_0_,
    memberlist0_.type as type3_24_0_,
    memberlist0_.username as username4_24_0_
    from
    section11member memberlist0_
    where
    memberlist0_.team_id in (
    ?, ?
    )
```


### 정리
- 모든 것을 페치 조인으로 해결할 수는 없음
- 페치 조인은 객체 그래프를 유지할 때 사용하면 효과적이다. t.members 와같이 객체그래프를 유지할 때
- 여러 테이블을 조인해서 엔티티가 가진 모양이 아닌 전혀 다른 결과를 내야 하면, 페치 조인 보다는 일반 조인을 사용하고 
- 필요한 데이터들만 조회해서 DTO로 반환하는 것이 효과적. [통계쿼리와 같은 쿼리들.]
- 엔티티를 페치조인을 통해 조회해서 그대로 쓰거나, 어플리케이션 레벨에서 dto로 변환한다.
- new operation으로 dto로 조회한다.


##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21743&tab=curriculum&category=questionDetail