# 다형성 쿼리

- 조회 대상을 특정 자식으로 한정
- item 중에 Book,Movie를 조회하는 쿼리
  - JPQL
  - select i from Item i where type(i) IN (Book, Movie)
  - SQL
  - select i from i where i.DTYPE in ('Book', 'Movie')

### TREAT (JPA 2.1)
- 자바의 타입 캐스팅과 유사
- 상속 구조에서 부모 타입을 특정 자식 타입으로 다룰 때 사용
- FROM, WHERE, SELECT 절에서 사용
  - singletable 전략 기준
    - select i from item i where treat(i as Book).author = 'kim'
    - select i from Item i where i.DTYPE = 'Book' and i.author = 'kim'

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21729&tab=curriculum&category=questionDetail