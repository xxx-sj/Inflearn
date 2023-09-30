# 값 타입 컬렉션

- 컬렉션으로 저장 시 별도의 테이블로 저장되게 된다.
- 값 타입 컬렉션은 이력 추적이 힘들다.
- 별도의 테이블에서는 모든 데이터를 묶어 PK로 만들며 값 타입을 사용하는
엔티티의 PK를 FK로 갖는다. FK 또한 같이 묶어 PK로 만든다.
- 만약 식별자같은 값을 사용하게 되면 값 타입이 아닌 엔티티가 되어버린다.
- 필요에 따라서는 elementCollection사용이 아니라, 일대다 관계인 entity 사용을 고려하자
- entity에서는 식별자 [id]를 갖고, 내부에 필요한 값 타입을 선언하는 것이다.


```java


```
##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21716&tab=curriculum