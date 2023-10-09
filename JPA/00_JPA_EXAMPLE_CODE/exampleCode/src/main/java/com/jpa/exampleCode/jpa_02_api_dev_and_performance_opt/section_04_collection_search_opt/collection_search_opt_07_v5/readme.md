# 컬렉션 조회 최적화

- ToOne관계의 엔티티는 join으로 가져온다 [order, member, delivery]
- 이 후 ToMany관계에 있는 collection들을 이번에는 in절을 통해 orderId를 in절 조건으로 넣는다
- 데이터를 먼저 디비에서 다 가져온 후 어플리케이션 레벨[메모리]에서 map을 만들어 매칭되는 order의
- orderItem에 넣어준다.

- 루트1번 컬렉션 1번
- TOOne 먼저 조회 후, in 절로 OrderItem한번에 조회
- map을 이용해서 매칭 성능 향상