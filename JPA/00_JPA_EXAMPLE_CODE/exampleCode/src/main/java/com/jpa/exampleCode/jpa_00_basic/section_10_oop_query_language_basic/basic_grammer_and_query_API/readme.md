# JPQL 기본 문법과 쿼리

- 엔티티와 속성은 대 소문자를 구분한다. (Member, age)
- 별칭은 필수이다. Member as m , Member m
- 기본적으로 @Entity를 사용할 때 클래스이름을 따라가지만 name 속성으로 정의 가능하다.

### TypeQuery, Query
- TypeQuery: 반환타입이 명확할 때
- Query: 반환타입이 명확하지 않을 때


### getResultList(), getSingleResult()
- getResultList(): 결과가 하나 이상일 때 없으면 빈 리스트 반환
- getSingleResult(): 결과가 하나일 때 결과가 없으면 noResultException
                    결과가 둘 이상일 때는 : NonUniqueResultException


### 파라미터 바인딩
- :[parametername]으로 사용
```java
em.createQuery("select m from Member m where m.username = :username")
```

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21720&tab=curriculum

