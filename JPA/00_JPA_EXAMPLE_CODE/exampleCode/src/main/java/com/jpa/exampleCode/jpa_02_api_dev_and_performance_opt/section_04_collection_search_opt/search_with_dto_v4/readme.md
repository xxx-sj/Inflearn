# JPA에서 DTO 직접 조회

- 일대 다 조인에서 DTO로 조회할 때, 기본적으로 DTO조회 시에는 
- new operation을 사용하여 select절을 조회하는데 이때 일대 다 조인같은경우
- 다를 표현할 수 가 없다. [order(one) / orderItem(many)] 
- 생각해보면 간단하다. order를 조회할 때 orderItem이 many일텐데, 
- 이 때 order의 기본 값은 select 절에서 DTO를 통해 조회는 가능하지만 
- many 관계에 있는 orderItem같은 경우는 여러개를 조회해야 하기 때문에 한번에 불가능 하다.

- 루트 쿼리 1번, 컬렉션 N번 실행
- ToOne관계들을 먼저 조회하고 ToMany 관계는 각각 별도로 처리
  - ToOne관계는 row수가 증가하지 않는다
  - ToMany관계는 row수가 증가하게 된다.
- row 수가 증가하지 않는 ToOne관계는 조인으로 한번에 조회하고,
- ToMany관계와 같은 것은 collection을 조회하는 쿼리를 따로 만들어서 각각 조회한다.

